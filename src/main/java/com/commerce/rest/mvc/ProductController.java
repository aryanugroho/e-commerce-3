package com.commerce.rest.mvc;

import com.commerce.domain.Product;
import com.commerce.rest.resources.ProductResource;
import com.commerce.rest.resources.asm.ProductResourceAsm;
import com.commerce.service.ProductService;
import com.commerce.util.FileDirectoryCreator;
import com.commerce.util.FileNameGenerator;
import com.commerce.util.JsonToProductObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
@Controller
@RequestMapping("/rest/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;
    private GridFsOperations gridFsOperations;

    @Autowired
    public ProductController(ProductService productService, GridFsOperations gridFsOperations) {
        this.productService = productService;
        this.gridFsOperations = gridFsOperations;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ProductResource> createProductRequest( @RequestParam(value = "product") String productDetail,
                                                                 @RequestParam(value = "file") MultipartFile file,
                                                                 HttpServletRequest request) throws IOException, ClassNotFoundException {

        FileNameGenerator generator = new FileNameGenerator();
        String fileName = generator.generateFileName(file.getOriginalFilename());
        gridFsOperations.store(file.getInputStream(), fileName, file.getContentType()).getId().toString();
        logger.info("File stored : " + fileName);

        JsonToProductObject jsonToProductObject = new JsonToProductObject();
        ProductResource sentProductResource = jsonToProductObject.toProductResource( productDetail );
        sentProductResource.setFileName(fileName);
        Product createdProduct = productService.save( sentProductResource.toProduct() );
        logger.info("Product created ");

        ProductResource res = new ProductResourceAsm().toResource(createdProduct);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<ProductResource>(res, headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/list-by-categgory-name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductByCategoryName(@PathVariable String name) {
        List<Product> productList = productService.getByCategoryName(name);

        for (Product product : productList ) {
            loadFile(product);
        }

        System.out.println("List : " + productList);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);

    }

    @RequestMapping( value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResource> getProductDetail(@PathVariable String id) {
        Product product = productService.getProductDetail(id);
        if (product != null) {
            ProductResource res = new ProductResourceAsm().toResource(product);
            return new ResponseEntity<ProductResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductResource>(HttpStatus.NOT_FOUND);
        }
    }


    public void loadFile(Product product) {

        boolean isImageLoaded = maybeLoadFile(new File(FileDirectoryCreator.getFileDirectoryPath()), product);
        if (isImageLoaded) {
            GridFSDBFile result = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("filename").is(product.getFileName())));
            try {
                result.writeTo(FileDirectoryCreator.getFileDirectoryPath() + product.getFileName());
                logger.info("File load to : " + FileDirectoryCreator.getFileDirectoryPath() + " path");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean maybeLoadFile(File file, Product product) {
        File[] fList = file.listFiles();
        boolean isLoaded = false;
        if (fList.length == 0) {
            return true;
        }
        for (File f : fList) {
            if ( f.getName().equals(product.getFileName())) {
                isLoaded = false;
            } else {
                isLoaded = true;
            }
        }
        return isLoaded;
    }

}

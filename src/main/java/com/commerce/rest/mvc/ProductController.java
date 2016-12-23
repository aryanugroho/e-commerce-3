package com.commerce.rest.mvc;

import com.commerce.domain.Product;
import com.commerce.rest.resources.ProductResource;
import com.commerce.rest.resources.asm.ProductResourceAsm;
import com.commerce.service.ProductService;
import com.commerce.util.FileNameGenerator;
import com.commerce.util.JsonToProductObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;

/**
 * Created by suat on 12/22/16.
 */
@Controller
@RequestMapping("/rest/product")
public class ProductController {

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

        JsonToProductObject jsonToProductObject = new JsonToProductObject();
        ProductResource sentProductResource = jsonToProductObject.toProductResource( productDetail );
        sentProductResource.setFileName(fileName);
        Product createdProduct = productService.save( sentProductResource.toProduct() );

        ProductResource res = new ProductResourceAsm().toResource(createdProduct);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<ProductResource>(res, headers, HttpStatus.CREATED);

    }

}

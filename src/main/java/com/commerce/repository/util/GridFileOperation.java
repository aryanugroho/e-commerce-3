package com.commerce.repository.util;

import com.commerce.domain.dto.FileDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by suat on 12/23/16.
 */
public class GridFileOperation {

    @Autowired
    private GridFsOperations operations;

    public GridFileOperation() {
    }


    public String storeFile(FileDetailDto file) {
        InputStream inputStream = null;
        String storeFileId = null;
        try {

            inputStream = new FileInputStream(file.getDataUrl());
            storeFileId = operations.store(inputStream, file.getFileName(), file.getContentType()).getId().toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return storeFileId;
    }
}
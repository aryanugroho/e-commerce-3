package com.commerce.util;

/**
 * Created by suat on 12/24/16.
 */
public class FileNameGenerator {

    public String generateFileName( String originalFileName ){
        return java.util.UUID.randomUUID() + "-" + originalFileName;
    }

}

package com.commerce.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by suat on 12/24/16.
 */
public class FileDirectoryCreator {

    private final Logger logger = LoggerFactory.getLogger(FileDirectoryCreator.class);

    final String workingDirectory = System.getProperty("user.dir");
    final String fileSeperator = System.getProperty("file.separator");
    final String directoryName = "archieve";
    final String directoryPath = workingDirectory + fileSeperator + "src"+ fileSeperator + "main"+ fileSeperator + "resources"+  fileSeperator + directoryName;

    private static String fileDirectoryPath;

    public void fileDirectory() throws IOException {
        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdir()) {
                logger.info("Directory is created! : " + file.getAbsolutePath());
                setFileDirectoryPath(file.getAbsolutePath() + fileSeperator);
            } else {
                logger.info("Failed to create directory! : " + file.getAbsolutePath());
            }
        } else {
            setFileDirectoryPath(directoryPath + fileSeperator);
        }
    }

    public static String getFileDirectoryPath() {
        return fileDirectoryPath;
    }

    public static void setFileDirectoryPath(String fileDirectoryPath) {
        FileDirectoryCreator.fileDirectoryPath = fileDirectoryPath;
    }
}
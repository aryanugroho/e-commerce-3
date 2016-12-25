package com.commerce;

import com.commerce.util.FileDirectoryCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ECommerceApplication.class, args);

		FileDirectoryCreator fileDirectoryCreator = new FileDirectoryCreator();
		fileDirectoryCreator.fileDirectory();
	}
}

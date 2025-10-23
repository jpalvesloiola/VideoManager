package com.example.videomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Video Manager application.
 * <p>
 * This class initializes and runs the Spring Boot application.
 * </p>
 */
@SpringBootApplication
public class VideoManagerApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args command line arguments passed to the application.
	 */
    public static void main(String[] args) {
        SpringApplication.run(VideoManagerApplication.class, args);
    }
}
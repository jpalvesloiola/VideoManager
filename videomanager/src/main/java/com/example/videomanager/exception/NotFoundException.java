package com.example.videomanager.exception;

/**
 * Custom exception to indicate that a resource was not found.
 * <p>
 * This exception is thrown when a requested resource, such as a video, cannot be found in the system.
 * </p>
 */
public class NotFoundException extends RuntimeException {
    /**
     * Constructs a new NotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
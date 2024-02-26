package com.example.offskate.exception;

/**
 * Exception class for handling resource not found errors.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message The detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
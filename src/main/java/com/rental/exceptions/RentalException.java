package com.rental.exceptions;

// Custom exception class to handle rental-related exceptions
public class RentalException extends Exception {

    // Constructor that accepts a message for the exception
    public RentalException(String message) {
        super(message);  // Call the parent Exception class constructor
    }

    // Constructor that accepts a message and a cause for the exception
    public RentalException(String message, Throwable cause) {
        super(message, cause);  // Call the parent Exception class constructor with cause
    }

    // Constructor that accepts just a cause for the exception
    public RentalException(Throwable cause) {
        super(cause);  // Call the parent Exception class constructor with cause
    }
}

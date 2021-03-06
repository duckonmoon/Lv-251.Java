package com.softserve.edu.lv251.exceptions;


/**
 * Added by Pavlo Kuchereshko.
 * Custom exception for duplicate emails issues.
 */
public class EmailExistsException extends Exception {
    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailExistsException(Throwable cause) {
        super(cause);
    }
}

package com.springproject.webapp.exception.multiplex;

public class MultiplexNotFoundException extends RuntimeException
{
    public MultiplexNotFoundException(String message) {
        super(message);
    }

    public MultiplexNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultiplexNotFoundException(Throwable cause) {
        super(cause);
    }
}

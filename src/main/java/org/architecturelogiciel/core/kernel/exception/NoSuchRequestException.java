package org.architecturelogiciel.core.kernel.exception;

import org.architecturelogiciel.core.kernel.request.Request;

public class NoSuchRequestException extends RuntimeException{
    public NoSuchRequestException(String message) {
        super(message);
    }

    public static NoSuchRequestException withGetClass(Request request) {
        return new NoSuchRequestException(String.format("No such request handler for " + request.getClass().getName()));
    }
}

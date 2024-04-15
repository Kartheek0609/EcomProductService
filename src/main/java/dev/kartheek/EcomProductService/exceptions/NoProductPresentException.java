package dev.kartheek.EcomProductService.exceptions;

public class NoProductPresentException extends RuntimeException{
    public NoProductPresentException(String message) {
        super(message);
    }
}

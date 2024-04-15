package dev.kartheek.EcomProductService.exceptions;

import lombok.Getter;
import lombok.Setter;


public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
}

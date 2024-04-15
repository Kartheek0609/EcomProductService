package dev.kartheek.EcomProductService.exceptions;

import dev.kartheek.EcomProductService.controller.ProductController;
import dev.kartheek.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class,NoProductPresentException.class})
    public ResponseEntity handleProductException(ProductNotFoundException pe){
        ExceptionResponseDTO exceptionResponseDTO= new ExceptionResponseDTO(
                pe.getMessage(), 404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({InvalidInputException.class})
    public ResponseEntity handleInvalidInputException(InvalidInputException ie){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ie.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.BAD_REQUEST);
    }
}

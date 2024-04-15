package dev.kartheek.EcomProductService.exceptions;

import dev.kartheek.EcomProductService.controller.CartController;
import dev.kartheek.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce){
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(
                ce.getMessage(),
                404
        );
        return  new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}

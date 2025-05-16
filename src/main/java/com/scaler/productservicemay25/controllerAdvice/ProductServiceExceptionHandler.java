package com.scaler.productservicemay25.controllerAdvice;

import com.scaler.productservicemay25.dtos.ExceptionDto;
import com.scaler.productservicemay25.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRuntimeException() {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Something went wrong!");
//        exceptionDto.setResolutionDetails("You need to pay more money to get it resolved from us. Thanks!");
//
//        return new ResponseEntity<>(
//                exceptionDto,
//                HttpStatus.UNAUTHORIZED);
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();
        //TODO
        // exceptionDto.setProductId(????);

//        e.printStackTrace();
        exceptionDto.setProductId(e.getProductId());
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setResolution("Please try again with a valid product id");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}

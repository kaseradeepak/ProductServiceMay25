package com.scaler.productservicemay25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDto {
    private Long productId;
    private String message;
    private String resolution;
}

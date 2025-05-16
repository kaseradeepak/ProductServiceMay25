package com.scaler.productservicemay25.exceptions;

import com.scaler.productservicemay25.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
    private Long productId;

    public ProductNotFoundException(Long productId, String message) {
        super(message);
        this.productId = productId;
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}

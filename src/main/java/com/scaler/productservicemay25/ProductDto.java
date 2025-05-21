package com.scaler.productservicemay25;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.scaler.productservicemay25.models.Product}
 */
@Value
public class ProductDto implements Serializable {
    String title;
    Double price;
    String description;
}
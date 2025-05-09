package com.scaler.productservicemay25.dtos;

import com.scaler.productservicemay25.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}

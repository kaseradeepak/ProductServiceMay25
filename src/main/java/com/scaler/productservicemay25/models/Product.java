package com.scaler.productservicemay25.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne
    private Category category;
}

/*
   1              1
Product ------ Category => M:1 -> Id of 1 side on Many Side.
   M              1

1:1 => Id of 1 side on other side.
1:M / M:1 => Id of 1 side on Many Side.
M:M => Mapping Table
 */
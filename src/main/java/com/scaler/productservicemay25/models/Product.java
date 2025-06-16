package com.scaler.productservicemay25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String imgUrl;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn
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
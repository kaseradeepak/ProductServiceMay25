package com.scaler.productservicemay25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    //@Column(unique = true, nullable = false)
    private String title;
}


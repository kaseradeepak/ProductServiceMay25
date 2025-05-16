package com.scaler.productservicemay25.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    //@Column(unique = true, nullable = false)
    private String title;
}


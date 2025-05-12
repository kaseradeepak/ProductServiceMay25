package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    boolean deleteProduct(Long productId);
}

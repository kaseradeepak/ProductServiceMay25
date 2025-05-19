package com.scaler.productservicemay25;

import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceMay25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DataSourcePoolMetadataProvider dataSourcePoolMetadataProvider;

//    public ProductServiceMay25ApplicationTests(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery() {
        Optional<Product> productOptional = productRepository.findById(1L);

        System.out.println("DEBUG-1");

        Product product = productRepository.findProductWithGivenId(1L);

        System.out.println("DEBUG-2");
    }
}

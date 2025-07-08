package com.scaler.productservicemay25;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repositories.CategoryRepository;
import com.scaler.productservicemay25.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceMay25ApplicationTests {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;

//    public ProductServiceMay25ApplicationTests(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Test
//    void contextLoads() {
//    }

//    @Test
//    void insertProductInRDS() {
////        Category category = new Category();
////        category.setTitle("Apple");
////        category = categoryRepository.save(category);
//
////        Product product = new Product();
////        product.setTitle("Apple iPhone 16 pro");
////        product.setDescription("Latest iPhone!");
////        product.setPrice(140000.0);
////        product.setCategory(categoryRepository.findById(1L).get());
////
////        productRepository.save(product);
//    }

//    @Test
//    void testQuery() {
//        //EAGER
////        Optional<Product> productOptional = productRepository.findById(3L);
//
//        //LAZY
//        Optional<Category> categoryOptional = categoryRepository.findById(2L);
//
////        System.out.println("DEBUG");
////
////        List<Product> products = categoryOptional.get().getProducts();
////
////        System.out.println(products.get(0).getTitle());
//
//        //select * from products where category_id = 2L;
//
//        System.out.println("DEBUG");
//    }
}

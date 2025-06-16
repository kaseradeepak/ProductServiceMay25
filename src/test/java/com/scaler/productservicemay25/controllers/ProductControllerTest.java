package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
//    @MockitoBean
//    private ProductService productService;
//
//    @Autowired
//    private ProductController productController;
//
//    //AAA
//    @Test
//    public void testGetSingleProductPositiveCase() throws ProductNotFoundException {
//        //Arrange
////        Long productId = 10L;
////        Product expectedProduct = new Product(); // @198347
////        expectedProduct.setId(productId);
////        expectedProduct.setTitle("iPhone 16");
////        expectedProduct.setPrice(70000.0);
////
////        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);  // @198347
////
////        //Act
////        //Product actualProduct = productController.getSingleProduct(productId);
////
////        //Assert
////        //assertEquals(expectedProduct, actualProduct);
//////        assertEquals(productId, actualProduct.getId());
//////        assertEquals("iPhone 16", actualProduct.getTitle());
//////        assertEquals(70000.0, actualProduct.getPrice());
//    }
//
//    @Test
//    public void testGetSingleProductThrowsProductNotFoundException() throws ProductNotFoundException {
////        ProductNotFoundException productNotFoundException = new ProductNotFoundException("Please pass the correct productId");
////        when(productService.getSingleProduct(-1L))
////                .thenThrow(productNotFoundException);
////
////        Exception exception = assertThrows(
////                                    ProductNotFoundException.class,
////                                    () -> productController.getSingleProduct(-1L)
////                                );
////
////        assertEquals(productNotFoundException.getMessage(), exception.getMessage());
//    }
//
//    public void testGetSingleProductNegativeCase() {
//
//    }
//
//    //TODO: Write test cases for getAllProducts()
}
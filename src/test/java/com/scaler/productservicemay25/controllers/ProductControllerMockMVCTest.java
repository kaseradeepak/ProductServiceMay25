package com.scaler.productservicemay25.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@WebMvcTest(ProductController.class)
public class ProductControllerMockMVCTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private ProductService productService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockitoBean
//    private RestTemplate restTemplate;
//
//    @Test
//    public void testGetAllProductsAPI() throws Exception {
////        Product p1 = new Product();
////        p1.setId(1L);
////        p1.setTitle("iPhone 15");
////        p1.setDescription("iPhone 15");
////        p1.setPrice(50000.0);
////
////        Product p2 = new Product();
////        p2.setId(2L);
////        p2.setTitle("iPhone 16");
////        p2.setDescription("iPhone 16");
////        p2.setPrice(60000.0);
////
////        List<Product> products = new ArrayList<>();
////        products.add(p1);
////        products.add(p2);
////
////        when(productService.getAllProducts())
////                .thenReturn(products);
////
////        String expectedJson = objectMapper.writeValueAsString(products);
////
////        mockMvc.perform(
////                MockMvcRequestBuilders.get(
////                        "/products/"
////                )
////        )
////                .andExpect(status().isOk())
////                .andExpect((ResultMatcher) content().json(expectedJson));
//    }
}

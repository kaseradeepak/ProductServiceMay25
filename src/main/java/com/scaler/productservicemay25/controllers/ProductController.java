package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.commons.AuthCommons;
import com.scaler.productservicemay25.dtos.UserDto;
import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.exceptions.UnAuthorizedException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RestTemplate restTemplate;
    private ProductService productService;
    private AuthCommons authCommons;

    public ProductController(ProductService productService,
                             RestTemplate restTemplate,
                             AuthCommons authCommons) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authCommons = authCommons;
    }

    // localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        //Should we call FakeStore API here ? No, we should make a call to the Service.

        UserDto userDto = authCommons.validateToken("SampleToken");

//        if (userDto == null) {
//            //UnAuthorized access.
//            throw new UnAuthorizedException("Invalid token provided.");
//        }

        return productService.getSingleProduct(productId); // @198347

        //throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity  =
//                new ResponseEntity<>(
//                        productService.getSingleProduct(productId),
//                        HttpStatus.OK
//                );

//        Product product = null;
//        try {
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    // localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/title/{title}/{pageNumber}/{pageSize}")
    public Page<Product> getProductByTitle(@PathVariable("title") String title, @PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
        return productService.getProductsByTitle(title, pageNumber, pageSize);
    }

    // localhost:8080/products
    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRuntimeException() {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Handling exception with the controller.");
//        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    //Update API's
    // updateProduct() -> PATCH
    // replaceProduct() -> PUT

    @GetMapping("/searchByTitle/{title}")
    List<Product> getProductsByTitle(@PathVariable String title) {
        //select * from products where lower(title) LIKE '%iphone%'

        return null;
    }
}

/*
CRUD operations on Product model
 */

/*
    {
        "title" : "iPhone 15 pro",
        "description" : "best iphone ever",
        "price" : "130000",
        ....
    }


 */

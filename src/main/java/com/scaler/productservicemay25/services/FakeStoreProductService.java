package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.dtos.FakeStoreProductDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//Note: This service class will implement all the API's using FakeStore.
@Service("fakeStoreProductService")
@Primary
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

//        throw new RuntimeException("Something went wrong");

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        if (fakeStoreProductDto == null) {
            //Wrong product Id.
            throw new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exist.");
        }

        //Convert FakeStoreProductDto into Product Object.
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponse =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        FakeStoreProductDto[] fakeStoreProductDtos =
                fakeStoreProductDtoResponse.getBody();
        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {}

    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImgUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}

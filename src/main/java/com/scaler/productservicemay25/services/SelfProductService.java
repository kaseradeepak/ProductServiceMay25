package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.repositories.CategoryRepository;
import com.scaler.productservicemay25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//
//        if (optionalProduct.isEmpty()) {
//            throw new ProductNotFoundException("Product with id " + productId + " doesn't exist.");
//        }
//
//        return optionalProduct.get();

        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exist."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /*

    {
        "title" : "Apple airtag",
        "description" : "useless item",
        "price" : "2000.0",
        "category" : {
                        "title" : "tracking device"
                     }
    }

     */
    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {
//        Category category = product.getCategory();
//
//        if (category == null) {
//            throw new CategoryNotFoundException("Product can't be created without category, Please try again with category.");
//        }
//
//        //Find the category with the title
//        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());
//
//        if (optionalCategory.isEmpty()) {
//            //There's no category in the DB with the given title.
//            //Create a category object and save it in the DB.
//            category = categoryRepository.save(category);
//        } else {
//            category = optionalCategory.get();
//        }
//        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {
//        Sort sort = Sort
//                .by(Sort.Direction.ASC, "price")
//                .by(Sort.Direction.DESC, "title");

//        Sort sort = null;
//        if (sortInput.equals("ASC")) {
//            sort = Sort.by(Sort.Direction.ASC, "price");
//        } else {
//            sort = Sort.by(Sort.Direction.DESC, "price");
//        }
//
//        sort.by(......)

        return productRepository.findByTitleContainsIgnoreCase(
                title,
                PageRequest.of(pageNumber,
                        pageSize,
                        Sort.by(Sort.Direction.ASC, "price").by(Sort.Direction.ASC, "title"))
        );
    }
}

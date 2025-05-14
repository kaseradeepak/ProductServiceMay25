package com.scaler.productservicemay25.repositories;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //select * from Product where id = ?
    @Override
    Optional<Product> findById(Long productId);

    //iPhone
    //select * from products where lower(title) LIKE '%iphone%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    //find all the products where price >= 100 and <= 1000
    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    //select * from products where category_id = category.id;
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    //JOIN Query
    List<Product> findAllByCategory_Title(String categoryTitle);

//    @Query("select title from products where id = ?")
//    Optional<Product> findProductTitleById(Long productId);
}


//public interface UserRepository extends JpaRepository<User, Long> {
//
//    List<User> findByLastname(String lastname);
//
//    User findByEmailAddress(String emailAddress);
//}

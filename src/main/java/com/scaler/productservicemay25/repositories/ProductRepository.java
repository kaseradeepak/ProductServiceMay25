package com.scaler.productservicemay25.repositories;

import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //select * from Product where id = ?
    Optional<Product> findById(Long productId);

    //iPhone
    //select * from products where lower(title) LIKE '%iphone%'
    Page<Product> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    //find all the products where price >= 100 and <= 1000
    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    //select * from products where category_id = category.id;
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    //JOIN Query
    List<Product> findAllByCategory_Title(String categoryTitle);

//    @Query("select title from products where id = ?")
//    Optional<Product> findProductTitleById(Long productId);

    Product save(Product product);
    //update + insert => upsert


    @Override
    void deleteById(Long productId);

    //HQL -> We can use models.
    //@Query("select p.id as id, p.title as title from Product p where p.id = :productId")
    //@Query("select p.title as title, p.description as description from Product p where p.id = :id")
    //@Query("select p from Product p where p.id = 1")
    //@Query("SELECT p FROM com.scaler.productservicemay25.models.Product p WHERE p.id = :id")
    //List<Product> findProductWithGivenId(@Param("id") Long productId);

    @Query(value = "select * from products p where p.id = :id", nativeQuery = true)
    Product findProductWithGivenId(@Param("id") Long productId);
}


//public interface UserRepository extends JpaRepository<User, Long> {
//
//    List<User> findByLastname(String lastname);
//
//    User findByEmailAddress(String emailAddress);
//}

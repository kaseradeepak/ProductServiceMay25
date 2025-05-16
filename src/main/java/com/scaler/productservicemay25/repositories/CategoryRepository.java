package com.scaler.productservicemay25.repositories;

import com.scaler.productservicemay25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String name);
}

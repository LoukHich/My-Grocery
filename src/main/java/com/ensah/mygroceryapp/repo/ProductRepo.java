package com.ensah.mygroceryapp.repo;

import com.ensah.mygroceryapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findByRegistresCourseName(String courseName);

    int countDistinctByRegistresCourseName(String name);
}

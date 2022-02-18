package com.armando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.armando.app.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}

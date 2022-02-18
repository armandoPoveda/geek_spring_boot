package com.armando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.armando.app.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}

package com.armando.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.armando.app.entity.Categories;

public interface CategoriesService {

	public Iterable<Categories> findAll();
	
	public Page<Categories> findAll(Pageable pageable);

	public Optional<Categories> findById(Long id);

	public Categories save(Categories categories);

	public void deleteById(Long id);

}

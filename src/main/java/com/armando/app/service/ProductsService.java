package com.armando.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.armando.app.entity.Products;

public interface ProductsService {

public Iterable<Products> findAll();
	
	public Page<Products> findAll(Pageable pageable);	
	
	public Optional<Products> findById(Long id);
	
	public Products save(Products products);
	
	public void deleteById(Long id);
	
}

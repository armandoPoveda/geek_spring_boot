package com.armando.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.armando.app.entity.Products;
import com.armando.app.repository.ProductsRepository;


@Service
public class ProdcutsServiceImpl implements ProductsService{

	@Autowired
	private ProductsRepository productsRepository;
	
	@Transactional(readOnly = true) 
	@Override
	public Iterable<Products> findAll() {
		
		return productsRepository.findAll();
	}

	@Transactional(readOnly = true) 
	@Override
	public Page<Products> findAll(Pageable pageable) {
		
		return productsRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) 
	@Override
	public Optional<Products> findById(Long id) {
		
		return productsRepository.findById(id);
	}

	@Transactional
	@Override
	public Products save(Products products) {
		
		return productsRepository.save(products);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		productsRepository.deleteById(id);
		
	}
}

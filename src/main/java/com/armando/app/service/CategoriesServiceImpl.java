package com.armando.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.armando.app.entity.Categories;
import com.armando.app.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Transactional(readOnly = true) 
	@Override
	public Iterable<Categories> findAll() {
		return categoriesRepository.findAll();
	}

	@Transactional(readOnly = true) 
	@Override
	public Page<Categories> findAll(Pageable pageable) {
		return categoriesRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) 
	@Override
	public Optional<Categories> findById(Long id) {
		return categoriesRepository.findById(id);
	}

	@Transactional
	@Override
	public Categories save(Categories categories) {
		return categoriesRepository.save(categories);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		categoriesRepository.deleteById(id);
		
	}
}

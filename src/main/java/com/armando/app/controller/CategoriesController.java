package com.armando.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armando.app.entity.Categories;
import com.armando.app.service.CategoriesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	// Create new category
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Categories category) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriesService.save(category));

	}

	// Read category
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long categoryId) {
		Optional<Categories> oCategory = categoriesService.findById(categoryId);

		if (!oCategory.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oCategory);
	}

	// Update an Categories
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Categories categoryDetails,
			@PathVariable(value = "id") Long categoryId) {
		Optional<Categories> category = categoriesService.findById(categoryId);
		if (!category.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// BeanUtils.copyProperties(clientsDetails, clients.get());
		category.get().setName(categoryDetails.getName());
		category.get().setDescription(categoryDetails.getDescription());
		category.get().setProducts(categoryDetails.getProducts());
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriesService.save(categoryDetails));

	}

	// Delete an Categories
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long categoryId) {

		if (!categoriesService.findById(categoryId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		categoriesService.deleteById(categoryId);
		return ResponseEntity.ok().build();
	}

	// Read all Categories
	@GetMapping
	public List<Categories> readAll() {
		List<Categories> categories = StreamSupport.stream(categoriesService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return categories;
	}

}

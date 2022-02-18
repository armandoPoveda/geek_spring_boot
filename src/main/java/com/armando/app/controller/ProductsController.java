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

import com.armando.app.entity.Products;
import com.armando.app.service.ProductsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/products")
public class ProductsController {

	
	@Autowired
	private ProductsService productsService;
	
	
		// Create new Products
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Products products) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(productsService.save(products));
		}

		// Read Products
		@GetMapping("/{id}")
		public ResponseEntity<?> read(@PathVariable(value = "id") Long productId) {
			Optional<Products> oProducts = productsService.findById(productId);

			if (!oProducts.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(oProducts);

		}

		// Update an Products
		@PutMapping("/{id}")
		public ResponseEntity<?> update(@RequestBody Products productsDetails, @PathVariable(value = "id") Long productId) {
			Optional<Products> products = productsService.findById(productId);
			if (!products.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			// BeanUtils.copyProperties(clientsDetails, clients.get());
			products.get().setName(productsDetails.getName());
			products.get().setPrice(productsDetails.getPrice());
			products.get().setQuantity(productsDetails.getQuantity());
			//products.get().setCat(productsDetails.getCat());
			return ResponseEntity.status(HttpStatus.CREATED).body(productsService.save(productsDetails));
		}

		// Delete an Products
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") Long productId) {

			if (!productsService.findById(productId).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			productsService.deleteById(productId);
			return ResponseEntity.ok().build();
		}

		// Read all Products
		@GetMapping
		public List<Products> readAll() {
			List<Products> products = StreamSupport.stream(productsService.findAll().spliterator(), false)
					.collect(Collectors.toList());
			return products;
		}
	
}

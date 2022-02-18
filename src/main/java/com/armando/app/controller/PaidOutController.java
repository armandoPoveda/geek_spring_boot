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

import com.armando.app.entity.PaidOut;
import com.armando.app.service.PaidOutService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/paid_out")
public class PaidOutController {

	@Autowired
	private PaidOutService paidOutService;
	
		// Create new products
		@PostMapping
		public ResponseEntity<?> create(@RequestBody PaidOut paidOut) {
			return ResponseEntity.status(HttpStatus.CREATED).body(paidOutService.save(paidOut));
		}
		
		// Read products
		@GetMapping("/{id}")
		public ResponseEntity<?> read(@PathVariable(value = "id") Integer paidOutId) {
			Optional<PaidOut> oPaidOut = paidOutService.findById(paidOutId);

			if (!oPaidOut.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(oPaidOut);
		}
		
		
		// Update an products
		@PutMapping("/{id}")
		public ResponseEntity<?> update(@RequestBody PaidOut paidOutDetails, @PathVariable(value = "id") Integer paidOutId) {
			Optional<PaidOut> paidOut = paidOutService.findById(paidOutId);
			if (!paidOut.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			// BeanUtils.copyProperties(clientsDetails, clients.get());
//			paidOut.get().setProducts(paidOutDetails.getProducts());
//			paidOut.get().setCart(paidOutDetails.getCart());
			paidOut.get().setQuantity(paidOutDetails.getQuantity());
			paidOut.get().setPrice(paidOutDetails.getPrice());

			return ResponseEntity.status(HttpStatus.CREATED).body(paidOutService.save(paidOutDetails));

		}

		// Delete an products
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") Integer paidOutId) {

			if (!paidOutService.findById(paidOutId).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			paidOutService.deleteById(paidOutId);
			return ResponseEntity.ok().build();
		}

		// Read all products
		@GetMapping
		public List<PaidOut> readAll() {
			List<PaidOut> productShops = StreamSupport.stream(paidOutService.findAll().spliterator(), false)
					.collect(Collectors.toList());

			return productShops;
		}
		
}

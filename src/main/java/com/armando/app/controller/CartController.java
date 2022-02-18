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

import com.armando.app.entity.Cart;
import com.armando.app.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	// Create new shopping
			@PostMapping
			public ResponseEntity<?> create(@RequestBody Cart cart) {
				return ResponseEntity.status(HttpStatus.CREATED).body(cartService.save(cart));
			}
			
			// Read shopping
			@GetMapping("/{id}")
			public ResponseEntity<?> read(@PathVariable(value = "id") Long cartId) {
				Optional<Cart> oCart = cartService.findById(cartId);

				if (!oCart.isPresent()) {
					return ResponseEntity.notFound().build();
				}

				return ResponseEntity.ok(oCart);
			}
			
			
			// Update an shopping
			@PutMapping("/{id}")
			public ResponseEntity<?> update(@RequestBody Cart cartDetails, @PathVariable(value = "id") Long cartId) {
				Optional<Cart> cart = cartService.findById(cartId);
				if (!cart.isPresent()) {
					return ResponseEntity.notFound().build();
				}
				// BeanUtils.copyProperties(clientsDetails, clients.get());
				cart.get().setDate(cartDetails.getDate());
				cart.get().setPay_method(cartDetails.getPay_method());
				cart.get().setStatus(cartDetails.getStatus());

				return ResponseEntity.status(HttpStatus.CREATED).body(cartService.save(cartDetails));

			}

			// Delete an shopping
			@DeleteMapping("/{id}")
			public ResponseEntity<?> delete(@PathVariable(value = "id") Long cartId) {

				if (!cartService.findById(cartId).isPresent()) {
					return ResponseEntity.notFound().build();
				}
				cartService.deleteById(cartId);
				return ResponseEntity.ok().build();
			}

			// Read all shopping
			@GetMapping
			public List<Cart> readAll() {
				List<Cart> cart = StreamSupport.stream(cartService.findAll().spliterator(), false)
						.collect(Collectors.toList());

				return cart;
			}
	
}

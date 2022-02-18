package com.armando.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.armando.app.entity.Cart;

public interface CartService {
	public Iterable<Cart> findAll();

	public Page<Cart> findAll(Pageable pageable);

	public Optional<Cart> findById(Long id);

	public Cart save(Cart cart);

	public void deleteById(Long id);
}

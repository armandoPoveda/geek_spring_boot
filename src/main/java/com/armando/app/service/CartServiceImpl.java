package com.armando.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.armando.app.entity.Cart;
import com.armando.app.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Transactional(readOnly = true) 
	@Override
	public Iterable<Cart> findAll() {
		
		return cartRepository.findAll();
	}
	
	@Transactional(readOnly = true) 
	@Override
	public Page<Cart> findAll(Pageable pageable) {
		
		return cartRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) 
	@Override
	public Optional<Cart> findById(Long id) {
		
		return cartRepository.findById(id);
	}

	@Transactional
	@Override
	public Cart save(Cart cart) {
		
		return cartRepository.save(cart);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}
}

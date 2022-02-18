package com.armando.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.armando.app.entity.Clients;

public interface ClientsService {

	public Iterable<Clients> findAll();
	
	public Page<Clients> findAll(Pageable pageable);	
	
	public Optional<Clients> findById(Long id);
	
	public Clients save(Clients clients);
	
	public void deleteById(Long id);
}

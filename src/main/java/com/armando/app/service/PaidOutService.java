package com.armando.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.armando.app.entity.PaidOut;

public interface PaidOutService {

	
	public Iterable<PaidOut> findAll();

	public Page<PaidOut> findAll(Pageable pageable);

	public Optional<PaidOut> findById(Integer id);

	public PaidOut save(PaidOut paidOut);

	public void deleteById(Integer id);
	
}

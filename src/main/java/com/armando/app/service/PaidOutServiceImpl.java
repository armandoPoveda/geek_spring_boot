package com.armando.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.armando.app.entity.PaidOut;
import com.armando.app.repository.PaidOutRepository;

@Service
public class PaidOutServiceImpl implements PaidOutService{

	@Autowired
	private PaidOutRepository paidOutRepository;
	
	@Transactional(readOnly = true) 
	@Override
	public Iterable<PaidOut> findAll() {
		
		return paidOutRepository.findAll();
	}

	@Transactional(readOnly = true) 
	@Override
	public Page<PaidOut> findAll(Pageable pageable) {
		
		return paidOutRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) 
	@Override
	public Optional<PaidOut> findById(Integer id) {
		
		return paidOutRepository.findById(id);
	}

	@Transactional
	@Override
	public PaidOut save(PaidOut paidOut) {
		
		return paidOutRepository.save(paidOut);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		paidOutRepository.deleteById(id);
		
	}

}

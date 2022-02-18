package com.armando.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.armando.app.entity.Clients;
import com.armando.app.repository.ClientsRepository;

@Service
public class ClientsServiceImpl implements ClientsService{

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Override
	@Transactional(readOnly = true) 
	public Iterable<Clients> findAll() {
		// TODO Auto-generated method stub
		return clientsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) 
	public Page<Clients> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clientsRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) 
	public Optional<Clients> findById(Long id) {
		// TODO Auto-generated method stub
		return clientsRepository.findById(id);
	}

	@Override
	@Transactional
	public Clients save(Clients clients) {
		// TODO Auto-generated method stub
		return clientsRepository.save(clients);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		clientsRepository.deleteById(id);
		
	}

}

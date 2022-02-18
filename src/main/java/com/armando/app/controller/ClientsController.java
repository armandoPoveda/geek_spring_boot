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

import com.armando.app.entity.Clients;
import com.armando.app.service.ClientsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/clients")
public class ClientsController {

	@Autowired
	private ClientsService clientsService;

	// Create new User
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Clients clients) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientsService.save(clients));
	}

	// Read User
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long clientId) {
		Optional<Clients> oClients = clientsService.findById(clientId);

		if (!oClients.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oClients);

	}

	// Update an User
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Clients clientsDetails, @PathVariable(value = "id") Long clientId) {
		Optional<Clients> clients = clientsService.findById(clientId);
		if (!clients.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// BeanUtils.copyProperties(clientsDetails, clients.get());
		clients.get().setName(clientsDetails.getName());
		clients.get().setSurname(clientsDetails.getSurname());
		clients.get().setEmail(clientsDetails.getEmail());
		clients.get().setPhone(clientsDetails.getPhone());
		clients.get().setDate_birth(clientsDetails.getDate_birth());
		//clients.get().setCart(clientsDetails.getCart());
		return ResponseEntity.status(HttpStatus.CREATED).body(clientsService.save(clientsDetails));

	}

	// Delete an User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long clientId) {

		if (!clientsService.findById(clientId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clientsService.deleteById(clientId);
		return ResponseEntity.ok().build();
	}

	// Read all Users
	@GetMapping
	public List<Clients> readAll() {
		List<Clients> clients = StreamSupport.stream(clientsService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return clients;
	}
}

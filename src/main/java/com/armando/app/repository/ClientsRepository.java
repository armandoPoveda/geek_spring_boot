package com.armando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.armando.app.entity.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long>{

}

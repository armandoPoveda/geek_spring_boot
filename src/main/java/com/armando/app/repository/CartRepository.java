package com.armando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.armando.app.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
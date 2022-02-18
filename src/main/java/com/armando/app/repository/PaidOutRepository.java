package com.armando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.armando.app.entity.PaidOut;


@Repository
public interface PaidOutRepository extends JpaRepository<PaidOut, Integer>{

}

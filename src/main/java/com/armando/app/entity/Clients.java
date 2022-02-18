package com.armando.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients implements Serializable{

	private static final long serialVersionUID = 4405649284643606072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length = 50)
	private String name;
	
	@Column(nullable=false, length = 50)
	private String surname;
	
	@Column(nullable=false, length = 50)
	private Date date_birth;
	
	@Column(nullable=false, length = 50)
	private String phone;
	
	@Column(nullable=false, length = 50, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "clients")
    private Set<Cart> cart;
	
	public Clients() {
		super();
	}

	public Clients(Long id, String name, String surname, Date date_birth, String phone, String email,
			Set<Cart> cart) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.date_birth = date_birth;
		this.phone = phone;
		this.email = email;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getDate_birth() {
		return date_birth;
	}
	
	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}

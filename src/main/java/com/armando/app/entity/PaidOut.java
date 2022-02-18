package com.armando.app.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paid_out")
public class PaidOut implements Serializable {

	private static final long serialVersionUID = 4405649284643606072L;

	@Id
	@Column(nullable = false, length = 255)
	private Integer id;

	@Column(nullable = false, length = 255)
	private Float quantity;

	@Column(nullable = false, length = 255)
	private Integer price;

	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Products products;

//	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Products> products;

	@ManyToOne()
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public PaidOut() {
		super();
	}

	public PaidOut(Integer id, Float quantity, Integer price, Products products, Cart cart) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.products = products;
		this.cart = cart;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

//	public Cart getCart() {
//		return cart;
//	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}

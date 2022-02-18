package com.armando.app.entity;

import java.io.Serializable;
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

import org.aspectj.weaver.tools.Trace;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "categories")

public class Categories implements Serializable {
	
	private static final long serialVersionUID = 4405649284643606072L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length = 50)
	private String name;
	
	@Column(nullable=false, length = 255)
	private String description;
	
	@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products;

	public Categories(Long id, String name, String description, List<Products> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
	}

	public Categories() {
		super();
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

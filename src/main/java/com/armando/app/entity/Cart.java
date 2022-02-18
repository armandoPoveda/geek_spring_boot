package com.armando.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

	private static final long serialVersionUID = 4405649284643606072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private Date date;

	@Column(nullable = false, length = 50)
	private String pay_method;

	@Column(nullable = false)
	private String status;

	@ManyToOne()
	@JoinColumn(name = "client_id")
	private Clients clients;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PaidOut> paidOuts;

	public Cart() {
		super();
	}

	public Cart(Long id, Date date, String pay_method, String status, Clients clients, List<PaidOut> paidOuts) {
		super();
		this.id = id;
		this.date = date;
		this.pay_method = pay_method;
		this.status = status;
		this.clients = clients;
		this.paidOuts = paidOuts;
	}

	//	public Clients getClients() {
	//	return clients;
	//}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public List<PaidOut> getPaidOuts() {
		return paidOuts;
	}

	public void setPaidOuts(List<PaidOut> paidOuts) {
		this.paidOuts = paidOuts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

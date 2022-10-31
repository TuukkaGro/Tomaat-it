package com.tomaatit.DogClothing.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clothing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String name;
	private String type;
	private double price;
	private String producer;
	
	public Clothing(Long id, String name, String type, double price, String producer) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.producer = producer;
	}

	public Clothing(String name, String type, double price, String producer) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.producer = producer;
	}

	public Clothing() {
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Clothing [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", producer="
				+ producer + "]";
	}
	
	
	
	
	

}
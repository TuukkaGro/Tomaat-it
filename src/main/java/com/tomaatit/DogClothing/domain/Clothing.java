package com.tomaatit.DogClothing.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Clothing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Name is required.")
	private String name;

	@NotBlank(message = "Type is required.")
	private String type;
	
	@Min(value=1)
	private double price;

	@ManyToOne
	@JoinColumn(name = "producerid")
	private Producer producer;

	public Clothing() {
		super();
	}

	public Clothing(String name, String type, double price, Producer producer) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.producer = producer;
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

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Clothing [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", producer="
				+ producer + "]";
	}

}
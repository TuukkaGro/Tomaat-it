package com.tomaatit.DogClothing.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long producerid;
	private String name;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producer")
	private List<Clothing> clothings;
	
	public Producer(String name) {
		super();
		this.name = name;
	}

	public Producer() {
		super();
	}

	public Long getProducerid() {
		return producerid;
	}

	public void setProducerid(Long producerid) {
		this.producerid = producerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Clothing> getClothings() {
		return clothings;
	}

	public void setClothings(List<Clothing> clothings) {
		this.clothings = clothings;
	}

	

}

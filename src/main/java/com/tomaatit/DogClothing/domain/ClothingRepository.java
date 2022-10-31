package com.tomaatit.DogClothing.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ClothingRepository extends CrudRepository<Clothing, Long> {
	
	List<Clothing> findByName(String name);

}

package com.tomaatit.DogClothing.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomaatit.DogClothing.domain.Clothing;
import com.tomaatit.DogClothing.domain.ClothingRepository;
import com.tomaatit.DogClothing.domain.Producer;
import com.tomaatit.DogClothing.domain.ProducerRepository;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
public class ClothingRestController {
	@Autowired
	private ClothingRepository repository;
	@Autowired
	private ProducerRepository prepository;

	// gets a list of all clothes
	@GetMapping("/api/clothes")
	List<Clothing> all() {
		return (List<Clothing>) repository.findAll();
	}

	// save new clothing
	@PostMapping("/api/clothes")
	Clothing newClothing(@RequestBody Clothing newClothing) {
		return repository.save(newClothing);
	}

	// find clothing by id
	@GetMapping("/api/clothes/{id}")
	Optional<Clothing> one(@PathVariable Long id) {

		return repository.findById(id);
	}

	// editing an entry in clothing
	@PutMapping("/api/clothes/{id}")
	Clothing replaceClothing(@RequestBody Clothing newClothing, @PathVariable Long id) {

		return repository.findById(id).map(clothing -> {
			clothing.setName(newClothing.getName());
			clothing.setType(newClothing.getType());
			clothing.setPrice(newClothing.getPrice());
			clothing.setProducer(newClothing.getProducer());
			return repository.save(clothing);
		}).orElseGet(() -> {
			newClothing.setId(id);
			return repository.save(newClothing);
		});
	}

	// delete a piece of clothing from the database
	@DeleteMapping("api/clothes/{id}")
	void deleteClothing(@PathVariable Long id) {
		repository.deleteById(id);
	}

	// find a list of all producers
	@GetMapping("/api/producers")
	List<Producer> allProducers() {
		return (List<Producer>) prepository.findAll();
	}

	// save a new entry to producers
	@PostMapping("/api/producers")
	@PreAuthorize("hasAuthority('ADMIN')")
	Producer newProducer(@RequestBody Producer newProducer) {
		return prepository.save(newProducer);
	}

	// find a specific producer by id
	@GetMapping("/api/producers/{id}")
	Optional<Producer> oneProducer(@PathVariable Long id) {
		return prepository.findById(id);
	}

	// edit an entry in producers
	@PutMapping("/api/producers/{id}")
	Producer replaceProducer(@RequestBody Producer newProducer, @PathVariable Long id) {

		return prepository.findById(id).map(producer -> {
			producer.setName(newProducer.getName());
			return prepository.save(producer);
		}).orElseGet(() -> {
			newProducer.setProducerid(id);
			return prepository.save(newProducer);
		});
	}

	// delete a producer
	@DeleteMapping("api/producers/{id}")
	void deleteProducer(@PathVariable Long id) {
		prepository.deleteById(id);
	}

}

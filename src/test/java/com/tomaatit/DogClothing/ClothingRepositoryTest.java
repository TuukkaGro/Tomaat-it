package com.tomaatit.DogClothing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tomaatit.DogClothing.domain.Clothing;
import com.tomaatit.DogClothing.domain.ClothingRepository;
import com.tomaatit.DogClothing.domain.Producer;
import com.tomaatit.DogClothing.domain.ProducerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClothingRepositoryTest {

	@Autowired
	private ClothingRepository repository;
	@Autowired
	private ProducerRepository prepository;

	@Test
	public void findByNameShouldReturnClothing() {
		// find all entries with the type Haalari
		List<Clothing> clothings = repository.findByType("Haalari");

		// check that the amount of entries matches the in-memory entries of that type
		assertThat(clothings).hasSize(2);
		// check that the program can find the correct name of the first entry
		// "JoustavaMeno"
		assertThat(clothings.get(0).getName()).isEqualTo("JoustavaMeno");
	}

	@Test
	public void createNewClothing() {
		// create a new clothing entry into the database
		Clothing clothing = new Clothing("KivaVaate", "Haalari", 12.00, null);
		repository.save(clothing);
		// check that the new entry id exists
		assertThat(clothing.getId()).isNotNull();
	}

	@Test
	public void createNewProducer() {
		// create a new producer entry into the database
		Producer producer = new Producer("Vilkkeri");
		prepository.save(producer);
		// check that the new entry id exists
		assertThat(producer.getProducerid()).isNotNull();
	}

}

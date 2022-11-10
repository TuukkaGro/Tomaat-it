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

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClothingRepositoryTest {

	@Autowired
	private ClothingRepository repository;

	@Test
	public void findByNameShouldReturnClothing() {
		List<Clothing> clothings = repository.findByName("JoustavaMeno");

		assertThat(clothings).hasSize(1);
		assertThat(clothings.get(0).getName()).isEqualTo("JoustavaMeno");
	}

	@Test
	public void createNewClothing() {
		Clothing clothing = new Clothing("70-luku", "Haalari", 32.00, null);
		repository.save(clothing);
		assertThat(clothing.getId()).isNotNull();
	}

}

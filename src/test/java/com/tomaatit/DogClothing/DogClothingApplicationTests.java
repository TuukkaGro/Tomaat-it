package com.tomaatit.DogClothing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tomaatit.DogClothing.web.ClothingController;
import com.tomaatit.DogClothing.web.ClothingRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DogClothingApplicationTests {
	@Autowired
	private ClothingController controller;

	@Autowired
	private ClothingRestController rcontroller;

	// testing that ClothingController isn't empty
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	// same but REST
	@Test
	public void contextLoads1() throws Exception {
		assertThat(rcontroller).isNotNull();
	}
}
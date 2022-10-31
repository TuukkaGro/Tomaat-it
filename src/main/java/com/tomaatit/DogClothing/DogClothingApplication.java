package com.tomaatit.DogClothing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tomaatit.DogClothing.domain.Clothing;
import com.tomaatit.DogClothing.domain.ClothingRepository;



@SpringBootApplication
public class DogClothingApplication {
	private static final Logger log = LoggerFactory.getLogger(DogClothingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DogClothingApplication.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner clothingDemo(ClothingRepository repository) {
		return (args) -> {
			log.info("save some clothing");
			//mock up clothes
			repository.save(new Clothing("JoustavaMeno", "Haalari", 59.00, "M&M"));
			repository.save(new Clothing("70-luku", "Haalari", 32.00, "Leikki"));
			
			log.info("fetch all clothing");
			for (Clothing clothing : repository.findAll()) {
				log.info(clothing.toString());
				
		}
			
		};
	}
	
}



package com.tomaatit.DogClothing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomaatit.DogClothing.domain.ClothingRepository;

@Controller
public class ClothingController {
	@Autowired
	private ClothingRepository repository;
	
	@RequestMapping(value= {"/", "/home"})
	public String frontPage(Model model) {
		return "index";
	}
	
	@RequestMapping(value= {"/clothinglist"})
	public String clothingList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "clothinglist";
	}
	

}

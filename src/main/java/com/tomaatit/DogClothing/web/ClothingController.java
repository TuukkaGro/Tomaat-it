package com.tomaatit.DogClothing.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tomaatit.DogClothing.domain.Clothing;
import com.tomaatit.DogClothing.domain.ClothingRepository;
import com.tomaatit.DogClothing.domain.Producer;
import com.tomaatit.DogClothing.domain.ProducerRepository;

@Controller

public class ClothingController {
	@Autowired
	private ClothingRepository repository;
	
	@Autowired
	ProducerRepository prepository;
	
	@RequestMapping(value= {"/", "/home"})
	public String frontPage(Model model) {
		return "index";
	}
	
	@RequestMapping(value= {"/clothinglist"})
	public String clothingList(Model model) {
		model.addAttribute("clothes", repository.findAll());
		return "clothinglist";
	}
	
	@RequestMapping(value= {"/producerlist"})
	public String producerList(Model model) {
		model.addAttribute("producer", prepository.findAll());
		return "producerlist";
	}
	
	@RequestMapping(value = "/add")
	public String addClothing(Model model){
		model.addAttribute("clothing", new Clothing());
		model.addAttribute("producer", prepository.findAll());
		return "addclothing";
	}
	
	@RequestMapping(value = "/addproducer")
	public String addProducer(Model model){
		model.addAttribute("producer", new Producer());
		return "addproducer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Clothing clothing, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			model.addAttribute("producer", prepository.findAll());
        	return "addclothing";
        }
		repository.save(clothing);
		return "redirect:clothinglist";
	}
	
	@RequestMapping(value = "/saveproducer", method = RequestMethod.POST)
	public String saveProducer(Producer producer){
		prepository.save(producer);
		return "redirect:producerlist";
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteClothing(@PathVariable("id") Long id, Model model){
		repository.deleteById(id);
		return "redirect:../clothinglist";
	}
	
	@RequestMapping(value = "/deleteproducer/{id}", method = RequestMethod.GET)
	public String deleteProducer(@PathVariable("id") Long id, Model model){
		prepository.deleteById(id);
		return "redirect:../producerlist";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editClothing(@PathVariable("id") Long clothingId, Model model) {
		model.addAttribute("clothing", repository.findById(clothingId));
		model.addAttribute("producer", prepository.findAll());
		return "editclothing";
	}
	
	

}

package com.tomaatit.DogClothing.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomaatit.DogClothing.domain.Clothing;
import com.tomaatit.DogClothing.domain.ClothingRepository;
import com.tomaatit.DogClothing.domain.Producer;
import com.tomaatit.DogClothing.domain.ProducerRepository;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@Controller
public class ClothingController {
	@Autowired
	private ClothingRepository repository;

	@Autowired
	private ProducerRepository prepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/", "/home" })
	public String frontPage(Model model) {
		return "index";
	}

	@RequestMapping(value = { "/clothinglist" })
	public String clothingList(Model model) {
		model.addAttribute("clothes", repository.findAll());
		return "clothinglist";
	}

	@RequestMapping(value = { "/producerlist" })
	public String producerList(Model model) {
		model.addAttribute("producer", prepository.findAll());
		return "producerlist";
	}

	// RESTful service to get all clothing
	@RequestMapping(value = "/clothes", method = RequestMethod.GET)
	public @ResponseBody List<Clothing> booklistRest() {
		return (List<Clothing>) repository.findAll();
	}

	// RESTful service to get clothing by id
	@RequestMapping(value = "/clothing/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Clothing> findClothingRest(@PathVariable("id") Long clothingId) {
		return repository.findById(clothingId);
	}

	// add clothing. ADMIN only.
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addClothing(Model model) {
		model.addAttribute("clothing", new Clothing());
		model.addAttribute("producer", prepository.findAll());
		return "addclothing";
	}

	// add a producer. ADMIN only.
	@RequestMapping(value = "/addproducer")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addProducer(Model model) {
		model.addAttribute("producer", new Producer());
		return "addproducer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveClothing(@Valid Clothing clothing, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("producer", prepository.findAll());
			return "addclothing";
		}
		repository.save(clothing);
		return "redirect:clothinglist";
	}

	// save a new producer to the list. ADMIN only.
	@RequestMapping(value = "/saveproducer", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveProducer(Producer producer) {
		prepository.save(producer);
		return "redirect:producerlist";
	}

	// show all clothing of a producer
	@RequestMapping(value = "/showclothes/{id}", method = RequestMethod.GET)
	public String showClothes(@PathVariable("id") Long id) {
		return "redirect:/rest/producers/" + id + "/clothings";
	}

	// delete clothing. ADMIN only.
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteClothing(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../clothinglist";
	}

	// delete producer. ADMIN only.
	@RequestMapping(value = "/deleteproducer/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteProducer(@PathVariable("id") Long id, Model model) {
		prepository.deleteById(id);
		return "redirect:../producerlist";
	}

	// edit producer. ADMIN only.
	@RequestMapping(value = "/editproducer/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editProducer(@PathVariable("producerid") Long producerId, Model model) {
		model.addAttribute("producer", prepository.findById(producerId));
		return "editproducer";
	}

	// edit clothing. ADMIN only.
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editClothing(@PathVariable("id") Long clothingId, Model model) {
		model.addAttribute("clothing", repository.findById(clothingId));
		model.addAttribute("producer", prepository.findAll());
		return "editclothing";
	}

	// save new clothing item. ADMIN only.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String save(@Valid Clothing clothing, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("producer", prepository.findAll());
			return "editclothing";
		}
		repository.save(clothing);
		return "redirect:clothinglist";
	}

}

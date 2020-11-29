package com.waracle.cakemgr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;

@Controller
public class HomeController {

	private final CakeService cakeService;

	@Autowired
	public HomeController(CakeService cakeService) {
		super();
		this.cakeService = cakeService;
	}

	@PostMapping("/")
	public String create(@Valid Cake cake, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			if (!cakeService.existsByTitle(cake.getTitle())) {
				Cake saved = cakeService.save(cake);
				model.addAttribute("saved", saved);
				cake = new Cake();
			} else {
				model.addAttribute("exists", "The title '" + cake.getTitle() + "' already exists in the db");
			}
		}
		List<Cake> cakes = cakeService.findAll();
		model.addAttribute("cakes", cakes);
		model.addAttribute("cake", cake);
		return "home";
	}

	@GetMapping("/")
	public String home(Model model) {
		List<Cake> cakes = cakeService.findAll();
		Cake cake = new Cake();
		model.addAttribute("cakes", cakes);
		model.addAttribute("cake", cake);
		return "home";
	}
}

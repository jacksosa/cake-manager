package com.waracle.cakemgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemgr.exceptions.CakeIdMismatchException;
import com.waracle.cakemgr.exceptions.CakeNotFoundException;
import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;

@RestController
@RequestMapping("/cakes")
public class CakeController {

	private final CakeService cakeService;

	@Autowired
	public CakeController(CakeService cakeService) {
		super();
		this.cakeService = cakeService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cake create(@RequestBody Cake cake) {
		return cakeService.save(cake);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		cakeService.findById(id).orElseThrow(CakeNotFoundException::new);
		cakeService.deleteById(id);
	}

	@GetMapping
	public List<Cake> findAll() {
		List<Cake> cakes = cakeService.findAll();
		return cakes;
	}

	@GetMapping("/{id}")
	public Cake findById(@PathVariable Long id) {
		return cakeService.findById(id).orElseThrow(CakeNotFoundException::new);
	}

	@GetMapping("/title/{title}")
	public Cake findByTitle(@PathVariable String title) {
		return cakeService.findByTitle(title);
	}

	@PutMapping("/{id}")
	public Cake update(@RequestBody Cake cake, @PathVariable Long id) throws CakeIdMismatchException {
		if (cake.getId() != id) {
			throw new CakeIdMismatchException();
		}
		cakeService.findById(id).orElseThrow(CakeNotFoundException::new);
		return cakeService.save(cake);
	}
}

package com.waracle.cakemgr.service;

import java.util.List;
import java.util.Optional;

import com.waracle.cakemgr.model.Cake;

public interface CakeService {

	void deleteById(Long id);

	boolean existsByTitle(String title);

	List<Cake> findAll();

	Optional<Cake> findById(Long id);

	Cake findByTitle(String title);

	Cake save(Cake cake);

}

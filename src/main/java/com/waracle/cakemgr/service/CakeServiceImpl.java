package com.waracle.cakemgr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.repo.CakeRepository;

@Service
public class CakeServiceImpl implements CakeService {

	private final CakeRepository cakeRepository;

	@Autowired
	public CakeServiceImpl(CakeRepository cakeRepository) {
		super();
		this.cakeRepository = cakeRepository;
	}

	@Override
	public void deleteById(Long id) {
		cakeRepository.deleteById(id);
	}

	@Override
	public boolean existsByTitle(String title) {
		return cakeRepository.existsByTitle(title);
	}

	@Override
	public List<Cake> findAll() {
		return cakeRepository.findAll();
	}

	@Override
	public Optional<Cake> findById(Long id) {
		return cakeRepository.findById(id);
	}

	@Override
	public Cake findByTitle(String title) {
		return cakeRepository.findByTitle(title);
	}

	@Override
	public Cake save(Cake cake) {
		return cakeRepository.save(cake);
	}
}

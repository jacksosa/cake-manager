package com.waracle.cakemgr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waracle.cakemgr.model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

	boolean existsByTitle(String title);

	Cake findByTitle(String title);

}

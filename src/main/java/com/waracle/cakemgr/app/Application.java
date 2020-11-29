package com.waracle.cakemgr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.waracle.cakemgr.repo")
@EntityScan("com.waracle.cakemgr.model")
@ComponentScans(value = { @ComponentScan("com.waracle.cakemgr.config"), @ComponentScan("com.waracle.cakemgr.service") })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
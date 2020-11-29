package com.waracle.cakemgr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScans(value = { @ComponentScan("com.waracle.cakemgr") })
public class AppConfig implements WebMvcConfigurer {

}
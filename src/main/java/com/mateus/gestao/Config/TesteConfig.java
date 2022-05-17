package com.mateus.gestao.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mateus.gestao.Service.DBService;

@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	DBService dbService;
	
	@Bean
	public void intanciaDB() {
		
		this.dbService.intanciaGestao();
		
	}
}

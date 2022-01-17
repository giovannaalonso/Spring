package com.helloworld.exercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/exercicio")
	public class ExercicioController {

			
			@GetMapping 
			public String exercicio() {
				
				return " Utilizei as habilidades de persistencia, atenção aos detalhes e orientação ao futuro";

		}
		
	}

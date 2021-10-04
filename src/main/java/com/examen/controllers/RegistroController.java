package com.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.models.entity.Registro;
import com.examen.services.RegistroService;

@RestController
@RequestMapping("/api")
public class RegistroController {
	
	@Autowired
	private RegistroService registroService;
	
	@GetMapping("/registros")
	public List<Registro> obtenerRegistros(){
		return registroService.findAll();
	}
	
	@GetMapping("/registros/page/{page}")
	public Page<Registro> obtenerRegistros(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 10);
		return registroService.findAll(pageable);
	}

}

package com.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioControllers {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@GetMapping("/{sort}/page/{page}")
	public ResponseEntity<?> listar( @PathVariable String sort, @PathVariable Integer page){
		Pageable pageable=PageRequest.of(page,50);
		return ResponseEntity.ok().body(usuarioService.findAll(pageable,sort));
	}
	
	@GetMapping("/pais")
	public ResponseEntity<?> listarOrderByPais(Pageable pageable){
		return ResponseEntity.ok().body(usuarioService.findAllOrderbyPais(pageable));
	}

	@GetMapping("/estado")
	public ResponseEntity<?> listarOrderByEstado(Pageable pageable){
		return ResponseEntity.ok().body(usuarioService.findAllOrderbyEstado(pageable));
	}
	
	@GetMapping("/genero")
	public ResponseEntity<?> listarOrderByGenero(Pageable pageable){
		return ResponseEntity.ok().body(usuarioService.findAllOrderbyGenero(pageable));
	}
	
	@GetMapping("/buscar/{valor}/pagina")
	public ResponseEntity<?> buscarTodo(Pageable pageable, @PathVariable String valor){
		return ResponseEntity.ok().body(usuarioService.buscarTodo(pageable,valor));
	}
}

package com.examen.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.models.entity.Acceso;
import com.examen.services.AccesoService;

@RestController
@RequestMapping("/api")
public class AccesoRestController {
	
	@Autowired 
	private AccesoService accesoService;
	
	@GetMapping("/{usuario}")
	public ResponseEntity<?> validar(@PathVariable String usuario){
		
		Optional<Acceso> o = accesoService.findById(usuario);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());

		
	}
	

}

/*
 * 
 * 
 * @GetMapping("/{usuario}")
	public ResponseEntity<?> validar(@Valid @PathVariable String usuario, BindingResult result){
		
		Map<String,Object>response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			
			for(FieldError err : result.getFieldErrors()) {
				errors.add("El campo "+err.getField()+" "+err.getDefaultMessage());
			}
			
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		Optional<Acceso> o = accesoService.findById(usuario);
		
		
		if(o.isEmpty()) {
			response.put("mensaje", "Los datos de acceso no son validos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(o.get());

		
	}*/

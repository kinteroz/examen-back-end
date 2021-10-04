package com.examen.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.examen.models.entity.Acceso;

public interface AccesoRepository extends CrudRepository<Acceso, String>{
	
	public Acceso findByUsuario(String usuario);

}

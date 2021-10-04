package com.examen.services;

import java.util.Optional;

import com.examen.models.entity.Acceso;

public interface AccesoService {
	
	public Optional<Acceso> findById (String usuario);

}

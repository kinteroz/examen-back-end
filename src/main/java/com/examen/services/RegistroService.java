package com.examen.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.models.entity.Registro;

public interface RegistroService {
	
	public List<Registro> findAll();
	public Page<Registro> findAll(Pageable pageable);

}

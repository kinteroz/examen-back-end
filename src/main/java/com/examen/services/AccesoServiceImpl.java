package com.examen.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.models.entity.Acceso;
import com.examen.models.repository.AccesoRepository;

@Service
public class AccesoServiceImpl implements AccesoService{

	@Autowired
	private AccesoRepository accesoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Acceso> findById(String usuario) {
		
		return accesoRepository.findById(usuario);
				
	}

}

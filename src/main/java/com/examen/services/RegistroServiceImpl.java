package com.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.models.entity.Registro;
import com.examen.models.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements RegistroService{
	
	@Autowired
	private RegistroRepository registroRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Registro> findAll() {
		return (List<Registro>) registroRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Registro> findAll(Pageable pageable) {
		return registroRepository.findAll(pageable);
	}
	
	

}

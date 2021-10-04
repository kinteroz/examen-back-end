package com.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.models.entity.Usuario;
import com.examen.models.repository.BusquedaRepository;
import com.examen.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BusquedaRepository busquedaRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable, String sort) {

		Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
		return usuarioRepository.findAll(paging);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAllOrderbyPais(Pageable pageable) {

		Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("pais"));

		return usuarioRepository.findAll(paging);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAllOrderbyEstado(Pageable pageable) {
		Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("estado"));

		return usuarioRepository.findAll(paging);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAllOrderbyGenero(Pageable pageable) {
		Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("genero"));

		return usuarioRepository.findAll(paging);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAllOrderbyUsuario(Pageable pageable) {
		Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("usuario"));

		return usuarioRepository.findAll(paging);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> buscarTodo(Pageable pageable, String valor) {
		
		return busquedaRepository.buscarTodo(pageable, valor);
	}




}

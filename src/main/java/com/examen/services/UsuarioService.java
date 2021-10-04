package com.examen.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.models.entity.Usuario;

public interface UsuarioService {
	
	public Page<Usuario> findAll(Pageable pageable,String sort);
	
	public Page<Usuario> findAllOrderbyPais(Pageable pageable);
	
	public Page<Usuario> findAllOrderbyEstado(Pageable pageable);
	
	public Page<Usuario> findAllOrderbyGenero(Pageable pageable);
	
	public Page<Usuario> findAllOrderbyUsuario(Pageable pageable);
	
	public Page<Usuario> buscarTodo(Pageable pageable,String valor);

}

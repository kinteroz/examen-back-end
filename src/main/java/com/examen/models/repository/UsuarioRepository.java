package com.examen.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.examen.models.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Integer>{

}

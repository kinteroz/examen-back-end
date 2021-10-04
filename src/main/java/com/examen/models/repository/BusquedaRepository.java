package com.examen.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.examen.models.entity.Usuario;

public interface BusquedaRepository extends PagingAndSortingRepository<Usuario,Integer> {
	
	@Query("select u from Usuario u where u.usuario like %?1% or u.pais like %?1% or estado like %?1% or genero like %?1%")
	public Page<Usuario> buscarTodo(Pageable pageable,String valor);

}

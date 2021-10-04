package com.examen.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.models.entity.Acceso;
import com.examen.models.repository.AccesoRepository;

@Service
public class AccesoSesionService implements UserDetailsService{

	@Autowired
	private AccesoRepository acccesoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		Acceso acceso = acccesoRepository.findByUsuario(usuario);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return new User(acceso.getUsuario(), acceso.getPassword(), true,true,true, true,authorities);
	}

}

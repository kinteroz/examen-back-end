package com.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamanBackendApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passEncode;
	public static void main(String[] args) {
		SpringApplication.run(ExamanBackendApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
String pass = "12345678";
		
		System.out.print( passEncode.encode(pass));
		
	}



}

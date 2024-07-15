package com.codingdojo.facundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Dictando es un controlador -> API REST, REGRESAR LITERALMENTE EL RETURN DE MI METODO
public class ProyectoUsuarios1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUsuarios1Application.class, args);
	}
	
}


package com.codingdojo.facundo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.facundo.modelos.Usuario;
import com.codingdojo.facundo.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios ru;
	
	//Metodo que me regrese todos los usuarios
	public List<Usuario> todosUsuarios(){
		return ru.findAll();
	}
	//Metodo que guarde usuarios (nuevos registros o actualizaciones) 
	public Usuario guardarUsuario (Usuario nuevoUsuario) {
		return ru.save(nuevoUsuario)
;	}
	//metodo que regresa un objeto usuario en base a su ID
	public Usuario buscarUsario(Long id) {
		return ru.findById(id).orElse(null);
	}
	
	//Metodo que borre en base al id
	
	public void borrarUsuario(Long id) {
		ru.deleteById(id);
	}
}

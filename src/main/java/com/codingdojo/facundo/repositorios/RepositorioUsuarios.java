package com.codingdojo.facundo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.facundo.modelos.Usuario;

@Repository  //EL ENCARGADO DE HACER LAS CONSULTAS
public interface RepositorioUsuarios  extends CrudRepository<Usuario, Long>{
	//JPA -> Permite de manera dinamica crear queries
	
	List <Usuario> findAll(); //SELECT * FROM usuarios;
	
	//INSERT INTO usuarios(nombre,apelllido..) VALUES (Atributos del objeto usuarios)
	Usuario save(Usuario nuevoUsuario);
	
	//CRUDRepository: finnAll(), findById(id), save(Object obj), deletByID(id)
	
	//SELECT * FORM usuarios WHERE email=<email q queiras>
	
	List<Usuario> findByEmail(String email);
	
	//select * from usuarios where nombre = <nombreqquieras>
	
	List<Usuario> findByNombre(String nombre);
	
	//select* form usuario where nombre like < letras>
	List<Usuario> findByNombreStartingWith (String letras);
	
	List<Usuario> findByNombreContaining (String palabra);
}

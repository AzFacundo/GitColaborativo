package com.codingdojo.facundo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.facundo.modelos.Usuario;
import com.codingdojo.facundo.servicios.Servicios;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorAPI {
	@Autowired //Me perimite llamar a mi clase sin instanciarla
	private Servicios servicio;
	@GetMapping("/") //api/usuarios
	public List<Usuario> apiMuestraUsuarios(){
		return servicio.todosUsuarios();
	}
	@PostMapping("/")
	public Usuario apiCrearUsuario(@RequestParam("name") String name,
			                       @RequestParam("apellido") String apellido,
			                       @RequestParam("email") String email,
			                       @RequestParam("password") String password) {
		
		Usuario nuevoUsuario = new Usuario(name, apellido, email, password);
		return servicio.guardarUsuario(nuevoUsuario);
	}
	@DeleteMapping("/{id}")
	public void apiBorrarUsuarios(@PathVariable("id") Long id) {
		servicio.borrarUsuario(id);
	}
	@GetMapping("/{id}")
	public Usuario apiMostrarUsuario(@PathVariable("id") Long id) {
		return 	servicio.buscarUsario(id);
	}
	@PutMapping("/{id}")
	public Usuario apiEditarUsuario(@PathVariable("id") Long id,
	                                @RequestParam("name") String name,
                                    @RequestParam("apellido") String apellido,
                                    @RequestParam("email") String email,
                                    @RequestParam("password") String password) {
		Usuario usuarioActualizado = new Usuario(id, name, apellido, email, password);
		return servicio.guardarUsuario(usuarioActualizado);
	}
}

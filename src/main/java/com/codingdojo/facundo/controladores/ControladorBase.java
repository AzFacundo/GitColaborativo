package com.codingdojo.facundo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/usuarios")
public class ControladorBase {
	
	@GetMapping("/")  //la ruta NO puede  repetirse, Establecemos la ruta
	public String home() {
		return "Hola desde Spring!";
	}
	@GetMapping("/despliega")
		public String despliegaUsuarios() {
			String usuarios[] = {"Elena de Troya","Juana de Arco", "pablo picasso"};
			String respuesta = "";
			
			for (int i=0; i<usuarios.length; i++) {
				respuesta += "<h2>"+usuarios[i]+ "</h2>";
			}
			return respuesta;
		}
	@GetMapping("/hola")
	public String saludo(@RequestParam (value="nombre")String name) {
		return "<h1> Hola "+name+"!</h1>";
	}
	@GetMapping("/hello/{nombre}")
	public String hello (@PathVariable("nombre") String name) {
		return "<h2>Hello "+name+"</h2>";
	}
	@GetMapping("/hello/{nombre}/{apellido}")
	public String hello (@PathVariable("nombre") String name, @PathVariable("apellido") String last_name) {
		return "<h2>Hello "+name+" "+last_name+"</h2>";
	}
}

package com.codingdojo.facundo.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.facundo.modelos.Usuario;
import com.codingdojo.facundo.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller // sirve para decir q mi documento es un controlador sirve para regresar el archivo jsp
public class ControladorUsuarios {
	
	@Autowired
	private Servicios servis;
	@GetMapping ("/") // crea ruta raiz
	public String index() {
		return "index.jsp"; // que se visualice el archivo index.jsp
	}
	@GetMapping ("/inicio")
		public String inicio (Model model) {
		//Model permite enviar informacion de la funcion hacia el jsp
		model.addAttribute("titulo","Bienvenido a JST");
		
		String usuarios[] = {"facu","capo","rey"};
		model.addAttribute("listaUsuarios", usuarios);
		
		HashMap<String, String> paises = new HashMap<String, String>();
		paises.put("mexico", "CDMX");
		paises.put("el salvador","san salvador");
		paises.put("argentina","buenos aires");
		
		model.addAttribute("paises", paises);
		
		return "inicio.jsp";
			
		}
	@GetMapping("/holi/{nombre}")
	public String hole(@PathVariable("nombre") String name, Model model) {
		model.addAttribute("nombre_persona",name);
		return "holi.jsp";
	}
	
	//el formulario tiene 3 rutas
	
	//1. muestra formulario
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario.jsp";
	}
	
	//2.recibe formulario
	@PostMapping("/registro")
	public String registro(@RequestParam(value="nombre") String name,
			                @RequestParam(value="email") String email,
			                HttpSession session,
			                RedirectAttributes flash) {
		System.out.println("el nombre del usuario es "+name);
		System.out.println("el mail del usuarios es "+email);
		
		// VALIDAMOS LA INFO 
		if(name.equals("")) {
			flash.addFlashAttribute("errorNombre","Por favor escribe tu nombre");
			return "redirect:/formulario";
		}
		session.setAttribute("nombreUsuario", name);
		
		return "redirect:/bienvenida";//te redireciona a una ruta 
	}
	//3. redireccion
	@GetMapping("/bienvenida")
	public String bienvenida() {
		return "bienvenida.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard( Model model) {
		List<Usuario> usuarios = servis.todosUsuarios();
		
		model.addAttribute("usuarios", usuarios);
		
		return "dashboard.jsp";
	}
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario") Usuario usuario) {
		//@ModelAttribute crea objeto vacio de usario para enviarlo a nuevo.jsp
		return "nuevo.jsp";
	}
	@PostMapping("/crear") //Vadiar info del objeto
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuarioNuevo,
			            BindingResult result )/*encargado de enviar msj validacion)*/ {
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else { servis.guardarUsuario(usuarioNuevo);
		  return "redirect:/dashboard";
		}
	}
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") Long idABorrar) {
		servis.borrarUsuario(idABorrar);
		return "redirect:/dashboard";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,
						 @ModelAttribute("usuario") Usuario usuario,
						 Model model) { /*Enviar info a jsp*/
		//Obtener el objeto de usuario que quiero editar
		Usuario usuarioBuscado = servis.buscarUsario(id);
		model.addAttribute("usuario", usuarioBuscado);
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}") //IMPORTANTE: debe llamarse id
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuarioEditado,
							 BindingResult result) {
		
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			servis.guardarUsuario(usuarioEditado);
			return "redirect:/dashboard";
		}
		
	}
}

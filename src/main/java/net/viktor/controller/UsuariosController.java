package net.viktor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.viktor.model.Usuarios;
import net.viktor.repository.usuariosRepository;

@Controller
@RequestMapping(value="/users")
public class UsuariosController {
	
	@Autowired
	private usuariosRepository repo;
	
	@GetMapping("/index")
	public String mostrarRegistro() {
		
		return "crudusuarios/index";		
	}
	
	@PostMapping("/create")
	public String Registro(@RequestParam("nombre") String nombretmp, @RequestParam("apellido") String apellidotmp, @RequestParam("nusuario") String nusuariotmp, @RequestParam("passwork") String passworktmp) {
		Usuarios user = new Usuarios();
		user.setNombre(nombretmp);
		user.setApellido(apellidotmp);
		user.setNusuario(nusuariotmp);
		user.setPasswork(passworktmp);
		user.setGenero(1);
		repo.save(user);
		System.out.println(user);
		return "crudusuarios/lista";		
	}

}

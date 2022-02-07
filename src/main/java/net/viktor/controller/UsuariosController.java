package net.viktor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.viktor.model.Usuarios;
import net.viktor.repository.usuariosRepository;

@Controller
@RequestMapping(value="/users")
public class UsuariosController {
	
	@Autowired
	private usuariosRepository repo;
	
	@GetMapping("/create")
	public String Registro() {
		Usuarios user = new Usuarios();
		user.setNombre("name");
		user.setApellido("lname");
		user.setNusuario("user1");
		user.setPasswork("1234");
		user.setGenero(1);
		repo.save(user);
		System.out.println(user);
		return "crudusuarios/index";		
	}

}

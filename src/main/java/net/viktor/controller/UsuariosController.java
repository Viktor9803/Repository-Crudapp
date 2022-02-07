package net.viktor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.viktor.repository.usuariosRepository;

@Controller
@RequestMapping(value="/users")
public class UsuariosController {
	
	@Autowired
	private usuariosRepository repo;
	
	public String Registro(Model model) {
		
		return null;		
	}

}

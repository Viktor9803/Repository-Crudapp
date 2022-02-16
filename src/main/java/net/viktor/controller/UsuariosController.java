package net.viktor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import net.viktor.model.Usuarios;
import net.viktor.services.IUsuariosServices;

@Controller
@RequestMapping(value="/users")
public class UsuariosController {
	
	@Autowired
	private IUsuariosServices usuariosServices;
	
	//FINDALL
	@GetMapping("/")
	public String listaTabla(Model model) {
		List<Usuarios> lista = usuariosServices.Listartodo();
		model.addAttribute("usuario", lista);
		
		return "/crudusuarios/lista";
	}
	
	//CREATE
	@GetMapping("/create")
	public String Registrar(Model model) {
		Usuarios usuarios = new Usuarios();
		model.addAttribute("titulo", "Registro de nuevo usuario");
		model.addAttribute("boton", "Registrar");
		model.addAttribute("usuario", usuarios);
		
		return "/crudusuarios/registrar";		
	}
	
	//UPDATE
	@GetMapping("/update/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		Usuarios usuarios = usuariosServices.buscarPorId(id);
		model.addAttribute("titulo", "Editar usuario");
		model.addAttribute("boton", "Actualizar");
		model.addAttribute("usuario", usuarios);
		
		return "/crudusuarios/registrar";		
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer id) {
		usuariosServices.eliminarPorId(id);
			
		return "redirect:/users/";		
	}
	
	//READ
	@GetMapping("/detalle/{id}")
	public String detalles(@PathVariable("id") Integer id, Model model) {
		Usuarios usuarios = usuariosServices.buscarPorId(id);
		model.addAttribute("titulo", "Detalle del usuario: ");
		model.addAttribute("usuario", usuarios);
		
		return "/crudusuarios/detalle";		
	}
	
	//DELETEALL
	@GetMapping("/deleteall")
	public String Deleteall() {
		usuariosServices.eliminarTodo();
		System.out.println("Se han eliminado todos los registros.");
		
		return "redirect:/users/";
	}
	
	//CREATE/GUARDAR
	@PostMapping("/registrado")
	public String guardar(@Valid Usuarios usuarios, BindingResult result, Model model) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrieron los siguientes errores: " + error.getDefaultMessage());
			}
			
			model.addAttribute("titulo", "Editar usuario");
			model.addAttribute("boton", "Actualizar");
			model.addAttribute("usuario", usuarios);
			
			return "/crudusuarios/registrar";
		}
		
		usuariosServices.guardar(usuarios);
			
		return "redirect:/users/";		
	}	
	
}

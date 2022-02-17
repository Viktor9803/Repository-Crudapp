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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("titulo", "Registro de usuario");
		model.addAttribute("boton", "Registrar");
		model.addAttribute("usuarios", usuarios);
		
		return "/crudusuarios/registrar";		
	}
	
	//UPDATE
	@GetMapping("/update/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		Usuarios usuarios = usuariosServices.buscarPorId(id);
		model.addAttribute("titulo", "Editar usuario");
		model.addAttribute("boton", "Actualizar");
		model.addAttribute("usuarios", usuarios);
		
		return "/crudusuarios/registrar";		
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		usuariosServices.eliminarPorId(id);
		attributes.addFlashAttribute("warning", "registro eliminado con exito!");
			
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
	public String Deleteall(RedirectAttributes attributes) {
		usuariosServices.eliminarTodo();
		System.out.println("Se han eliminado todos los registros.");
		attributes.addFlashAttribute("error", "ATENCION: USTED A ELIMINADO TODOS LOS REGISTROS ALMACENADO EN LA BASE DE DATOS");
		
		return "redirect:/users/";
	}
	
	//CREATE/GUARDAR
	@PostMapping("/registrado")
	public String guardar(@Valid @ModelAttribute Usuarios usuarios, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println("Ocurrieron los siguientes errores: " + error.getDefaultMessage());
			}
			
			if (usuarios.getId() == null) {
				model.addAttribute("titulo", "Registro de usuario");
				model.addAttribute("boton", "Registrar");
				model.addAttribute("usuarios", usuarios);	
			}else {
				model.addAttribute("titulo", "Editar usuario");
				model.addAttribute("boton", "Actualizar");
				model.addAttribute("usuarios", usuarios);
			}
							
			return "/crudusuarios/registrar";
		}
		
		usuariosServices.guardar(usuarios);
		attributes.addFlashAttribute("success", "Registro guardado con exito!");
			
		return "redirect:/users/";		
	}	
	
}

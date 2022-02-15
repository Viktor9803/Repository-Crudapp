package net.viktor.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.viktor.model.Usuarios;
import net.viktor.repository.usuariosRepository;
import net.viktor.services.IUsuariosServices;

@Controller
@RequestMapping(value="/users")
public class UsuariosController {
	
	@Autowired
	private IUsuariosServices usuariosServices;
	
	@Autowired
	private usuariosRepository repo;
	
	Usuarios user = new Usuarios();
	
	@GetMapping("/")
	public String listaTabla(Model model) {
		List<Usuarios> lista = usuariosServices.Listartodo();
		
		model.addAttribute("usuario", lista);
		
		return "/crudusuarios/lista";
	}

/*
 * METODOS TIPO GET	
 */
	
	@GetMapping("/findid")
	public String findid() {
		
		return "crudusuarios/buscarid";
	}
	
	@GetMapping("/create")
	public String mostrarRegistro() {
		
		return "crudusuarios/registrar";		
	}
	
	@GetMapping("/update/{id}")
	public String mostrarActualizacion(@PathVariable("id") int idusuario, Model model) {
		Optional<Usuarios> usuario = repo.findById(idusuario);
		if (usuario.isPresent()) {
			model.addAttribute("usuario", usuario);
			return "crudusuarios/actualizar";
		}else {
			return "redirect:/users/";
		}
		//return "crudusuarios/actualizar";
	}
	
	/*
	 * Metodo que devuelve desde la base de datos todo los registros y los muestra en la tabla de la vista.
	 
	@GetMapping("/")
	public String Listado(Model model) {
		List<Usuarios> listusers = new LinkedList<Usuarios>();		
			Iterable<Usuarios> usuarios = repo.findAll();
				for (Usuarios usu : usuarios) {
					listusers.add(usu);
				}
				model.addAttribute("usuario", listusers);
				System.out.println(listusers);
		
		return "/crudusuarios/lista";
	}*/
	
	/*
	 * Metodo Para eliminar todos los registro de la bd (DELETEALL)
	 */
	@GetMapping("/deleteall")
	public String Deleteall() {
		repo.deleteAll();
		System.out.println("Se han eliminado todos los registros.");
		
		return "crudusuarios/lista";
	}
	
	/*
	 * Metodo para eliminar un registro de la bd (DELETE) por el id, en la tabla
	 */
	@GetMapping("/delete/{id}")
	public String Eliminar(@PathVariable("id") int idusuario, Model model) {
		model.addAttribute("idusuario", idusuario);
		repo.deleteById(idusuario);
		
		return "crudusuarios/eliminar";		
	}
	
	/*
	 * Metodo para ver detalles de registros en la tabla (READ)
	 */
	@GetMapping("/detalle/{id}")
	public String buscarid(@PathVariable("id") int idusuario, Model model) {
		model.addAttribute("idusuario", idusuario);
		//Usuarios ustmp = new Usuarios();
		Optional<Usuarios> opt = repo.findById(idusuario);
		if (opt.isPresent()) {
			model.addAttribute("usuario", opt.get());
			System.out.println("USUARIO: "+opt.get());
			return "crudusuarios/detalle";
		}else {
			System.out.println("Coloque un id para buscar");
		}
		return "";
	}
	
/*
 * METODOS TIPO POST
 */
	
	/*
	 * Método de actualización de registro en la bd (UPDATE)
	 */
	@PostMapping("/actualizado")
	public String Actualizar(@RequestParam("nombre") String nombretmp, @RequestParam("apellido") String apellidotmp, @RequestParam("nusuario") String nusuariotmp, @RequestParam("passwork") String passworktmp, @RequestParam("genero") String generotmp, @PathVariable("id") int idusuario, Model model) {
		model.addAttribute("idusuario", idusuario);
		Optional<Usuarios> option = repo.findById(idusuario);
		if (option.isPresent()) {
			Usuarios usertemp = option.get();
			usertemp.setNombre(nombretmp);
			usertemp.setApellido(apellidotmp);
			usertemp.setNusuario(nusuariotmp);
			usertemp.setPasswork(passworktmp);
			usertemp.setGenero(generotmp);
				repo.save(usertemp);
			System.out.println(option.get());
			return "redirect:/users/";
		} else {
			System.out.println("Usuario no encontrado.");
			return "crudusuarios/actualizar";
		}		
	}
	
	/* *
	 * Método de registro en la bd (CREATE).
	 * */
	@PostMapping("/registrado")
	public String Registro(@RequestParam("nombre") String nombretmp, @RequestParam("apellido") String apellidotmp, @RequestParam("nusuario") String nusuariotmp, @RequestParam("passwork") String passworktmp, @RequestParam("genero") String generotmp) {
		Usuarios usercreate = new Usuarios();
		usercreate.setNombre(nombretmp);
		usercreate.setApellido(apellidotmp);
		usercreate.setNusuario(nusuariotmp);
		usercreate.setPasswork(passworktmp);
		usercreate.setGenero(generotmp);
			repo.save(usercreate);
		System.out.println(usercreate);
			
		return "redirect:/users/";		
	}

}

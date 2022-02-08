package net.viktor.controller;

import java.util.Optional;

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
	Usuarios user = new Usuarios();

/*
 * METODOS TIPO GET	
 */
	
	@GetMapping("/create")
	public String mostrarRegistro() {
		
		return "crudusuarios/registrar";		
	}
	
	@GetMapping("/update")
	public String mostrarActualizacion() {
		
		
		return "crudusuarios/actualizar";
	}
	
	/*
	 * Metodo para eliminar un registro de la bd (DELETE)
	 */
	@GetMapping("/delete")
	public String Eliminar() {
		int idelim = 14;
		repo.deleteById(idelim);
		
		return "crudusuarios/eliminar";		
	}
	
/*
 * METODOS TIPO POST
 */
	
	/*
	 * Método de actualización de registro en la bd (update)
	 */
	@PostMapping("/actualizado")
	public String Actualizar(@RequestParam("nombre") String nombretmp, @RequestParam("apellido") String apellidotmp, @RequestParam("nusuario") String nusuariotmp, @RequestParam("passwork") String passworktmp, @RequestParam("genero") String generotmp) {
		Optional<Usuarios> option = repo.findById(15);
		if (option.isPresent()) {
			Usuarios usertemp = option.get();
			usertemp.setNombre(nombretmp);
			usertemp.setApellido(apellidotmp);
			usertemp.setNusuario(nusuariotmp);
			usertemp.setPasswork(passworktmp);
			usertemp.setGenero(generotmp);
				repo.save(usertemp);
			System.out.println(option.get());
		} else {
			System.out.println("Usuario no encontrado.");
		}
		
		return "crudusuarios/lista";		
	}
	
	/* *
	 * Método de registro en la bd (Create).
	 * */
	@PostMapping("/registrado")
	public String Registro(@RequestParam("nombre") String nombretmp, @RequestParam("apellido") String apellidotmp, @RequestParam("nusuario") String nusuariotmp, @RequestParam("passwork") String passworktmp, @RequestParam("genero") String generotmp) {
		user.setNombre(nombretmp);
		user.setApellido(apellidotmp);
		user.setNusuario(nusuariotmp);
		user.setPasswork(passworktmp);
		user.setGenero(generotmp);
			repo.save(user);
		System.out.println(user);
			
		return "crudusuarios/lista";		
	}

}

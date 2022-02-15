package net.viktor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.viktor.model.Usuarios;
import net.viktor.repository.usuariosRepository;

@Service
public class UsuariosServicesImpl implements IUsuariosServices {
	
	@Autowired
	private usuariosRepository Repo;

	/*
	 * Metodo que devuelve desde la base de datos todo los registros (FINDALL)(READ).
	 */
	@Override
	public List<Usuarios> Listartodo() {
		
		return (List<Usuarios>) Repo.findAll();
	}

	/* *
	 * Método de registro en la bd (CREATE/UPDATE).
	 * */
	@Override
	public void guardar(Usuarios usuarios) {
		
		Repo.save(usuarios);
	}

	/*
	 * Metodo para ver detalles de registros en la tabla (READ)
	 */
	@Override
	public Usuarios buscarPorId(Integer id) {
		
		return Repo.findById(id).orElse(null);
	}

	/*
	 * Metodo para eliminar un registro de la bd (DELETE) por el id, en la tabla
	 */
	@Override
	public void eliminarPorId(Integer id) {
		
		Repo.deleteById(id);
	}
	
	/*
	 * Metodo Para eliminar todos los registro de la bd (DELETEALL)
	 */
	@Override
	public void eliminarTodo() {
		
		Repo.deleteAll();
	}

}

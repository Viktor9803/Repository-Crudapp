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

	@Override
	public List<Usuarios> Listartodo() {
		
		return (List<Usuarios>) Repo.findAll();
	}

	@Override
	public void guardar(Usuarios usuarios) {
		
		Repo.save(usuarios);
	}

	@Override
	public Usuarios buscarPorId(Integer id) {
		
		return Repo.findById(id).orElse(null);
	}

	@Override
	public void eliminarPorId(Integer id) {
		
		Repo.deleteById(id);
	}

}

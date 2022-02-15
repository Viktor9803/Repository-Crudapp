package net.viktor.services;

import java.util.List;

import net.viktor.model.Usuarios;

public interface IUsuariosServices {
	
	public List<Usuarios> Listartodo();
	public void guardar(Usuarios usuarios);
	public Usuarios buscarPorId(Integer id);
	public void eliminarPorId(Integer id);
	public void eliminarTodo();

}

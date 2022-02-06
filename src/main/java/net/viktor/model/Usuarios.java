package net.viktor.model;

public class Usuarios {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String nusuario;
	private String passwork;
	private Integer genero;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNusuario() {
		return nusuario;
	}
	public void setNusuario(String nusuario) {
		this.nusuario = nusuario;
	}
	public String getPasswork() {
		return passwork;
	}
	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}
	public Integer getGenero() {
		return genero;
	}
	public void setGenero(Integer genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nusuario=" + nusuario
				+ ", passwork=" + passwork + ", genero=" + genero + "]";
	}
		
}

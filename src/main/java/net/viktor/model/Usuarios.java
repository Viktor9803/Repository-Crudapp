package net.viktor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String nusuario;
	private String password;
	private String genero;
	private Integer telefono;
	
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
		return password;
	}
	public void setPasswork(String passwork) {
		this.password = passwork;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nusuario=" + nusuario
				+ ", password=" + password + ", genero=" + genero + ", telefono=" + telefono + "]";
	}	
		
}

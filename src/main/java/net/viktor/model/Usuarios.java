package net.viktor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Llene el campo Nombre.")
	private String nombre;
	@NotEmpty(message="Llene el campo Apellido.")
	private String apellido;
	@NotEmpty(message="Llene el campo Nombre de usuario.")
	private String nusuario;
	@NotEmpty(message="Coloque una contraseña de seguridad.")
	private String password;
	@NotEmpty(message="Seleccione un genero.")
	private String genero;
	@NotNull(message="Ingrese un telefono de contacto.")
	private Long telefono;
	@NotEmpty(message="Ingrese un correo.") @Email(message="Ingrese un correo valido.") 
	private String email;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nusuario=" + nusuario
				+ ", password=" + password + ", genero=" + genero + ", telefono=" + telefono + ", email=" + email + "]";
	}

}

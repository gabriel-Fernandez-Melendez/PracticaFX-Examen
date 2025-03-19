package entidades;

import java.time.LocalDate;

public class Contacto {

	public String nombre;
	public String telefono;
	public String email;
	public LocalDate fechanac;
	
	
	
	
	//private String genero;
	//private String grupo;
	private boolean favorito;
	//private String notas;
	
	public Contacto() {
		
	}
	
	
	public Contacto(String nombre, String telefono, String email, LocalDate fechanac) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechanac = fechanac;
	}


	public Contacto(String nombre, String telefono, String email, boolean favorito,
			 LocalDate fechanac) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		//this.genero = genero;
		//this.grupo = grupo;
		this.favorito = favorito;
		//this.notas = notas;
		this.fechanac = fechanac;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}


	public LocalDate getFechanac() {
		return fechanac;
	}

	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}

	//forma en la que almaceno los contactos
	@Override
	public String toString() {
return "nombre 	: "+nombre+" "+email+" "+fechanac;
	}
	
}

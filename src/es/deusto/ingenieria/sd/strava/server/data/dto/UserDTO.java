package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

//This class implements DTO pattern
public class UserDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	private String email;
	private String password;
	private String nombre;
	private Date fechaNacimiento;
	private int peso;
	private int altura;
	private int frecCardiMax;
	private int frecCardiRep;
	private List<Reto> retosCreados = new ArrayList<>();
	private List<Reto> retosCompletados = new ArrayList<>();
	private List<Reto> retosAceptados = new ArrayList<>();
	private List<Sesion> sesiones = new ArrayList<>();
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int getFrecCardiMax() {
		return frecCardiMax;
	}
	
	public void setFrecCardiMax(int frecCardiMax) {
		this.frecCardiMax = frecCardiMax;
	}
	
	public int getFrecCardiRep() {
		return frecCardiRep;
	}
	
	public void setFrecCardiRep(int frecCardiRep) {
		this.frecCardiRep = frecCardiRep;
	}
	
	public List<Reto> getRetosCreados() {
		return retosCreados;
	}
	
	public void setRetosCreados(List<Reto> retosCreados) {
		this.retosCreados = retosCreados;
	}
	
	public List<Reto> getRetosCompletados() {
		return retosCompletados;
	}
	
	public void setRetosCompletados(List<Reto> retosCompletados) {
		this.retosCompletados = retosCompletados;
	}
	
	public List<Reto> getRetosAceptados() {
		return retosAceptados;
	}
	
	public void setRetosAceptados(List<Reto> retosAceptados) {
		this.retosAceptados = retosAceptados;
	}
	
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	
	
}
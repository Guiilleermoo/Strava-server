package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.rmi.RemoteException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {	
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
		
	public Usuario(String email, String nombre, Date fechaNacimiento, int peso, int altura, int frecCardiMax,
			int frecCardiRep) {
		super();
		this.email = email;
		this.password = "";
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.frecCardiMax = frecCardiMax;
		this.frecCardiRep = frecCardiRep;
	}

	public Usuario() {
		super();
		this.email = "";
		this.password = "";
		this.nombre = "";
		this.fechaNacimiento = new Date();
		this.peso = 0;
		this.altura = 0;
		this.frecCardiMax = 0;
		this.frecCardiRep = 0;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", peso="
				+ peso + ", altura=" + altura + ", frecCardiMax=" + frecCardiMax + ", frecCardiRep=" + frecCardiRep
				+ ", retosCreados=" + retosCreados + ", retosCompletados=" + retosCompletados + ", retosAceptados="
				+ retosAceptados + ", actividades=" + sesiones + "]";
	}

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
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
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
	
	public void anadirReto(Reto reto) {
		this.retosCreados.add(reto);
	}

	public List<Reto> getRetosCompletados() {
		return retosCompletados;
	}
	
	public void anadirRetoCompletado(Reto reto) {
		this.retosCompletados.add(reto);
	}

	public List<Reto> getRetosAceptados() {
		return retosAceptados;
	}
	
	public void anadirRetoAceptados(Reto reto) {
		this.retosAceptados.add(reto);
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}
	
	public void anadirSesion(Sesion sesion) {
		this.sesiones.add(sesion);
	}

	
	public List<Sesion> recuperarSesiones( Date inicio, Date fin, List<Deporte> deporte) throws RemoteException {
		List<Sesion> sesiones = new ArrayList<>();
		Date fechaAhora = new Date();
		
		for (Sesion ses : this.getSesiones()) {
			if (ses.getInicio().before(fechaAhora) && ses.getFin().before(fechaAhora)) {
				sesiones.add(ses);
			}
		}
		
		
		return sesiones;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario)obj).email);
		}
		
		return false;
	}
}
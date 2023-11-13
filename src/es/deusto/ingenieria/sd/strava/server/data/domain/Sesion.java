package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

public class Sesion {
	private String nombre;
	private Date inicio;
	private Date fin;
	private Deporte deporte;
	private int duracion;
	private int distancia;
	
	public Sesion(String nombre, Date inicio, Date fin, Deporte deporte, int duracion, int distancia) {
		super();
		this.nombre = nombre;
		this.inicio = inicio;
		this.fin = fin;
		this.deporte = deporte;
		this.duracion = duracion;
		this.distancia = distancia;
	}
	
	public Sesion() {
		super();
		this.nombre = "";
		this.inicio = new Date();
		this.fin = new Date();
		this.deporte = Deporte.Running;
		this.duracion = 0;
		this.distancia = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Sesion [nombre=" + nombre + ", inicio=" + inicio + ", fin=" + fin + ", deporte=" + deporte
				+ ", duracion=" + duracion + ", distancia=" + distancia + "]";
	}
	
		
}
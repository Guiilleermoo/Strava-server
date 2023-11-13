package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.ArrayList;
import java.util.*;

public class Reto {
	private String nombre;	
	private Date fechaInicio;	
	private Date fechaFin;
	private TipoDeReto tipoDeReto;
	private int tipoReto;
	private List<Deporte> deportes;
	
	public Reto(String nombre, Date fechaInicio, Date fechaFin, TipoDeReto tipoDeReto, int tipoReto, List<Deporte> deportes) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoDeReto = tipoDeReto;
		this.tipoReto = tipoReto;
		this.deportes = deportes;
	}
	
	public Reto() {
		super();
		this.nombre = "";
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.tipoDeReto = TipoDeReto.distancia;
		this.tipoReto = 0;
		this.deportes = new ArrayList<>();
		this.deportes.add(Deporte.Running);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public TipoDeReto getTipoDeReto() {
		return tipoDeReto;
	}

	public void setTipoDeReto(TipoDeReto tipoDeReto) {
		this.tipoDeReto = tipoDeReto;
	}

	public int getTipoReto() {
		return tipoReto;
	}

	public void setTipoReto(int tipoReto) {
		this.tipoReto = tipoReto;
	}

	public List<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(List<Deporte> deportes) {
		this.deportes = deportes;
	}

	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", tipoDeReto="
				+ tipoDeReto + ", tipoReto=" + tipoReto + ", deporte=" + deportes + "]";
	}
	
}
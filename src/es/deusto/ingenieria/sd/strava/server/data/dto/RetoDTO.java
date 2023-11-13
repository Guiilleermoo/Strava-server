package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.data.domain.TipoDeReto;

//This class implements DTO pattern
public class RetoDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	private String nombre;	
	private Date fechaInicio;	
	private Date fechaFin;
	private TipoDeReto tipoDeReto;
	private int tipoReto;
	private List<Deporte> deportes;
	
	
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RetoDTO [nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", tipoDeReto="
				+ tipoDeReto + ", tipoReto=" + tipoReto + ", deporte=" + deportes + "]";
	}


	
	
	
}
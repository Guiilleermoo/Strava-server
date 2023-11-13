package es.deusto.ingenieria.sd.strava.server.services;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.TipoDeReto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class ChallengeAppService {
	
	private List<Reto> retos = new ArrayList<>();
	private Calendar fechaNacCal = new GregorianCalendar(1998, 3, 10);
	private Date fechaNac = fechaNacCal.getTime();
	private Calendar fechaInicioCal = new GregorianCalendar(2023, 12, 20);
	private Date fechaInicio = fechaInicioCal.getTime();
	private Calendar fechaFinCal = new GregorianCalendar(2023, 12, 24);
	private Date fechaFin = fechaFinCal.getTime();
	private List<Deporte> deportes = new ArrayList<>();
	
	
	public ChallengeAppService() {
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		Usuario usuario1 = new Usuario("usuario1@gmail.com", "Usuario1", fechaNac, 70, 180, 195, 70);
		Usuario usuario2 = new Usuario("usuario2@gmail.com", "Usuario2", fechaNac, 60, 165, 200, 76);
		
		deportes.add(Deporte.Running);
		deportes.add(Deporte.Ciclismo);
		
		Reto reto1 = new Reto("Reto1", fechaInicio, fechaFin, TipoDeReto.distancia, 20, deportes);
		Reto reto2 = new Reto("Reto2", fechaInicio, fechaFin, TipoDeReto.tiempo, 80, deportes);
		
		retos.add(reto1);
		retos.add(reto2);
		
		usuario1.anadirReto(reto1);
		usuario2.anadirReto(reto2);
	}
	
	public void crearReto(Usuario usuario, String nombre, Date fecha_inicio, Date fecha_fin, int tipoReto, TipoDeReto tipoDeReto, List<Deporte> deportes) throws RemoteException {
		Reto reto = new Reto(nombre, fecha_inicio, fecha_fin, tipoDeReto, tipoReto, deportes);
		
		usuario.anadirReto(reto);
	}

	public List<Reto> recuperarRetos(Date fecha) throws RemoteException {
		List<Reto> retos = new ArrayList<>();
		Date fechaAhora = new Date();
		
		for (Reto ret : this.retos) {
			if (ret.getFechaInicio().before(fechaAhora) && ret.getFechaFin().before(fechaAhora)) {
				retos.add(ret);
			}
		}
		
		return retos;
	}
	
	

	public boolean apuntarseAReto(Usuario usuario, Reto reto) throws RemoteException {
		boolean existe = false;
		List<Reto> retos = recuperarRetosAceptados(usuario);
		
		for (Reto ret : retos) {
			if (ret == reto) {
				existe = true;
			}
		}
		
		if (existe == false) {
			usuario.anadirRetoAceptados(reto);
			return true;
		} else {
			return false;
		}
		
	}
	
	public List<Reto> recuperarRetosAceptados(Usuario usuario) throws RemoteException {
		List<Reto> retos = new ArrayList<>();
		Date fechaAhora = new Date();
		
		for (Reto ret : usuario.getRetosAceptados()) {
			if (ret.getFechaInicio().before(fechaAhora) && ret.getFechaFin().before(fechaAhora)) {
				retos.add(ret);
			}
		}
		
		return retos;
	}

	public int calcularProgreso(Usuario usuario, Reto reto) throws RemoteException {
		List<Sesion> sesiones = usuario.recuperarSesiones(reto.getFechaInicio(), reto.getFechaFin(), reto.getDeportes());
		int total = 0;
		int porcentaje = 0;
		
		if (reto.getTipoDeReto() == TipoDeReto.distancia) {
			for (Sesion ses : sesiones) {
				total += ses.getDistancia();
			}
		} else {
			for (Sesion ses : sesiones) {
				total += ses.getDuracion();
			}
		}
		
		porcentaje = total*100 / reto.getTipoReto();
		
		if (porcentaje > 100) {
			porcentaje = 100;
		}
		
		return porcentaje;
	}

	public HashMap<Reto, Integer> mapaRetos(Usuario usuario) {
		HashMap<Reto, Integer> mapaRetos = new HashMap<Reto, Integer>();
		
		try {
			for (Reto ret : recuperarRetosAceptados(usuario)) {
				mapaRetos.put(ret, calcularProgreso(usuario, ret));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapaRetos;
	}



	
	
}
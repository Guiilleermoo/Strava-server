package es.deusto.ingenieria.sd.strava.server.services;

import java.rmi.RemoteException;
import java.util.*;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class TrainingAppService {
	
	public void crearSesion(Usuario user, String titulo, Date inicio, Date fin, Deporte deporte, int duracion, int distancia) throws RemoteException {
		Sesion sesion = new Sesion(titulo, inicio, fin, deporte, duracion, distancia);
		user.anadirSesion(sesion);
	}
}
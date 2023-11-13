package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.data.domain.TipoDeReto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public Usuario registro(String email, String nombre, Date fecha_nacimiento, int peso, int altura, int frecCardiMax, int frecCardiRep) throws RemoteException;

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public void crearSesion(long token, String titulo, Date inicio, Date fin, Deporte deporte, int duracion, int distancia) throws RemoteException;
	
	public void crearReto(long token, String nombre, Date fechaInicio, Date fechaFin, TipoDeReto tipoDeReto, int tipoReto, List<Deporte> deporte) throws RemoteException;
	
	public List<Reto> recuperarRetos(long token, Date fecha) throws RemoteException;
	
	public boolean apuntarseAReto(long token, Reto reto) throws RemoteException;
	
	public List<Reto> recuperarRetosAceptados(long token) throws RemoteException;
	
	public int calcularProgreso(long token, Reto reto) throws RemoteException;
	
	public Map<Reto, Integer> mapaRetos(long token) throws RemoteException;
	
	public String obtenerDatos(long token) throws RemoteException;
	
}
package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.TipoDeReto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.services.ChallengeAppService;
import es.deusto.ingenieria.sd.strava.server.services.TrainingAppService;
import es.deusto.ingenieria.sd.strava.server.services.UserAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private UserAppService userService = new UserAppService();
	private ChallengeAppService challengeService = new ChallengeAppService();
	private TrainingAppService trainingService = new TrainingAppService();
	
	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		Usuario user = userService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public Usuario registro(String email, String nombre, Date fecha_nacimiento, int peso, int altura, int frecCardiMax, int frecCardiRep) throws RemoteException {
	    try {
	        Usuario user = userService.registro(email, nombre, fecha_nacimiento, peso, altura, frecCardiMax, frecCardiRep);
	        return user;
	    } catch (Exception e) {
	        throw new RemoteException("Error during user registration", e);
	    }
	}

	@Override
	public void crearSesion(long token, String titulo, Date inicio, Date fin, Deporte deporte, int duracion, int distancia) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			
			trainingService.crearSesion(this.serverState.get(token), titulo, inicio, fin, deporte, duracion, distancia);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}


	public void crearReto(long token, String nombre, Date fechaInicio, Date fechaFin, TipoDeReto tipoDeReto, int tipoReto, List<Deporte> deporte) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			
			challengeService.crearReto(this.serverState.get(token), nombre, fechaInicio, fechaFin, tipoReto, tipoDeReto, deporte);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<Reto> recuperarRetos(long token, Date fecha) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			
			challengeService.recuperarRetos((java.sql.Date) fecha);
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return null;
	}

	@Override
	public boolean apuntarseAReto(long token, Reto reto) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			
			challengeService.apuntarseAReto(this.serverState.get(token),reto);
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return false;
	}

	@Override
	public List<Reto> recuperarRetosAceptados(long token) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			challengeService.recuperarRetosAceptados(this.serverState.get(token));
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return null;
	}

	@Override
	public int calcularProgreso(long token, Reto reto) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			challengeService.calcularProgreso(this.serverState.get(token),reto);
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return 0;
	}

	@Override
	public Map<Reto, Integer> mapaRetos(long token) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.serverState.containsKey(token)) {
			challengeService.mapaRetos(this.serverState.get(token));
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return null;
	}

	@Override
	public String obtenerDatos(long token) throws RemoteException {
		String s= "";
		if (this.serverState.containsKey(token)) {
			s=s+ this.serverState.get(token).getNombre();
		}else {
			throw new RemoteException("User is not logged in!");
		}
		return s;
	}
}
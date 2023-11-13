package es.deusto.ingenieria.sd.strava.server.test;

import java.util.*;

import es.deusto.ingenieria.sd.strava.server.data.domain.Deporte;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
			//Create a sesion (fails because no login has been done)
			facade.crearSesion(token, "Sesion1", new Date(), new Date(), Deporte.Running, 1, 0);						
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login("borja@gmail.com", sha1);			
			
			//Create a sesion
			facade.crearSesion(token, "Sesion1", new Date(), new Date(), Deporte.Running, 1, 0);
			
			//Logout
			facade.logout(token);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}
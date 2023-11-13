package es.deusto.ingenieria.sd.strava.server.services;

import java.util.Date;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class UserAppService {
	
	public enum App{Google, Meta}
	
	/*public boolean registrado(String email, App app) {
	}*/
	
	public Usuario registro(String email, String nombre, Date fechaNacimiento, int peso, int altura, int frecCardiMax, int frecCardiMed) {
		/*if (registrado(email, App.Google) || registrado(email, App.Meta)) {
			return null;
		} else {
			
		}*/
		Usuario user = new Usuario(email, nombre, fechaNacimiento, peso, altura, frecCardiMax, frecCardiMed);
		return user;
	}
		
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario user = new Usuario();		
		user.setEmail("thomas.e2001@gmail.com");	
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
	}
	
	/*public boolean validarContrasena(String email, String password, App app) {
		return true;
	}*/
	
}
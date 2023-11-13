package es.deusto.ingenieria.sd.strava.server.data.dto;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class UserAssembler {
	private static UserAssembler instance;

	private UserAssembler() { }
	
	public static UserAssembler getInstance() {
		if (instance == null) {
			instance = new UserAssembler();
		}

		return instance;
	}

	public UserDTO userToDTO(Usuario user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setNombre(user.getNombre());
		dto.setFechaNacimiento(user.getFechaNacimiento());
		dto.setPeso(user.getPeso());
		dto.setAltura(user.getAltura());
		dto.setFrecCardiMax(user.getFrecCardiMax());
		dto.setFrecCardiRep(user.getFrecCardiRep());
		dto.setRetosCreados(user.getRetosCreados());
		dto.setRetosCompletados(user.getRetosCompletados());
		dto.setRetosAceptados(user.getRetosAceptados());
		dto.setSesiones(user.getSesiones());
		
		return dto;
	}
}
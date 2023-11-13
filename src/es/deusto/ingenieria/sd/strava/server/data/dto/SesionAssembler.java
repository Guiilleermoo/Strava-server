package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class SesionAssembler {	
	private static SesionAssembler instance;

	private SesionAssembler() { }
	
	public static SesionAssembler getInstance() {
		if (instance == null) {
			instance = new SesionAssembler();
		}

		return instance;
	}

	public SesionDTO sesionToDTO(Sesion sesion) {
		SesionDTO dto = new SesionDTO();
		
		dto.setNombre(sesion.getNombre());
		dto.setInicio(sesion.getInicio());
		dto.setFin(sesion.getFin());
		dto.setDeporte(sesion.getDeporte());
		dto.setDuracion(sesion.getDuracion());
		dto.setDistancia(sesion.getDistancia());
				
		return dto;
	}
	
	public List<SesionDTO> sesionToDTO(List<Sesion> sesiones) {
		List<SesionDTO> dtos = new ArrayList<>();
		
		for (Sesion sesion : sesiones) {
			dtos.add(this.sesionToDTO(sesion));
		}
		
		return dtos;		
	}
}
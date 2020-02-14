package com.latam.desarrollo.bff.desarrolloBFF.services;

import org.springframework.http.ResponseEntity;

import com.latam.desarrollo.bff.desarrolloBFF.entities.Persona;
import com.latam.desarrollo.bff.desarrolloBFF.entities.ResponsePersona;


public interface PersonaService {
	public ResponseEntity<ResponsePersona> obtenerFelicitaciones(Persona persona);

}

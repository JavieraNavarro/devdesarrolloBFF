package com.latam.desarrollo.bff.desarrolloBFF.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.latam.desarrollo.bff.desarrolloBFF.entities.Persona;
import com.latam.desarrollo.bff.desarrolloBFF.entities.ResponsePersona;
import com.latam.desarrollo.bff.desarrolloBFF.services.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DesarrolloBFFController {

	@Autowired
	private PersonaService personaService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/personabff/felicitaciones", method = RequestMethod.POST)
	public ResponseEntity<ResponsePersona> obtenerFelicitaciones(@RequestBody Persona persona) {

		log.info("persona: " + persona);

		ResponseEntity<ResponsePersona> response = personaService.obtenerFelicitaciones(persona);
		return response;

	}


}

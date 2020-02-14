package com.latam.desarrollo.bff.desarrolloBFF.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.latam.desarrollo.bff.desarrolloBFF.entities.Persona;
import com.latam.desarrollo.bff.desarrolloBFF.entities.ResponsePersona;
import com.latam.desarrollo.bff.desarrolloBFF.services.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public ResponseEntity<ResponsePersona> obtenerFelicitaciones(Persona persona) {
		ResponseEntity<ResponsePersona> result = new ResponseEntity<>(new ResponsePersona(), HttpStatus.BAD_REQUEST);
		try {
			HttpEntity<Persona> requestEntity = new HttpEntity<>(persona);
			ResponsePersona respPersona = new ResponsePersona();
			result = new ResponseEntity<ResponsePersona>(respPersona, HttpStatus.OK);
			result = restTemplate.exchange("http://localhost:8081/personabe/felicitaciones", HttpMethod.POST,
					requestEntity, ResponsePersona.class);
			return result;
		} catch (RestClientException e) {
			log.error("error.." + e);
			result = new ResponseEntity<>(new ResponsePersona(), HttpStatus.NOT_FOUND);
			log.info("[personaBFFServiceImpl][RestClientException].." + result);
		}catch(Exception e) {
			log.error("error.." + e);
			result = new ResponseEntity<>(new ResponsePersona(),HttpStatus.INTERNAL_SERVER_ERROR);
			log.info("[personaBFFServiceImpl][RestClientException].." + result);
		}
		return result;
	}

	
}

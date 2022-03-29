package com.dotsystems.portal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.services.PortadorServices;

@RestController
@RequestMapping(value = "/portadores")
public class PortadorResource {

	@Autowired
	private PortadorServices service;
	
	@GetMapping
	public ResponseEntity<List<Portador>> findAll() {
		List<Portador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Portador> findById(@PathVariable Long id) {
		Portador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

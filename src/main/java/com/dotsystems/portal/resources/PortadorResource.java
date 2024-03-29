package com.dotsystems.portal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.dto.PortadorDTO;
import com.dotsystems.portal.services.PortadorServices;

@RestController
@RequestMapping(value = "/portadores")
public class PortadorResource {

	@Autowired
	private PortadorServices service;
	
	@GetMapping
	public ResponseEntity<Page<PortadorDTO>> findAll(Pageable pageable) {
		Page<Portador> list = service.findAll(pageable);
		Page<PortadorDTO> pages = list.map(PortadorDTO::new);
		return ResponseEntity.ok().body(pages);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PortadorDTO> findById(@PathVariable Long id) {
		PortadorDTO obj = new PortadorDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/suspeitos")
	public ResponseEntity<Page<PortadorDTO>> findSuspect(Pageable pageable) {
		Page<Portador> list = service.findSuspectPort(pageable);
		Page<PortadorDTO> pages = list.map(PortadorDTO::new);
		return ResponseEntity.ok().body(pages);
	}
}

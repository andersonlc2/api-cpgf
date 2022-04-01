package com.dotsystems.portal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.services.UnidadeGestoraService;

@RestController
@RequestMapping(value = "/unidades_gestoras")
public class UnidadeGestoraResource {

	@Autowired
	private UnidadeGestoraService service;
	
	@GetMapping
	public ResponseEntity<Page<UnidadeGestora>> findAll(Pageable pageable) {
		Page<UnidadeGestora> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeGestora> findById(@PathVariable Long id) {
		UnidadeGestora obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

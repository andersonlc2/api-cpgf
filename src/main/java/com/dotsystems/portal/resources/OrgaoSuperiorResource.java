package com.dotsystems.portal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.OrgaoSuperior;
import com.dotsystems.portal.services.OrgaoSuperiorService;

@RestController
@RequestMapping(value = "/orgaos_superiores")
public class OrgaoSuperiorResource {
	
	@Autowired
	private OrgaoSuperiorService service;
	

	@GetMapping
	public ResponseEntity<Page<OrgaoSuperior>> findAll(Pageable pageable) {
		Page<OrgaoSuperior> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrgaoSuperior> findById(@PathVariable Long id) {
		OrgaoSuperior os = service.findById(id);
		return ResponseEntity.ok().body(os);
	}
}

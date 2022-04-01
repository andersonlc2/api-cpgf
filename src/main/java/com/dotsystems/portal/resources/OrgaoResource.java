package com.dotsystems.portal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.services.OrgaoService;

@RestController
@RequestMapping(value = "/orgaos")
public class OrgaoResource {

	@Autowired
	private OrgaoService service;
	
	@GetMapping
	public ResponseEntity<Page<Orgao>> findAll(Pageable pageable) {
		Page<Orgao> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Orgao> findById(@PathVariable Long id) {
		Orgao orgao = service.findById(id);
		return ResponseEntity.ok().body(orgao);
	}
}

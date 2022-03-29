package com.dotsystems.portal.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.OrgaoSuperior;

@RestController
@RequestMapping(value = "/orgaos_superiores")
public class OrgaoSuperiorResource {
	
	@GetMapping
	public ResponseEntity<OrgaoSuperior> findAll() {
		OrgaoSuperior orgaoSuperior = new OrgaoSuperior(25000L, "Presidência da República");
		return ResponseEntity.ok().body(orgaoSuperior);
	}
}

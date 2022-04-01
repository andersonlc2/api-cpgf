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
import com.dotsystems.portal.entities.dto.OrgaoDTO;
import com.dotsystems.portal.services.OrgaoService;

@RestController
@RequestMapping(value = "/orgaos")
public class OrgaoResource {

	@Autowired
	private OrgaoService service;
	
	@GetMapping
	public ResponseEntity<Page<OrgaoDTO>> findAll(Pageable pageable) {
		Page<Orgao> list = service.findAll(pageable);
		Page<OrgaoDTO> pages = list.map(OrgaoDTO::new);
		return ResponseEntity.ok().body(pages);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrgaoDTO> findById(@PathVariable Long id) {
		OrgaoDTO orgao = new OrgaoDTO(service.findById(id));
		return ResponseEntity.ok().body(orgao);
	}
}

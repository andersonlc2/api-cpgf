package com.dotsystems.portal.resources;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.entities.dto.UnidadeGestoraDTO;
import com.dotsystems.portal.services.UnidadeGestoraService;

@RestController
@RequestMapping(value = "/unidades_gestoras")
public class UnidadeGestoraResource {

	@Autowired
	private UnidadeGestoraService service;
	
	@GetMapping
	public ResponseEntity<Page<UnidadeGestoraDTO>> findAll(Pageable pageable) {
		Page<UnidadeGestora> list = service.findAll(pageable);
		Page<UnidadeGestoraDTO> pages = new PageImpl<>(list.stream().map(x -> new UnidadeGestoraDTO(x)).collect(Collectors.toList())); 
		return ResponseEntity.ok().body(pages);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeGestoraDTO> findById(@PathVariable Long id) {
		UnidadeGestoraDTO obj = new UnidadeGestoraDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
}

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

import com.dotsystems.portal.entities.dto.TransacaoDTO;
import com.dotsystems.portal.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;
	
	@GetMapping
	public ResponseEntity<Page<TransacaoDTO>> findAll(Pageable pageable) {
		Page<TransacaoDTO> list = new PageImpl<>(service.findAll(pageable).stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList()));
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TransacaoDTO> findById(@PathVariable Long id) {
		TransacaoDTO obj = new TransacaoDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/sigilosos")
	public ResponseEntity<Page<TransacaoDTO>> findAllSig(Pageable pageable) {
		Page<TransacaoDTO> list = new PageImpl<>(service.findAllSig(pageable).stream().map(x -> new TransacaoDTO(x)).collect(Collectors.toList()));
		return ResponseEntity.ok().body(list);
	}
}

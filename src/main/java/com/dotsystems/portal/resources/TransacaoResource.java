package com.dotsystems.portal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsystems.portal.entities.Transacao;
import com.dotsystems.portal.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Transacao>> findAll() {
		List<Transacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transacao> findById(@PathVariable Long id) {
		Transacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/sigilosos")
	public ResponseEntity<List<Transacao>> findAllSig () {
		List<Transacao> list = service.findAllSig();
		return ResponseEntity.ok().body(list);
	}
}

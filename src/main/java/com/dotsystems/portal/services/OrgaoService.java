package com.dotsystems.portal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.repositories.OrgaoRepository;

@Service
public class OrgaoService {

	@Autowired
	private OrgaoRepository repository;
	
	public List<Orgao> findAll() {
		return repository.findAll();
	}
	
	public Orgao findById(Long id) {
		Optional<Orgao> obj = repository.findById(id);
		return obj.get();
	}
}

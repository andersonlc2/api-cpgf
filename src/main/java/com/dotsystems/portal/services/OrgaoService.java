package com.dotsystems.portal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.repositories.OrgaoRepository;

@Service
public class OrgaoService {

	@Autowired
	private OrgaoRepository repository;
	
	public Page<Orgao> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Orgao findById(Long id) {
		Optional<Orgao> obj = repository.findById(id);
		return obj.get();
	}
}

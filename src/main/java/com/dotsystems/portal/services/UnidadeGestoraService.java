package com.dotsystems.portal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.repositories.UnidadeGestoraRepository;

@Service
public class UnidadeGestoraService {

	@Autowired
	private UnidadeGestoraRepository repository;
	
	public Page<UnidadeGestora> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public UnidadeGestora findById(Long id) {
		Optional<UnidadeGestora> obj = repository.findById(id);
		return obj.get();
	}
}

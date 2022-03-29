package com.dotsystems.portal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.UnidadeGestora;
import com.dotsystems.portal.repositories.UnidadeGestoraRepository;

@Service
public class UnidadeGestoraService {

	@Autowired
	private UnidadeGestoraRepository repository;
	
	public List<UnidadeGestora> findAll() {
		return repository.findAll();
	}
	
	public UnidadeGestora findById(Long id) {
		Optional<UnidadeGestora> obj = repository.findById(id);
		return obj.get();
	}
}

package com.dotsystems.portal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.repositories.PortadorRepository;

@Service
public class PortadorServices {

	@Autowired
	private PortadorRepository repository;
	
	public Page<Portador> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Portador findById(Long id) {
		Optional<Portador> obj = repository.findById(id);
		return obj.get();
	}
}

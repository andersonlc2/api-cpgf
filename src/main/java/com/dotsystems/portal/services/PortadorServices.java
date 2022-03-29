package com.dotsystems.portal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.repositories.PortadorRepository;

@Service
public class PortadorServices {

	@Autowired
	private PortadorRepository repository;
	
	public List<Portador> findAll() {
		return repository.findAll();
	}
	
	public Portador findById(Long id) {
		Optional<Portador> obj = repository.findById(id);
		return obj.get();
	}
}

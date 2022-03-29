package com.dotsystems.portal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.OrgaoSuperior;
import com.dotsystems.portal.repositories.OrgaoSuperiorRepository;

@Service
public class OrgaoSuperiorService {

	@Autowired
	private OrgaoSuperiorRepository repository;
	
	public List<OrgaoSuperior> findAll() {
		return repository.findAll();
	}
	
	public OrgaoSuperior findById(Long id)	{
		Optional<OrgaoSuperior> obj = repository.findById(id);
		return obj.get();
	}
}

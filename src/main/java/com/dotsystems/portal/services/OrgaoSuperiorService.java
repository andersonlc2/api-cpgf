package com.dotsystems.portal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.OrgaoSuperior;
import com.dotsystems.portal.repositories.OrgaoSuperiorRepository;

@Service
public class OrgaoSuperiorService {

	@Autowired
	private OrgaoSuperiorRepository repository;
	
	public Page<OrgaoSuperior> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public OrgaoSuperior findById(Long id)	{
		Optional<OrgaoSuperior> obj = repository.findById(id);
		return obj.get();
	}
	
	
}

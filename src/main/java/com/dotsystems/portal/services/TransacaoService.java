package com.dotsystems.portal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Transacao;
import com.dotsystems.portal.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;

	public Page<Transacao> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public Transacao findById(Long id) {
		Optional<Transacao> obj = repository.findById(id);
		return obj.get();
	}
	
	public Page<Transacao> findAllSig(Pageable pageable) {
		Page<Transacao> listAll = repository.findAll(pageable);
		List<Transacao> listSig = new ArrayList<>();
		for (Transacao trans : listAll) {
			if (trans.getPortador().getId() == 34300) {
				listSig.add(trans);
			}
		}
		Page<Transacao> pages = new PageImpl<>(listSig);
		return pages;
	}
	
}

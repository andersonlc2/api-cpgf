package com.dotsystems.portal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.Transacao;
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
	
	public Page<Portador> findSuspectPort(Pageable pageable) {
		List<Portador> list = repository.findAll();
		List<Portador> portSuspct = new ArrayList<>();
		for (Portador port : list) {
			int count = 0;
			
			for (Transacao trans : port.getTransacoes()) {
				double valor = trans.getValor();
				String tipo = trans.getDesc_transacao();
				long portID = trans.getPortador().getId();
				if (valor % 1000 == 0 && tipo.contains("SAQUE") && portID != 34300) {
					 count ++;
				}
				if (count > 5 && !portSuspct.contains(port)) {
					portSuspct.add(port);
				}
			}
		}
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), portSuspct.size());
		return new PageImpl<>(portSuspct.subList(start, end), pageable, portSuspct.size());
	}
}

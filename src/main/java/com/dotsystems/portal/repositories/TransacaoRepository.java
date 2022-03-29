package com.dotsystems.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotsystems.portal.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}

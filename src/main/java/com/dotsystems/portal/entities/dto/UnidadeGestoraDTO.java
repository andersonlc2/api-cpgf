package com.dotsystems.portal.entities.dto;

import java.io.Serializable;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.entities.UnidadeGestora;

public class UnidadeGestoraDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double totalGasto;
	private Integer totalTransacoes;
	private Orgao orgao;

	public UnidadeGestoraDTO() {
		
	}
	
	public UnidadeGestoraDTO(UnidadeGestora obj) {
		id = obj.getId();
		nome = obj.getNome();
		totalGasto = obj.getTotalGasto();
		totalTransacoes = obj.getTotalTransacaoes();
		orgao = obj.getOrgao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public Double getTotalGasto() {
		return totalGasto;
	}

	public Integer getTotalTransacoes() {
		return totalTransacoes;
	}
}

package com.dotsystems.portal.entities.dto;

import java.io.Serializable;

import com.dotsystems.portal.entities.Orgao;
import com.dotsystems.portal.entities.OrgaoSuperior;

public class OrgaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double totalGasto;
	private Integer totalTransacoes;
	private OrgaoSuperior orgaoSuperior;
	
	public OrgaoDTO() {
		
	}
	
	public OrgaoDTO(Orgao obj) {
		id = obj.getId();
		nome = obj.getNome();
		totalGasto = obj.getTotalGasto();
		totalTransacoes = obj.getTotalTransacoes();
		orgaoSuperior = obj.getOrgaoSuperior();
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

	public OrgaoSuperior getOrgaoSuperior() {
		return orgaoSuperior;
	}

	public void setOrgaoSuperior(OrgaoSuperior orgaoSuperior) {
		this.orgaoSuperior = orgaoSuperior;
	}

	public Double getTotalGasto() {
		return totalGasto;
	}

	public Integer getTotalTransacoes() {
		return totalTransacoes;
	}
}

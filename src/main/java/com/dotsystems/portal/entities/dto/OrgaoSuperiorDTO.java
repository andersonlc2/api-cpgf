package com.dotsystems.portal.entities.dto;

import java.io.Serializable;

import com.dotsystems.portal.entities.OrgaoSuperior;

public class OrgaoSuperiorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Double totalGasto;
	private Integer totalTransacoes;
	
	public OrgaoSuperiorDTO() {

	}

	public OrgaoSuperiorDTO(OrgaoSuperior obj) {
		id = obj.getId();
		nome = obj.getNome();
		totalGasto = obj.getTotalGasto();
		totalTransacoes = obj.getTotalTransacoes();
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

	public Double getTotalGasto() {
		return totalGasto;
	}

	public Integer getTotalTransacoes() {
		return totalTransacoes;
	}
}

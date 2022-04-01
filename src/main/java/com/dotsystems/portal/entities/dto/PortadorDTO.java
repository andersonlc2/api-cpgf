package com.dotsystems.portal.entities.dto;

import java.io.Serializable;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.UnidadeGestora;

public class PortadorDTO implements Serializable {
	
	private static final long serialVersionUID = 445642479580233171L;
	
	private Long id;
	private String nome;
	private String cpf;
	private Double totalGasto;
	private Integer totalTransacoes;
	private UnidadeGestora unidadeGestora;

	public PortadorDTO() {
		
	}
	
	public PortadorDTO(Portador obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCpf();
		totalGasto = obj.getTotalGasto();
		totalTransacoes = obj.getTotalTransacoes();
		unidadeGestora = obj.getUnidadeGestora();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UnidadeGestora getUnidadeGestora() {
		return unidadeGestora;
	}

	public void setUnidadeGestora(UnidadeGestora unidadeGestora) {
		this.unidadeGestora = unidadeGestora;
	}

	public Double getTotalGasto() {
		return totalGasto;
	}

	public Integer getTotalTransacoes() {
		return totalTransacoes;
	}

}

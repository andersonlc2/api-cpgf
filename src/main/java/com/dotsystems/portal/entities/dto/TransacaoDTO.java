package com.dotsystems.portal.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.dotsystems.portal.entities.Portador;
import com.dotsystems.portal.entities.Transacao;

public class TransacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer ano;
	private Integer mes;
	private String doc_favorecido;
	private String nome_favorecido;
	private String desc_transacao;
	private LocalDate dt_transacao;
	private Double valor;
	private Portador portador;

	public TransacaoDTO() {
		
	}
	
	public TransacaoDTO(Transacao obj) {
		id = obj.getId();
		ano = obj.getAno();
		mes = obj.getMes();
		doc_favorecido = obj.getDoc_favorecido();
		nome_favorecido = obj.getNome_favorecido();
		desc_transacao = obj.getDesc_transacao();
		dt_transacao = obj.getDt_transacao();
		valor = obj.getValor();
		portador = obj.getPortador();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getDoc_favorecido() {
		return doc_favorecido;
	}

	public void setDoc_favorecido(String doc_favorecido) {
		this.doc_favorecido = doc_favorecido;
	}

	public String getNome_favorecido() {
		return nome_favorecido;
	}

	public void setNome_favorecido(String nome_favorecido) {
		this.nome_favorecido = nome_favorecido;
	}

	public String getDesc_transacao() {
		return desc_transacao;
	}

	public void setDesc_transacao(String desc_transacao) {
		this.desc_transacao = desc_transacao;
	}

	public LocalDate getDt_transacao() {
		return dt_transacao;
	}

	public void setDt_transacao(LocalDate dt_transacao) {
		this.dt_transacao = dt_transacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Portador getPortador() {
		return portador;
	}

	public void setPortador(Portador portador) {
		this.portador = portador;
	}
}

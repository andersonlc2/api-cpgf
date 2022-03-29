package com.dotsystems.portal.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name = "seq_transacao", initialValue = 1000, allocationSize = 100)
@Table(name = "tb_transacao")
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transacao")
	private Long id;
	private Integer ano;
	private Integer mes;
	private String doc_favorecido;
	private String nome_favorecido;
	private String desc_transacao;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private LocalDate dt_transacao;
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "portadorId")
	@JsonBackReference
	private Portador portador;

	public Transacao() {

	}

	public Transacao(Long id, Integer ano, Integer mes, String doc_favorecido, String nome_favorecido,
			String desc_transacao, LocalDate dt_transacao, Double valor, Portador portador) {
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.doc_favorecido = doc_favorecido;
		this.nome_favorecido = nome_favorecido;
		this.desc_transacao = desc_transacao;
		this.dt_transacao = dt_transacao;
		this.valor = valor;
		this.portador = portador;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return id == other.id;
	}
}

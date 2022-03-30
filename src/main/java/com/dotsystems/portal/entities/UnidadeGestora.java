package com.dotsystems.portal.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_unidade_gestora")
public class UnidadeGestora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "orgaoId")
	private Orgao orgao;

	@OneToMany(mappedBy = "unidadeGestora")
	@JsonIgnore
	private Set<Portador> portadores = new HashSet<>();

	public UnidadeGestora() {
	}

	public UnidadeGestora(Long id, String nome, Orgao orgao) {
		this.id = id;
		this.nome = nome;
		this.orgao = orgao;
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

	@JsonIgnore
	public Set<Portador> getPortadores() {
		return portadores;
	}
	
	public Double getTotalGasto() {
		double soma = 0.0;
		for (Portador port : portadores) {
			soma += port.getTotalGasto();
		}
		return soma;
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
		UnidadeGestora other = (UnidadeGestora) obj;
		return Objects.equals(id, other.id);
	}

}

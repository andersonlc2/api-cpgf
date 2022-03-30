package com.dotsystems.portal.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq_portador", initialValue = 10000, allocationSize = 100)
@Table(name = "tb_portador")
public class Portador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_portador")
	private Long id;
	private String nome;
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "unidadeGestoraId")
	private UnidadeGestora unidadeGestora;

	@OneToMany(mappedBy = "portador")
	@JsonIgnore
	private Set<Transacao> transacoes = new HashSet<>();

	public Portador() {
	}

	public Portador(Long id, String nome, String cpf, UnidadeGestora unidadeGestora) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.unidadeGestora = unidadeGestora;
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
	

	@JsonIgnore
	public Set<Transacao> getTransacoes() {
		return transacoes;
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
		Portador other = (Portador) obj;
		return Objects.equals(id, other.id);
	}
}

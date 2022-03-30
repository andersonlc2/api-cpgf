package com.dotsystems.portal.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_orgao_superior")
public class OrgaoSuperior implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;

	
	@OneToMany(mappedBy = "orgaoSuperior")
	@JsonIgnore
	private Set<Orgao> orgaos = new HashSet<>();

	public OrgaoSuperior() {
	}

	public OrgaoSuperior(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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

	@JsonIgnore
	public Set<Orgao> getOrgao() {
		return orgaos;
	}
	
	public Double getTotalGasto() {
		double soma = 0.0;
		for (Orgao org : orgaos) {
			soma += org.getTotalGasto();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrgaoSuperior other = (OrgaoSuperior) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}

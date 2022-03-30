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
@Table(name = "tb_orgao")
public class Orgao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "orgaoSupId")
	private OrgaoSuperior orgaoSuperior;

	@OneToMany(mappedBy = "orgao")
	@JsonIgnore
	private Set<UnidadeGestora> unidadesGestoras = new HashSet<>();

	public Orgao() {
	}

	public Orgao(Long id, String nome, OrgaoSuperior orgaoSuperior) {
		this.id = id;
		this.nome = nome;
		this.orgaoSuperior = orgaoSuperior;
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

	@JsonIgnore
	public Set<UnidadeGestora> getUnidadesGestoras() {
		return unidadesGestoras;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, orgaoSuperior);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orgao other = (Orgao) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(orgaoSuperior, other.orgaoSuperior);
	}

}

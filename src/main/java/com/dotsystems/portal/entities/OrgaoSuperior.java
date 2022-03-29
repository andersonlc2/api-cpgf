package com.dotsystems.portal.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrgaoSuperior implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String nome;

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

package br.com.cast.aluguel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante", schema = "aluguel")
public class Fabricante {

	@Id
	private Integer id;

	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	public Integer getId() {
		return id;
	}

	public Fabricante setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}

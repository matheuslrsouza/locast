package br.com.cast.aluguel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoFormDTO {

	private String placa;
	private Integer ano;
	@JsonProperty("id_modelo")
	private Integer idModelo;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

}

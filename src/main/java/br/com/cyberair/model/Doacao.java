package br.com.cyberair.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;

@Entity
public class Doacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	@Column(nullable = false)
	private Double valor;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Ong Ong;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Doador Doador;

	public Doador getDoador() {
		return Doador;
	}

	public void setDoador(Doador doador) {
		Doador = doador;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Ong getOng() {
		return Ong;
	}

	public void setOng(Ong Ong) {
		this.Ong = Ong;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

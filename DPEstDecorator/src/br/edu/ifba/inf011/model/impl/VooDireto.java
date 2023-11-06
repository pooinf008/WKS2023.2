package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Voo;

//CONCRETECOMPONENT em DECORATOR
public class VooDireto implements Voo{
	
	private String iataPartida;
	private String iataChegada;
	private Double preco;
	private String numero;
	
	
	public VooDireto(String iataPartida, String iataChegada, Double preco, String numero) {
		super();
		this.iataPartida = iataPartida;
		this.iataChegada = iataChegada;
		this.preco = preco;
		this.numero = numero;
	}


	public String getIATAPartida() {
		return iataPartida;
	}


	public String getIATAChegada() {
		return iataChegada;
	}

	public String getNumero() {
		return numero;
	}


	@Override
	public Double getPreco() {
		return this.preco;
	}

	public Boolean isExecutivo() {
		return false;
	};
	


}

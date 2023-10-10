package br.edu.ifba.inf011.model.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Voo;

//COMPOSITE em COMPOSITE
public class VooComposto extends VooBase implements Voo{
	

	private String numero;
	
	public VooComposto(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String getIATAPartida() {
		return this.voos.get(0).getIATAPartida();
	}

	@Override
	public String getIATAChegada() {
		return this.voos.get(this.voos.size() - 1).getIATAChegada();
	}

	@Override
	public Double getPreco() {
		Double preco = 0.0;
		for(Voo voo : this.voos)
			preco += voo.getPreco();
		return preco;
	}

	@Override
	public String getNumero() {
		return this.numero;
	}
	
	

}

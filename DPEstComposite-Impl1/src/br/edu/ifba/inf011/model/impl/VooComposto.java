package br.edu.ifba.inf011.model.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Voo;

//COMPOSITE em COMPOSITE
public class VooComposto implements Voo{
	
	private List<Voo> voos;
	private String numero;
	
	public VooComposto(String numero) {
		this.numero = numero;
		this.voos = new ArrayList<Voo>();
	}
	
	public void addVoo(Voo voo) {
		this.voos.add(voo);
	}

	public void removeVoo(Voo voo) {
		this.voos.remove(voo);
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

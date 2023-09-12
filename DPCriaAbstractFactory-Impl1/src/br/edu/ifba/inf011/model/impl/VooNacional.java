package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Voo;

//CONCRETE PRODUCT em um ABSTRACT FACTORY
public class VooNacional implements Voo{
	
	private VooData data;
	
	public VooNacional() {
		this.data = new VooData();
	}
	
	public VooNacional(String iATAPartida, String iATAChegada, Double preco) {
		this.data = new VooData(iATAPartida, iATAChegada, preco);
	}
	
	public void init(String iATAPartida, String iATAChegada, Double preco) {
		this.data.init(iATAPartida, iATAChegada, preco);
	}	

	public String getIATAPartida() {
		return this.data.getiATAPartida();
	}


	public String getIATAChegada() {
		return this.data.getiATAChegada();
	}


	public Double getPreco() {
		return this.data.getPreco();
	}


	@Override
	public Double getPrecoOriginal() {
		return this.getPreco();
	}

	@Override
	public Double getPrecoConvertido() {
		return this.getPreco();
	}
		
	
}

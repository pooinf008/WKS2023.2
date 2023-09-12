package br.edu.ifba.inf011.model.impl;

public class VooData {
	
	private String iATAPartida;
	private String iATAChegada;
	private Double preco;
	
	public VooData() {
		
	}
	
	public VooData(String iATAPartida, String iATAChegada, Double preco) {
		super();
		this.init(iATAPartida, iATAChegada, preco);
	}

	public void init(String iATAPartida, String iATAChegada, Double preco) {
		this.iATAPartida = iATAPartida;
		this.iATAChegada = iATAChegada;
		this.preco = preco;
	}


	public String getiATAPartida() {
		return iATAPartida;
	}


	public String getiATAChegada() {
		return iATAChegada;
	}


	public Double getPreco() {
		return preco;
	}
	

	
}

package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.PontoDeInteresse;

//CONCRETEPRODUCT em um Factory Method
public class Atracao implements PontoDeInteresse{
	
	private InfoPoI data;

	public Atracao() {
		super();
		this.data = new InfoPoI();
	}	
	
	public Atracao(String nome, Integer estrelas, Double latitude, Double longitude) {
		super();
		this.data = new InfoPoI(nome, estrelas, latitude, longitude);
	}

	@Override
	public Integer getEstrelas() {
		return this.data.getEstrelas();
	}
	
	@Override
	public String getNome() {
		return this.data.getNome();
	}
	
	@Override
	public Double getLatitude() {
		return this.data.getLatitude();
	}
	
	@Override
	public Double getLongitude() {
		return this.data.getLongitude();
	}	
	
	
	public String toString() {
		return this.data.toString();
	}
	


	
	public static void main(String[] args) {
		Atracao atracao = new Atracao("Farol da Barra", 5, 13.58, 14.89);
		System.out.println(atracao);
	}

	@Override
	public void avaliar(Integer estrelas) {
		this.data.setEstrelas(estrelas);
		
	}

	@Override
	public void setNome(String nome) {
		this.data.setNome(nome);
		
	}

	@Override
	public void setLatitude(Double latitude) {
		this.data.setLatitude(latitude);
	}

	@Override
	public void setLongitude(Double longitude) {
		this.data.setLongitude(longitude);
	}
	
	
}

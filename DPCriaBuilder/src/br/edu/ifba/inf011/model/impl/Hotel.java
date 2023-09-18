package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.PontoDeInteresse;

//CONCRETEPRODUCT em um Factory Method
public class Hotel implements PontoDeInteresse{
	private InfoPoI data;

	public Hotel() {
		super();
		this.data = new InfoPoI();
	}	
	
	public Hotel(String nome, Integer estrelas, Double latitude, Double longitude) {
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

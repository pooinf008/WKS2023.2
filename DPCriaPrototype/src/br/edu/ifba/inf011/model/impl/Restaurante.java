package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.prototype.Prototipavel;

//CONCRETEPROTOTYPE em um PROTOTYPE
public class Restaurante implements PontoDeInteresse{
	private InfoPoI data;

	public Restaurante() {
		super();
		this.data = new InfoPoI();
	}	
	
	public Restaurante(String nome, Integer estrelas, Double latitude, Double longitude) {
		super();
		this.data = new InfoPoI(nome, estrelas, latitude, longitude);
	}

	public Restaurante(Restaurante restaurante) {
		this.data = (InfoPoI) restaurante.data.prototipar();
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
		Restaurante restaurante = new Restaurante("Cabana da Barra", 5, 13.58, 14.89);
		System.out.println(restaurante);
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

	@Override
	public Prototipavel prototipar() {
		return new Restaurante(this);
	}
	
	

}


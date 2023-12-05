package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.visitor.FormatterVisitor;
import br.edu.ifba.inf011.visitor.POIFormatterVisitor;

public class Hotel implements POIFormatterVisitor{
	private InfoPoI data;

	public Hotel() {
		super();
		this.data = new InfoPoI();
	}	
	
	public Hotel(String nome, Integer estrelas, Double latitude, Double longitude) {
		super();
		this.data = new InfoPoI(nome, estrelas, latitude, longitude);
	}

	public Integer getEstrelas() {
		return this.data.getEstrelas();
	}
	
	public String getNome() {
		return this.data.getNome();
	}
	
	public Double getLatitude() {
		return this.data.getLatitude();
	}
	
	public Double getLongitude() {
		return this.data.getLongitude();
	}	
	
	public String toString() {
		return this.data.toString();
	}

	public void avaliar(Integer estrelas) {
		this.data.setEstrelas(estrelas);
		
	}
	public void setNome(String nome) {
		this.data.setNome(nome);
		
	}

	public void setLatitude(Double latitude) {
		this.data.setLatitude(latitude);
	}

	public void setLongitude(Double longitude) {
		this.data.setLongitude(longitude);
	}

	@Override
	public String aceitarVisita(FormatterVisitor visitor) {
		return visitor.visitarHotel(this);
	}

	

}

package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.visitor.FormatterVisitor;
import br.edu.ifba.inf011.visitor.POIFormatterVisitor;

public class Restaurante implements POIFormatterVisitor{
	private InfoPoI data;
	private String tipoCozinha;

	public Restaurante() {
		super();
		this.data = new InfoPoI();
	}	
	
	public Restaurante(String nome, String tipoCozinha, Integer estrelas, Double latitude, Double longitude) {
		super();
		this.tipoCozinha = tipoCozinha;
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

	public String getTipoCozinha() {
		return tipoCozinha;
	}

	@Override
	public String aceitarVisita(FormatterVisitor visitor) {
		return visitor.visitarRestaurante(this);
	}
	
	


}


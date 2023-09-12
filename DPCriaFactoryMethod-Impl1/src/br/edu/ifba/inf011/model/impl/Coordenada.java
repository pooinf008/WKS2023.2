package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Localizacao;

public class Coordenada implements Localizacao{
	
	private Double latitude;
	private Double longitude;
	
	public Coordenada() {
	}	
	
	public Coordenada(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	public String toString() {
		return String.format("(%.2f; %.2f)", this.latitude, this.longitude);
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	

	

}

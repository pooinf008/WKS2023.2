package br.edu.ifba.inf011.model.impl;

import java.util.Objects;

import br.edu.ifba.inf011.model.Localizacao;

public class InfoPoI {
	
	private String nome;
	private Localizacao localizacao;
	private Integer estrelas;

	public InfoPoI() {
		super();
		this.localizacao = new Coordenada();
	}	
	
	public InfoPoI(String nome, Integer estrelas, Double latitude, Double longitude) {
		super();
		this.nome = nome;
		this.localizacao = new Coordenada(latitude, longitude);
		this.estrelas = estrelas;		
	}

	public String getNome() {
		return nome;
	}

	public Double getLatitude() {
		return localizacao.getLatitude();
	}
	
	public Double getLongitude() {
		return localizacao.getLongitude();
	}
	

	public Integer getEstrelas() {
		return estrelas;
	}
	
	private String getRepEstrelas() {
		StringBuilder str = new StringBuilder();
		switch(this.getEstrelas()) {
			case 5: str.append("*");
			case 4: str.append("*");
			case 3: str.append("*");
			case 2: str.append("*");
			case 1: str.append("*");
		}
		return str.toString();
	}	
	
	private Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getRepEstrelas() + " - " + this.getLocalizacao();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoPoI other = (InfoPoI) obj;
		return Objects.equals(nome, other.nome);
	}

	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setLatitude(Double latitude) {
		this.localizacao.setLatitude(latitude);
	}

	public void setLongitude(Double longitude) {
		this.localizacao.setLongitude(longitude);
	}	
	
	
	
}
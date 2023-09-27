package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.prototype.Prototipavel;

//CONCRETEPROTOTYPE em um PROTOTYPE
public class PoI implements PontoDeInteresse {

	@Override
	public Integer getEstrelas() {
		return 0;
	}

	@Override
	public String getNome() {
		return "Tempo Livre";
	}

	@Override
	public Double getLatitude() {
		return 0.0;
	}

	@Override
	public Double getLongitude() {
		return 0.0;
	}

	@Override
	public void avaliar(Integer estrelas) {
	}

	@Override
	public void setNome(String nome) {
	}

	@Override
	public void setLatitude(Double latitude) {
	}

	@Override
	public void setLongitude(Double longitude) {
	}

	@Override
	public Prototipavel prototipar() {
		return this;
	}

}

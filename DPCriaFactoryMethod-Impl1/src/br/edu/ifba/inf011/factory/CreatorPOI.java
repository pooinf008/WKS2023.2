package br.edu.ifba.inf011.factory;

import br.edu.ifba.inf011.model.PontoDeInteresse;

//CREATOR em um Factory Method
public abstract class CreatorPOI {
	
	public PontoDeInteresse createPOI(String nome, Double latitude, Double longitude) {
		PontoDeInteresse poi = this.create();
		poi.setNome(nome);
		poi.setLatitude(latitude);
		poi.setLongitude(longitude);
		return poi;
	}
	
	public abstract PontoDeInteresse create();
	
}

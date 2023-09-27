package br.edu.ifba.inf011.factory;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.impl.Atracao;
import br.edu.ifba.inf011.model.impl.Restaurante;

public class CreatorPOI {
	
	public PontoDeInteresse createPOI(TipoPOI tipo, String nome, Double latitude, Double longitude) {
		PontoDeInteresse poi = this.create(tipo);
		poi.setNome(nome);
		poi.setLatitude(latitude);
		poi.setLongitude(longitude);
		return poi;
	}
	
	public PontoDeInteresse createPOI(TipoPOI tipo, String nome, Double latitude, Double longitude, Integer estrelas) {
		PontoDeInteresse poi = this.create(tipo);
		poi.setNome(nome);
		poi.setLatitude(latitude);
		poi.setLongitude(longitude);
		poi.avaliar(estrelas);
		return poi;
	}	

	protected PontoDeInteresse create(TipoPOI tipo) {
		switch(tipo) {
			case ATRACAO : 
				return new Atracao();
			default :
				return new Restaurante();
		}
	};

}

package br.edu.ifba.inf011.factory;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.impl.Hotel;

public class CreatorPOI_Hotel extends CreatorPOI{

	protected PontoDeInteresse create(TipoPOI tipo) {
		switch(tipo) {
			case HOTEL : 
				return new Hotel();
			default :
				return super.create(tipo);
		}
	};	
	
}

package br.edu.ifba.inf011.factory;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.impl.Restaurante;

//CONCRETECREATOR em um Factory Method
public class CreatorRestaurante extends CreatorPOI{

	@Override
	public PontoDeInteresse create() {
		return new Restaurante();
	}

}

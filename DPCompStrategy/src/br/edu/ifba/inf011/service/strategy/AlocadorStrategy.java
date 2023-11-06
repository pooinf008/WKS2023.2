package br.edu.ifba.inf011.service.strategy;

import br.edu.ifba.inf011.model.Voo;

//STRATEGY em um STRATEGY
public interface AlocadorStrategy {

	public int[] procederAlocacao(Voo voo);

}

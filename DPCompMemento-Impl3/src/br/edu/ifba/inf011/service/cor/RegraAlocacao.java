package br.edu.ifba.inf011.service.cor;

import br.edu.ifba.inf011.model.Voo;


//HANDLER em um CHAINOFRESPONSIBILITY
public interface RegraAlocacao {
	
	public int[] alocar(Voo voo);

}

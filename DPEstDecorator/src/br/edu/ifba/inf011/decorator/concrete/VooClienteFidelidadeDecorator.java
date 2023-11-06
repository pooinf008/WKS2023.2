package br.edu.ifba.inf011.decorator.concrete;

import br.edu.ifba.inf011.decorator.VooDecorator;
import br.edu.ifba.inf011.model.Voo;

//CONCRETEDECORATOR em DECORATOR
public class VooClienteFidelidadeDecorator extends VooDecorator{
	
	private static final Double DESCONTO_FIDELIDADE = 0.05;

	public VooClienteFidelidadeDecorator(Voo voo) {
		super(voo);
	}	
	
	@Override
	public Double getPreco() {
		return super.getPreco() * (1 -  VooClienteFidelidadeDecorator.DESCONTO_FIDELIDADE);
	}
	
}	


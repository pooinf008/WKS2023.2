package br.edu.ifba.inf011.decorator.concrete;

import br.edu.ifba.inf011.decorator.VooDecorator;
import br.edu.ifba.inf011.model.Voo;

//CONCRETEDECORATOR em DECORATOR
public class VooMalaDecorator extends VooDecorator{
	
	private static final Double PRECO_MALA = 140.00;

	public VooMalaDecorator(Voo voo) {
		super(voo);
	}	
	
	@Override
	public Double getPreco() {
		return super.getPreco() + VooMalaDecorator.PRECO_MALA;
	}
	
}	


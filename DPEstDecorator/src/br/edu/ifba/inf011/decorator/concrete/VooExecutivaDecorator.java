package br.edu.ifba.inf011.decorator.concrete;

import br.edu.ifba.inf011.decorator.VooDecorator;
import br.edu.ifba.inf011.model.Voo;

//CONCRETEDECORATOR em DECORATOR
public class VooExecutivaDecorator extends VooDecorator{
	
	private static final Double PCT_ACRESCIMO = 0.1;

	public VooExecutivaDecorator(Voo voo) {
		super(voo);
	}	
	
	@Override
	public Double getPreco() {
		return (super.isExecutivo())?
					super.getPreco() :
					super.getPreco() * (1+ VooExecutivaDecorator.PCT_ACRESCIMO);
	}
	
	public Boolean isExecutivo() {
		return true;
	};
	
	
}	


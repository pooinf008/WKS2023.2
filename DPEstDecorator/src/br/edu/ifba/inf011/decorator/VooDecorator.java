package br.edu.ifba.inf011.decorator;

import br.edu.ifba.inf011.model.Voo;

//DECORATOR em um DECORATOR
public abstract class VooDecorator implements Voo{
	
	private Voo voo;
	
	public VooDecorator(Voo voo) {
		this.voo = voo;
	}

	@Override
	public String getIATAPartida() {
		return this.voo.getIATAPartida();
	}

	@Override
	public String getIATAChegada() {
		return this.voo.getIATAChegada();
	}

	@Override
	public Double getPreco() {
		return this.voo.getPreco();
	}

	@Override
	public String getNumero() {
		return this.voo.getNumero();
	}
	
	public Boolean isExecutivo() {
		return this.voo.isExecutivo();
	};


}

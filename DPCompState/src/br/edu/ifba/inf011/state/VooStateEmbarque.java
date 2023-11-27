package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTATE em um STATE
public class VooStateEmbarque extends AbstractVooState implements VooState{


	@Override
	public int[] reservar(Voo voo) {
		return this.facaReserva(voo);
	}

	
	@Override
	public VooState abrirCheckin() {
		return new VooStateCheckin();
	}	

	@Override
	public VooState finalizar() {
		return new VooStateFinalizado();
	}

	@Override
	public VooState cancelar() {
		return new VooStateCancelado();
	}
	

}

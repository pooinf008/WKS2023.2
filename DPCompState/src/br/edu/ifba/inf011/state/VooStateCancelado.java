package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTATE em um STATE
public class VooStateCancelado extends AbstractVooState implements VooState{

	@Override
	public void cancelarReserva(Voo voo, int linha, int coluna) {
		this.facaCancelamento(voo, linha, coluna);
		
	}

	@Override
	public VooState abrirReserva() {
		return new VooStateReserva();
	}

	@Override
	public VooState finalizar() {
		return new VooStateFinalizado();
	}

	

}

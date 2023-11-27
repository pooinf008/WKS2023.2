package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTATE em um STATE
public class VooStateReserva extends AbstractVooState implements VooState{

	@Override
	public int[] reservar(Voo voo, int linha, int coluna) {
		return this.facaReserva(voo, linha, coluna);
	}

	@Override
	public void cancelarReserva(Voo voo, int linha, int coluna) {
		this.facaCancelamento(voo, linha, coluna);
	}

	@Override
	public VooState abrirCheckin() {
		return new VooStateCheckin();
	}
	
	@Override
	public VooState cancelar() {
		return new VooStateCancelado();
	}	
		

}

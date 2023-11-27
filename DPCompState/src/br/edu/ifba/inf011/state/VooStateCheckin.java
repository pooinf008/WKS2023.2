package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTATE em um STATE
public class VooStateCheckin extends AbstractVooState implements VooState{

	
	@Override
	public int[] reservar(Voo voo) {
		return this.facaReserva(voo);
	}	

	@Override
	public void cancelarReserva(Voo voo, int linha, int coluna) {
		this.facaCancelamento(voo, linha, coluna);
		
	}

	@Override
	public VooState abrirEmbarque() {
		return new VooStateEmbarque();
	}
	
	@Override
	public VooState cancelar() {
		return new VooStateCancelado();
	}

	

}

package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//STATE em um STATE
public interface VooState {

	public int[] reservar(Voo voo, int linha, int coluna);
	public int[] reservar(Voo voo);
	public void cancelarReserva(Voo voo, int linha, int coluna);
	
	public VooState abrirCheckin();
	public VooState abrirEmbarque();
	public VooState cancelar();
	public VooState abrirReserva();
	public VooState finalizar();	
	
	

}

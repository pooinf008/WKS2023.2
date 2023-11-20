package br.edu.ifba.inf011.service.state;

import br.edu.ifba.inf011.model.Voo;

//STRATEGY em um STRATEGY
public interface VooState {

	public int[] reservar(int linha, int coluna);
	public int[] reservar();
	public void cancelar(int linha, int coluna);
	
	

}

package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.state.VooState;

//CONTEXT em um STATE
public class VooComState implements Voo{

	
	private String numero;
	private boolean[][] cadeiras;
	private VooState state;

	
	public VooComState(String numero, int linhas, int colunas) {
		super();
		this.numero = numero;
		this.cadeiras = new boolean[linhas][colunas];
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				this.cadeiras[iCont][jCont] = false;
		this.state = new VooStateReserva();
				
	}

	public String getNumero() {
		return numero;
	}
	
	/* MUDAN�A DE ESTADOS */
	public void abrirCheckin() {
		this.state = this.state.abrirCheckin();
	}
	
	public void abrirEmbarque() {
		this.state = this.state.abrirEmbarque();
	}
	
	public void cancelar() {
		this.state = this.state.cancelar();
	}	
	
	public void abrirReserva() {
		this.state = this.state.abrirReserva();
	}

	public void finalizar() {
		this.state = this.state.finalizar();
	}	
	
	@Override
	public int[] facaReserva(Integer linha, Integer coluna) {
		this.cadeiras[linha][coluna] = true;
		return null;
	}
	
	
	@Override
	public int[] reservar(Integer linha, Integer coluna) {
		return this.state.reservar(this, linha, coluna);
	}


	@Override
	public boolean disponivel(Integer linha, Integer coluna) {
		return !this.cadeiras[linha][coluna];
	}


	@Override
	public int[] reservar() {
		return this.state.reservar(this);
	}

	@Override
	public void cancelarReserva(Integer linha, Integer coluna) {
		this.state.cancelarReserva(this, linha, coluna);
	}
	
	
	public int getQtdeLinhas() {
		return this.cadeiras.length;
	}	
	
	public int getQtdeColunas() {
		return this.cadeiras[0].length;
	}

	@Override
	public void facaCancelamento(Integer linha, Integer coluna) {
		this.cadeiras[linha][coluna] = false;
	}	
	
	
	
}

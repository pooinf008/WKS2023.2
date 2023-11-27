package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Voo;

public class VooImpl implements Voo{

	
	private String numero;
	private boolean[][] cadeiras;
	private VooState state;

	
	public VooImpl(String numero, int linhas, int colunas) {
		super();
		this.numero = numero;
		this.cadeiras = new boolean[linhas][colunas];
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				this.cadeiras[iCont][jCont] = false;
		this.state = VooState.RESERVA;
				
	}

	public String getNumero() {
		return numero;
	}
	
	/* MUDAN�A DE ESTADOS */
	public void abrirCheckin() {
		if(this.state == VooState.RESERVA || this.state == VooState.EMBARQUE)
			this.state = VooState.CHECKIN;
	}
	
	public void abrirEmbarque() {
		if(this.state == VooState.RESERVA)
			this.state = VooState.CHECKIN;
	}
	
	public void cancelar() {
		if(this.state != VooState.FINALIZADO)
			this.state = VooState.CANCELA;
	}	
	
	public void abrirReserva() {
		if(this.state == VooState.CANCELA)
			this.state = VooState.RESERVA;
	}

	public void finalizar() {
		if(this.state == VooState.EMBARQUE || this.state == VooState.CANCELA)
			this.state = VooState.CANCELA;
	}	
	
	
	
	
	@Override
	public int[] reservar(Integer linha, Integer coluna) {
		if(state != VooState.RESERVA)
			return null;
		return this.facaReserva(linha, coluna);
	}


	@Override
	public boolean disponivel(Integer linha, Integer coluna) {
		return !this.cadeiras[linha][coluna];
	}


	@Override
	public int[] reservar() {
		if(!(state == VooState.CHECKIN || state == VooState.EMBARQUE))
			return null;

		int[] posicao = new int[2];
		for(int iCount = 0; iCount < this.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < this.getQtdeColunas(); jCount++)
					if(this.disponivel(iCount, jCount)) {
						posicao[Voo.LINHA] = iCount;
						posicao[Voo.COLUNA] = jCount;
						return this.facaReserva(posicao[Voo.LINHA], posicao[Voo.COLUNA]);
				}
		return null;
	}

	@Override
	public void cancelarReserva(Integer linha, Integer coluna) {
		if(state != VooState.CHECKIN && state != VooState.EMBARQUE)
			return;		
		this.facaCancelamento(linha, coluna);
	}
	
	
	public int getQtdeLinhas() {
		return this.cadeiras.length;
	}	
	
	public int getQtdeColunas() {
		return this.cadeiras[0].length;
	}

	@Override
	public int[] facaReserva(Integer linha, Integer coluna) {
		if(!this.disponivel(linha, coluna))
			return null;
		int[] posicao = new int[2];
		posicao[0] = linha;
		posicao[1] = coluna;
		this.cadeiras[linha][coluna] = true;
		return posicao;
	}


	@Override
	public void facaCancelamento(Integer linha, Integer coluna) {
		this.cadeiras[linha][coluna] = false;
	}	
	
	
	
}

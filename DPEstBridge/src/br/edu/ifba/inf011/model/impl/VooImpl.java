package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Voo;

public class VooImpl implements Voo{
	
	private String iataPartida;
	private String iataChegada;
	private Double preco;
	private String numero;
	private boolean[][] cadeiras;
	
	
	public VooImpl(String iataPartida, String iataChegada, Double preco, String numero, int linhas, int colunas) {
		super();
		this.iataPartida = iataPartida;
		this.iataChegada = iataChegada;
		this.preco = preco;
		this.numero = numero;
		this.cadeiras = new boolean[linhas][colunas];
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				this.cadeiras[iCont][jCont] = false;
				
	}


	public String getIATAPartida() {
		return iataPartida;
	}


	public String getIATAChegada() {
		return iataChegada;
	}

	public String getNumero() {
		return numero;
	}


	@Override
	public Double getPreco() {
		return this.preco;
	}


	@Override
	public void reservar(Integer linha, Integer coluna) {
		this.cadeiras[linha][coluna] = true;
	}


	@Override
	public boolean disponivel(Integer linha, Integer coluna) {
		return !this.cadeiras[linha][coluna];
	}
	
	


}

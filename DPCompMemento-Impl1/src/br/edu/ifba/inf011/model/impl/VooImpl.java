package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.memento.impl1.VooOriginator;
import br.edu.ifba.inf011.model.memento.impl1.VooSnapshot;
import br.edu.ifba.inf011.service.cor.Alocador;

public class VooImpl implements VooOriginator{
	
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
	
	@Override
	public int getQtdeLinhas() {
		return this.cadeiras.length;
	}	
	
	@Override
	public int getQtdeColunas() {
		return this.cadeiras[0].length;
	}


	@Override
	public Integer alocados() {
		int qtdeAlocados = 0; 
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				if (this.cadeiras[iCont][jCont])
					qtdeAlocados++;

		return qtdeAlocados;
	}
	
	public VooSnapshot save() {
		return new VooSnapshot(this.cadeiras);
	}
	
	public void restore(VooSnapshot snapshot) {
		boolean[][] cadeiras =  snapshot.getState();
		
		this.cadeiras = new boolean[cadeiras.length][cadeiras[0].length];
		for(int iCount = 0; iCount < this.cadeiras.length; iCount++)
			for(int jCount = 0; jCount < this.cadeiras[iCount].length; jCount++)
				this.cadeiras[iCount][jCount] = cadeiras[iCount][jCount];
		
		
	}	
	
	
	public String getCadeiras() {
		int qtde = 0;
		StringBuffer cadeiras = new StringBuffer();
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				if (this.cadeiras[iCont][jCont]) {
					cadeiras.append(this.cadeiraId(iCont, jCont) + " ");
					qtde++;
				}
		return qtde + " " + cadeiras.toString();
		
	}
	
	private String cadeiraId(int linha, int coluna) {
		char chLinha = (char) ('1' + linha);
		char chColuna = (char) ('A' + coluna);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;

	}
	
	
}

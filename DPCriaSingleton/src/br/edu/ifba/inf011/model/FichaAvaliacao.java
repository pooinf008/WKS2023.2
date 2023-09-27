package br.edu.ifba.inf011.model;

public class FichaAvaliacao {
	
	private String nomeRoteiro;
	private Integer somaAvaliacaoPoI;
	private Integer qtdePOI;
	
	
	public FichaAvaliacao(String nomeRoteiro, Integer qtdePOI, Integer somaAvaliacaoPoI) {
		super();
		this.nomeRoteiro = nomeRoteiro;
		this.qtdePOI = qtdePOI;
		this.somaAvaliacaoPoI = somaAvaliacaoPoI;
	}
	
	public Double getAvaliacaoMedia() {
		return Double.valueOf(this.somaAvaliacaoPoI) / this.qtdePOI;
	}
	
	public String toString() {
		return "Roteiro " + this.nomeRoteiro + ": " + this.getAvaliacaoMedia() + " (" + this.qtdePOI + " Pontos de Interesse)."; 
	}
	
	
	
	
	

}

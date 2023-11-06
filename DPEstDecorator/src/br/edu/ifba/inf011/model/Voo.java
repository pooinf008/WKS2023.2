package br.edu.ifba.inf011.model;


//COMPONENT em DECORATOR
public interface Voo{
	public String getIATAPartida();
	public String getIATAChegada();
	public Double getPreco();
	public String getNumero();
	public Boolean isExecutivo();
}

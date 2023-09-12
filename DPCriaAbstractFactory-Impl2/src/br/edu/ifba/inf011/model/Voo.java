package br.edu.ifba.inf011.model;

//ABSTRACT PRODUCT em um ABSTRACT FACTORY
public interface Voo extends DataVoucher{
	
	public String getIATAPartida();
	public String getIATAChegada();
	public Double getPrecoOriginal();
	public Double getPrecoConvertido();
	public void init(String iATAPartida, String iATAChegada, Double preco);
}

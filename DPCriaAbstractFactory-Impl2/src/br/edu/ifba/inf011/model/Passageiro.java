package br.edu.ifba.inf011.model;

//ABSTRACT PRODUCT em um ABSTRACT FACTORY
public interface Passageiro extends DataVoucher{
	
	public String getNome();
	public String getDocumentoEmbarque();
	public void init(String nome, String rg, String passaporte);

}

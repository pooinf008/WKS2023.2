package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.service.ReservaException;

//COMPONENT em COMPOSITE
public interface Voo{
	public String getIATAPartida();
	public String getIATAChegada();
	public Double getPreco();
	public String getNumero();
	public void addVoo(Voo voo) throws ReservaException;
	public void removeVoo(Voo voo) throws ReservaException;
	public void setPai(Voo voo) throws ReservaException;
}

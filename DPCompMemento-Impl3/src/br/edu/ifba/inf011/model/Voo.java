package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.memento.impl2.VooOriginator;

//TARGET em ADAPTER
public interface Voo {
	public String getIATAPartida();
	public String getIATAChegada();
	public Double getPreco();
	public String getNumero();
	public void reservar(Integer linha, Integer coluna);
	public boolean disponivel(Integer linha, Integer coluna);
	public int getQtdeLinhas();
	public int getQtdeColunas();
	public Integer alocados();
	public String getCadeiras();
}

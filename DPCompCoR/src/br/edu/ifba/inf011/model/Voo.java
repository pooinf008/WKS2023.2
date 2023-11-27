package br.edu.ifba.inf011.model;


//TARGET em ADAPTER
public interface Voo{
	public String getIATAPartida();
	public String getIATAChegada();
	public Double getPreco();
	public String getNumero();
	public void reservar(Integer linha, Integer coluna);
	public boolean disponivel(Integer linha, Integer coluna);
	public int getQtdeLinhas();
	public int getQtdeColunas();
	public Integer alocados();
}

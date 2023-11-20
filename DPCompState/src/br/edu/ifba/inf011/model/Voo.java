package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.impl.VooState;

public interface Voo{
	
	public static final int LINHA = 0;
	public static final int COLUNA = 1;	
	
	
	public static String printReserva(int[] poltrona) {
		if(poltrona == null)
			return "NÃO LOCALIZADO";
		char chLinha = (char) ('1' + poltrona[Voo.LINHA]);
		char chColuna = (char) ('A' + poltrona[Voo.COLUNA]);
		String strPoltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return strPoltrona;
	}
	
	public String getNumero();
	public int[] reservar(Integer linha, Integer coluna);
	public int[] reservar();
	public void cancelarReserva(Integer linha, Integer coluna);
	public boolean disponivel(Integer linha, Integer coluna);
	
	public void abrirCheckin();
	public void abrirEmbarque();
	public void cancelar();
	public void abrirReserva();
	public void finalizar();
}

package br.edu.ifba.inf011.service.versao2;

import br.edu.ifba.inf011.model.Voo;
import java.util.Random;

public abstract class Alocador {
	
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;

	public static final int RANDOM = 0;
	public static final int POR_LINHA = 1;
	public static final int POR_COLUNA = 2;
	
	
	protected Voo voo;
	
	public Alocador(Voo voo) {
		this.voo = voo;
	}
	
	public String alocar() {
		int posicao[] = this.procederAlocacao(); 

		char chLinha = (char) ('1' + posicao[Alocador.LINHA]);
		char chColuna = (char) ('A' + posicao[Alocador.COLUNA]);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;
	}
	
	public abstract int[] procederAlocacao();
	
	

}

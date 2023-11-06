package br.edu.ifba.inf011.service.versao1;

import br.edu.ifba.inf011.model.Voo;
import java.util.Random;

public class Alocador {
	
	private static final int LINHA = 0;
	private static final int COLUNA = 1;

	public static final int RANDOM = 0;
	public static final int POR_LINHA = 1;
	public static final int POR_COLUNA = 2;
	
	
	private Voo voo;
	
	public Alocador(Voo voo) {
		this.voo = voo;
	}
	
	public String alocar(int estrategiaAlocacao) {
		int posicao[]; 
		if(estrategiaAlocacao == Alocador.RANDOM)
			posicao = this.procederAlocacaoRandom();
		else if(estrategiaAlocacao == Alocador.POR_LINHA)
			posicao = this.procederAlocacaoPorLinha();
		else if(estrategiaAlocacao == Alocador.POR_COLUNA)
			posicao = this.procederAlocacaoPorColuna();
		else
			return "";
		char chLinha = (char) ('1' + posicao[Alocador.LINHA]);
		char chColuna = (char) ('A' + posicao[Alocador.COLUNA]);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;
	}
	
	public int[] procederAlocacaoRandom() {
		int[] posicao = new int[2];
		Random random = new Random();
		
		do {
			posicao[Alocador.LINHA] = random.nextInt(this.voo.getQtdeLinhas());
			posicao[Alocador.COLUNA] = random.nextInt(this.voo.getQtdeColunas());
		}while(!this.voo.disponivel(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]));
		
		this.voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
		
		return posicao;
		
	}
	
	public int[] procederAlocacaoPorLinha() {
		int[] posicao = new int[2];
		for(int iCount = 0; iCount < this.voo.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < this.voo.getQtdeColunas(); jCount++)
					if(this.voo.disponivel(iCount, jCount)) {
						posicao[Alocador.LINHA] = iCount;
						posicao[Alocador.COLUNA] = jCount;
						this.voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
						return posicao;
				}
		return null;
	}
	
	public int[] procederAlocacaoPorColuna() {
		int[] posicao = new int[2];
		for(int iCount = 0; iCount < this.voo.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < this.voo.getQtdeColunas(); jCount++)
					if(this.voo.disponivel(jCount, iCount)) {
						posicao[Alocador.LINHA] = jCount;
						posicao[Alocador.COLUNA] = iCount;
						this.voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
						return posicao;
				}
		return null;
	}	
	
	
	
	
	
	
	
	

}

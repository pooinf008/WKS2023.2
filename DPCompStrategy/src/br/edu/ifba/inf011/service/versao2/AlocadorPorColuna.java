package br.edu.ifba.inf011.service.versao2;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.versao2.Alocador;

public class AlocadorPorColuna extends Alocador{
	
	
	public AlocadorPorColuna(Voo voo) {
		super(voo);
	}

	public int[] procederAlocacao() {
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

package br.edu.ifba.inf011.service.versao2;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

public class AlocadorPorLinha extends Alocador{
	
	
	public AlocadorPorLinha(Voo voo) {
		super(voo);
	}

	public int[] procederAlocacao() {
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
	

}

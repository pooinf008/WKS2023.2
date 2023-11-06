package br.edu.ifba.inf011.service.strategy;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTRATEGY em um STRATEGY
public class PorColunaAlocadorStrategy implements AlocadorStrategy {

	@Override
	public int[] procederAlocacao(Voo voo) {
		int[] posicao = new int[2];
		for(int iCount = 0; iCount <voo.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < voo.getQtdeColunas(); jCount++)
					if(voo.disponivel(jCount, iCount)) {
						posicao[Alocador.LINHA] = jCount;
						posicao[Alocador.COLUNA] = iCount;
						voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
						return posicao;
				}
		return null;
	}

}

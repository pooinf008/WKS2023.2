package br.edu.ifba.inf011.service.strategy;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTRATEGY em um STRATEGY
public class PorLinhaAlocadorStrategy implements AlocadorStrategy {

	@Override
	public int[] procederAlocacao(Voo voo) {
		int[] posicao = new int[2];
		for(int iCount = 0; iCount < voo.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < voo.getQtdeColunas(); jCount++)
					if(voo.disponivel(iCount, jCount)) {
						posicao[Alocador.LINHA] = iCount;
						posicao[Alocador.COLUNA] = jCount;
						voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
						return posicao;
				}
		return null;
	}

}

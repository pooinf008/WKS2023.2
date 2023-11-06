package br.edu.ifba.inf011.service.strategy;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

//CONCRETESTRATEGY em um STRATEGY
public class RandomAlocadorStrategy implements AlocadorStrategy {

	@Override
	public int[] procederAlocacao(Voo voo) {
		int[] posicao = new int[2];
		Random random = new Random();
		
		do {
			posicao[Alocador.LINHA] = random.nextInt(voo.getQtdeLinhas());
			posicao[Alocador.COLUNA] = random.nextInt(voo.getQtdeColunas());
		}while(!voo.disponivel(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]));
		
		voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
		
		return posicao;
	}

}

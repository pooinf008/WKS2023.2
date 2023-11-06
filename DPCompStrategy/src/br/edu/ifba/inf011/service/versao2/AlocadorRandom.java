package br.edu.ifba.inf011.service.versao2;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

public class AlocadorRandom extends Alocador{
	
	public AlocadorRandom(Voo voo) {
		super(voo);
	}

	public int[] procederAlocacao() {
		int[] posicao = new int[2];
		Random random = new Random();
		
		do {
			posicao[Alocador.LINHA] = random.nextInt(this.voo.getQtdeLinhas());
			posicao[Alocador.COLUNA] = random.nextInt(this.voo.getQtdeColunas());
		}while(!this.voo.disponivel(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]));
		
		this.voo.reservar(posicao[Alocador.LINHA], posicao[Alocador.COLUNA]);
		
		return posicao;
		
	}
	

}

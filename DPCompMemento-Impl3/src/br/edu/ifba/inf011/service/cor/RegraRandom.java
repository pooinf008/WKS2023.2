package br.edu.ifba.inf011.service.cor;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

//CONCRETEHANDLER em um CHAINOFRESPONSIBILITY
//SUBCLASS em um TEMPLATEMETHOD
public class RegraRandom extends AbstractRegraAlocacao {
	
	public RegraRandom(){
		super(null, null);
	}	
	
	public RegraRandom(Integer divisor, AbstractRegraAlocacao sucessor){
		super(divisor, sucessor);
	}	
	
	
	
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

	@Override
	protected boolean isAplicavel(Voo voo) {
		return true;
	}

}

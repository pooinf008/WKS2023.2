package br.edu.ifba.inf011.service.cor;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

//CONCRETEHANDLER em um CHAINOFRESPONSIBILITY
//SUBCLASS em um TEMPLATEMETHOD
public class RegraAlocacaoColuna extends AbstractRegraAlocacao {
	
	public RegraAlocacaoColuna(){
		super(null, null);
	}	
	
	public RegraAlocacaoColuna(Integer divisor, AbstractRegraAlocacao sucessor){
		super(divisor, sucessor);
	}	
	
	
	
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

	@Override
	protected boolean isAplicavel(Voo voo) {
		return (voo.alocados() % this.getDivisor()) == 0 ;
	}

}

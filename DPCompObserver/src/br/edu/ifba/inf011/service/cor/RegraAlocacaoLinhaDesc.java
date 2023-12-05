package br.edu.ifba.inf011.service.cor;

import java.util.Random;

import br.edu.ifba.inf011.model.Voo;

//CONCRETEHANDLER em um CHAINOFRESPONSIBILITY
//SUBCLASS em um TEMPLATEMETHOD
public class RegraAlocacaoLinhaDesc extends AbstractRegraAlocacao {
	
	public RegraAlocacaoLinhaDesc(){
		super(null, null);
	}	
	
	public RegraAlocacaoLinhaDesc(Integer divisor, AbstractRegraAlocacao sucessor){
		super(divisor, sucessor);
	}	
	
	@Override
	public int[] procederAlocacao(Voo voo) {
		int[] posicao = new int[2];
		for(int iCount = voo.getQtdeLinhas() - 1; iCount >= 0; iCount--)
			for(int jCount = voo.getQtdeColunas() - 1; jCount >= 0; jCount--)
					if(voo.disponivel(iCount, jCount)) {
						posicao[Alocador.LINHA] = iCount;
						posicao[Alocador.COLUNA] = jCount;
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

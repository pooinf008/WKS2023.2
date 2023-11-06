package br.edu.ifba.inf011.service.strategy;

import br.edu.ifba.inf011.model.Voo;

//CONTEXT em um STRATEGY
public class Alocador {
	
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;
	
	protected Voo voo;
	private AlocadorStrategy alocadorStrategy; 
	
	public Alocador(Voo voo) {
		this.voo = voo;
		this.alocadorStrategy = new RandomAlocadorStrategy();
	}
	
	public void setAlocadorStrategy(AlocadorStrategy alocadorStrategy) {
		this.alocadorStrategy = alocadorStrategy;
	}
	
	public String alocar() {
		int posicao[] = this.alocadorStrategy.procederAlocacao(voo); 

		char chLinha = (char) ('1' + posicao[Alocador.LINHA]);
		char chColuna = (char) ('A' + posicao[Alocador.COLUNA]);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;
	}
	
	

}

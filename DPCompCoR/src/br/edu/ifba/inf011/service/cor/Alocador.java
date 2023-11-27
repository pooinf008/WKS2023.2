package br.edu.ifba.inf011.service.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Voo;

//CLIENT em um CHAINOFRESPONSIBILITY
public class Alocador {
	
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;
	
	protected Voo voo;
	private RegraAlocacao regras; 
	
	public Alocador(RegraAlocacao regras, Voo voo) {
		this.voo = voo;
		this.regras = regras;
	}
	
	
	public String alocar() {
		int posicao[] = this.regras.alocar(voo); 

		char chLinha = (char) ('1' + posicao[Alocador.LINHA]);
		char chColuna = (char) ('A' + posicao[Alocador.COLUNA]);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;
	}
	
	

}

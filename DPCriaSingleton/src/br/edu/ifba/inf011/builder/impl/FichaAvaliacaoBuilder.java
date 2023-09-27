package br.edu.ifba.inf011.builder.impl;


import br.edu.ifba.inf011.builder.Builder;
import br.edu.ifba.inf011.model.FichaAvaliacao;
import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.impl.Hotel;

public class FichaAvaliacaoBuilder implements Builder{
	
	private String nome;
	private Integer somaAvaliacao;
	private Integer qtdeAvaliacao;
	
	public void reset() {
		this.nome = "";
		this.somaAvaliacao = 0;
		this.qtdeAvaliacao = 0;
	};

	@Override
	public void withName(String nome) {
		this.nome = nome;
	};
	
	@Override
	public void withHospedagem(Hotel hotel, Integer inicio, Integer fim) {
	}

	@Override
	public void visitPoI(PontoDeInteresse poi, Integer ordem, Integer dia) {
		this.qtdeAvaliacao++;
		this.somaAvaliacao+= poi.getEstrelas();
	}
	
	
	public FichaAvaliacao get() {
		return new FichaAvaliacao(this.nome, this.qtdeAvaliacao, this.somaAvaliacao);
	}
	
	

}

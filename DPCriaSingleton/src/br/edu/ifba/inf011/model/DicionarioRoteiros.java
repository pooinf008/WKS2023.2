package br.edu.ifba.inf011.model;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.builder.RoteiroDirector;
import br.edu.ifba.inf011.builder.impl.RoteiroBuilder;

//SINGLETON em um SINGLETON
public class DicionarioRoteiros {
	
	private static DicionarioRoteiros dicionario = null;
	
	public static DicionarioRoteiros instance() {
		if(DicionarioRoteiros.dicionario == null)
			DicionarioRoteiros.dicionario = new DicionarioRoteiros();
		return DicionarioRoteiros.dicionario;
	}
	
	protected Map<String, Roteiro> roteiros;
	
	private DicionarioRoteiros(){
		this.roteiros = new HashMap<String, Roteiro>();
		this.init();
	}
	
	private void init() {
		RoteiroBuilder roteiroBuilder = new RoteiroBuilder();
		RoteiroDirector director = new RoteiroDirector(roteiroBuilder);
		director.criarRoteiroSalvador5Dias();
		Roteiro roteiro = roteiroBuilder.get();
		this.roteiros.put(roteiro.getNome(), roteiro);
		director.criarRoteiroSalvador3Dias();
		roteiro = roteiroBuilder.get();
		this.roteiros.put(roteiro.getNome(), roteiro);
	}
	
	public Roteiro get(String nome) {
		return (Roteiro) this.roteiros.get(nome).prototipar();
	}

}

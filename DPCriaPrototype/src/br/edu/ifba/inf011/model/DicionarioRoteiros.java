package br.edu.ifba.inf011.model;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.builder.RoteiroDirector;
import br.edu.ifba.inf011.builder.impl.RoteiroBuilder;

//CLIENT em um PROTOTYPE
public class DicionarioRoteiros {
	
	private Map<String, Roteiro> roteiros;
	
	public DicionarioRoteiros(){
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

package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.builder.RoteiroDirector;
import br.edu.ifba.inf011.builder.impl.RoteiroBuilder;

//SINGLETON em um SINGLETON
public class PoolDicionarioRoteiros {
	
	private static final Integer NUM_INSTANCIAS = 3;
	
	private static List<PoolDicionarioRoteiros> dicionarios = null;
	private static Integer proximo = 0;
	
	public static PoolDicionarioRoteiros instance() {
		if(PoolDicionarioRoteiros.dicionarios == null) {
			PoolDicionarioRoteiros.dicionarios = new ArrayList<PoolDicionarioRoteiros>();
			for(int iCount = 0; iCount < PoolDicionarioRoteiros.NUM_INSTANCIAS; iCount++)
				PoolDicionarioRoteiros.dicionarios.add(new PoolDicionarioRoteiros());
		}
		return PoolDicionarioRoteiros.dicionarios.get(PoolDicionarioRoteiros.proximo++ % 3);
	}
	
	protected Map<String, Roteiro> roteiros;
	
	private PoolDicionarioRoteiros(){
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

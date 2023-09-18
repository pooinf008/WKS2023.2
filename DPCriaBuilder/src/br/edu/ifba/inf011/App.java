package br.edu.ifba.inf011;

import br.edu.ifba.inf011.builder.Builder;
import br.edu.ifba.inf011.builder.RoteiroDirector;
import br.edu.ifba.inf011.builder.impl.FichaAvaliacaoBuilder;
import br.edu.ifba.inf011.builder.impl.RoteiroBuilder;
import br.edu.ifba.inf011.model.FichaAvaliacao;
import br.edu.ifba.inf011.model.Roteiro;
import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.model.impl.Restaurante;

public class App {
	
	private void rodar() {
		
		RoteiroBuilder roteiroBuilder = new RoteiroBuilder();
		FichaAvaliacaoBuilder fichaAvaliacaoBuilder = new FichaAvaliacaoBuilder();
		RoteiroDirector director = new RoteiroDirector();
		
		director.setBuilder(roteiroBuilder);
		director.criarRoteiroSalvador3Dias();
		Roteiro roteiro = roteiroBuilder.get();
		System.out.println(roteiro);
		
		System.out.println("*********************");
		
		director.setBuilder(fichaAvaliacaoBuilder);
		director.criarRoteiroSalvador3Dias();
		FichaAvaliacao ficha = fichaAvaliacaoBuilder.get();
		System.out.println(ficha);
		
		
	}

	public static void main(String[] args) {
		(new App()).rodar();
	}
	
}

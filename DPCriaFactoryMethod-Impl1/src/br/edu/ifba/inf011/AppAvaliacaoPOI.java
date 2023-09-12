package br.edu.ifba.inf011;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.factory.CreatorPOI;
import br.edu.ifba.inf011.factory.TipoPOI;
import br.edu.ifba.inf011.model.PontoDeInteresse;

public class AppAvaliacaoPOI {
	
	private CreatorPOI creatorPOI;
	
	public AppAvaliacaoPOI(TipoPOI tipo) {
		this(tipo.factory());
	}	
	
	public AppAvaliacaoPOI(CreatorPOI creatorPOI) {
		this.creatorPOI = creatorPOI;
	}
	
	public void avaliar() {
		List<Integer> notas = new ArrayList<Integer>();
		notas.add(9);
		notas.add(8);
		notas.add(10);
		notas.add(10);
		notas.add(9);
		notas.add(10);
		int estrelas = (int) (Math.round((notas.stream().mapToInt(p->p.intValue()).summaryStatistics().getAverage()) / 2));
		
		PontoDeInteresse poi =  this.creatorPOI.create();
		poi.setNome("Restaurante Porto da Barra");
		poi.setLatitude(13.00);
		poi.setLongitude(38.53);
		poi.avaliar(estrelas);

		System.out.println(poi);
		System.out.println(poi.getClass().getSimpleName());
	}
	
}

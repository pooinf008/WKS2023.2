package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.Atracao;
import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.model.impl.Restaurante;
import br.edu.ifba.inf011.visitor.XMLVisitor;
import br.edu.ifba.inf011.visitor.FormatterVisitor;
import br.edu.ifba.inf011.visitor.JSONVisitor;

public class App {
	
	private void rodar() {
		Hotel hotel = new Hotel("Hotel da Bahia", 4, 15.0, 20.0);
		Restaurante restaurante = new Restaurante("Restaurante da Bahia",
												  "Cozinha Baiana", 
												   4, 20.0, 15.0);
		Atracao atracao = new Atracao(true, "Monumento da Bahia",
									  4, 32.0, 18.0);
		
		FormatterVisitor visitor = new XMLVisitor();
		
		System.out.println(atracao.aceitarVisita(visitor));
		System.out.println(hotel.aceitarVisita(visitor));
		System.out.println(restaurante.aceitarVisita(visitor));		
		
				
	}

	public static void main(String[] args) {
		(new App()).rodar();
	}
	
}


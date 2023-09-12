package br.edu.ifba.inf011;

import br.edu.ifba.inf011.factory.TipoPOI;
import br.edu.ifba.inf011.factory.CreatorPOI_Hotel;

public class App {

	public static void main(String[] args) {
		AppAvaliacaoPOI app = new AppAvaliacaoPOI(new CreatorPOI_Hotel());
		app.avaliar(TipoPOI.HOTEL, "Hotel da Bahia", 13.0, 32.0);
		
	}
}

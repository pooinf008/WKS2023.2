package br.edu.ifba.inf011;

import br.edu.ifba.inf011.factory.TipoPOI;

public class App {

	public static void main(String[] args) {
		AppAvaliacaoPOI app = new AppAvaliacaoPOI(TipoPOI.HOTEL);
		app.avaliar();
	}
}

package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.DicionarioRoteiros;
import br.edu.ifba.inf011.model.Roteiro;


public class App {

	private void rodar() {
		DicionarioRoteiros dictRoteiros = new DicionarioRoteiros();
		Roteiro roteiro = dictRoteiros.get("Salvador 5 dias");
		roteiro.setNome("SSA 5 dias - Personalizado");
		System.out.println(roteiro);
		System.out.println(">>>>*********<<<<");
		roteiro = dictRoteiros.get("Salvador 5 dias");
		System.out.println(roteiro);
		System.out.println(">>>>*********<<<<");
	}	

	public static void main(String[] args) {
		(new App()).rodar();
	}

	
}

package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.DicionarioRoteiros;
import br.edu.ifba.inf011.model.PoolDicionarioRoteiros;
import br.edu.ifba.inf011.model.Roteiro;


public class App {
	
	private void rodar2() {
		
		for(int iCount = 0; iCount < 10; iCount ++) {
				PoolDicionarioRoteiros dictRoteiros = PoolDicionarioRoteiros.instance();
				System.out.println(dictRoteiros);
		}
		
		System.out.println("****************************");
		
		for(int iCount = 0; iCount < 10; iCount ++) {
			DicionarioRoteiros dictRoteiros = DicionarioRoteiros.instance();
			System.out.println(dictRoteiros);
		}
		
	}	

	private void rodar() {
		DicionarioRoteiros dictRoteiros = DicionarioRoteiros.instance();
		Roteiro roteiro = dictRoteiros.get("Salvador 5 dias");
		roteiro.setNome("SSA 5 dias - Personalizado");
		System.out.println(roteiro);
		System.out.println(">>>>*********<<<<");
		roteiro = dictRoteiros.get("Salvador 5 dias");
		System.out.println(roteiro);
		System.out.println(">>>>*********<<<<");
		
	}	

	public static void main(String[] args) {
		(new App()).rodar2();
	}

	
}

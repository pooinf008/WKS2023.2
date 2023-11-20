package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.model.Voo;


//CLIENT em um STRATEGY
public class Aplicacao {
	
	public void run()  {
		
		
		Voo voo = new VooImpl("G31400", 9, 6);
		for(int iCount = 0; iCount < 15; iCount++) {
			int[] poltrona = null; 
			poltrona = voo.reservar();
			System.out.println(Voo.printReserva(poltrona));
		}
			
		
		
	}
	
	public static void main(String[] args) {
		(new Aplicacao()).run();
	}

}

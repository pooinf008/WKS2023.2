package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.service.strategy.Alocador;
import br.edu.ifba.inf011.service.strategy.PorLinhaAlocadorStrategy;
import br.edu.ifba.inf011.model.Voo;


//CLIENT em um STRATEGY
public class Aplicacao {
	
	public void run()  {
		
		
		Voo voo = new VooImpl("SSA", "GRU", 1000.0, "G31400", 9, 6);
		Alocador alocador = new Alocador(voo);
		
		for(int iCount = 0; iCount < 15; iCount++) {
			String poltrona = ""; 
			if(iCount == 4)
				alocador.setAlocadorStrategy(new PorLinhaAlocadorStrategy());
			poltrona = alocador.alocar();
			System.out.println(poltrona);
		}
			
		
		
	}
	
	public static void main(String[] args) {
		(new Aplicacao()).run();
	}

}

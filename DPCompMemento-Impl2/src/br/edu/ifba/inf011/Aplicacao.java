package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.model.memento.impl2.VooOriginator;
import br.edu.ifba.inf011.service.cor.Alocador;
import br.edu.ifba.inf011.service.cor.RegraRandom;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoLinha;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoLinhaDesc;
import br.edu.ifba.inf011.service.cor.AbstractRegraAlocacao;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColuna;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColunaDesc;
import br.edu.ifba.inf011.service.cor.RegraAlocacao;


public class Aplicacao {
	
	public void run()  {
		
		VooOriginator
			voo = new VooImpl("SSA", "GRU", 1000.0, "G31400", 9, 6);
		RegraAlocacao regras = new RegraAlocacaoLinhaDesc(4,
									new RegraAlocacaoColunaDesc(3, 
										new RegraAlocacaoColuna(2, 
												new RegraRandom())));
		Alocador alocador = new Alocador(regras, voo);
		
		for(int iCount = 0; iCount < 15; iCount++) {
			alocador.alocar();
			alocador.checkpoint();
			System.out.println(voo.getCadeiras());
		}
		
		for(int iCount = 0; iCount < 10; iCount++) {
			alocador.undo();
			System.out.println(voo.getCadeiras());
		}
				
		
	}
	
	public static void main(String[] args) {
		(new Aplicacao()).run();
	}

}

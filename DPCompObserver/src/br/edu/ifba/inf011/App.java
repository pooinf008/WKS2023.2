package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.service.cor.Alocador;
import br.edu.ifba.inf011.service.cor.RegraAlocacao;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColuna;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColunaDesc;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoLinhaDesc;
import br.edu.ifba.inf011.service.cor.RegraRandom;

public class App {

	
	public void execute() throws InterruptedException {
		RegraAlocacao regras = new RegraAlocacaoLinhaDesc(4,
				new RegraAlocacaoColunaDesc(3, 
					new RegraAlocacaoColuna(2, 
							new RegraRandom())));
		Voo voo = new VooImpl("SSA", "GRU", 1000.0, "G31400", 9, 6);
		Alocador alocador = new Alocador(regras, voo);
		
		Thread thread1 = new Thread(new Aplicacao(alocador, System.out));
		Thread thread2 = new Thread(new Aplicacao(alocador, System.err));

		thread1.start();
		Thread.sleep(100);
		thread2.start();
		Thread.sleep(100);
		
	
	}
	public static void main(String[] args) throws InterruptedException {
		(new App()).execute();
	}
	

}

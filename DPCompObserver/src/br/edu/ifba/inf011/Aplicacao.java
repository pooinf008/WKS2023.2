package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.observer.Observer;
import br.edu.ifba.inf011.service.cor.Alocador;
import br.edu.ifba.inf011.service.cor.RegraRandom;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoLinhaDesc;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColuna;
import br.edu.ifba.inf011.service.cor.RegraAlocacaoColunaDesc;
import br.edu.ifba.inf011.service.cor.RegraAlocacao;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Voo;


public class Aplicacao implements Observer, Runnable {
	
	
	private Alocador alocador;
	private PrintStream out;
	
	public Aplicacao(Alocador alocador, PrintStream out) {
		this.alocador = alocador;
		this.alocador.attachObserver(this);
		this.out = out;
	}
	
	
	public void run()  {
		
		for(int iCount = 0; iCount < 5; iCount++) {
			String poltrona = ""; 
			poltrona = this.alocador.alocar();
			this.out.println(poltrona);
		}
			
	}
	
	@Override
	public void update() {
		this.out.println(alocador.qtdePassageiros());
	}		
	



}

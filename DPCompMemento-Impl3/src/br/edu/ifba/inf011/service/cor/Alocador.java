package br.edu.ifba.inf011.service.cor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.model.memento.impl2.VooCaretaker;
import br.edu.ifba.inf011.model.memento.impl2.VooCaretakerMap;
import br.edu.ifba.inf011.model.memento.impl2.VooCaretakerStack;
import br.edu.ifba.inf011.model.memento.impl2.VooOriginator;

//CLIENT em um CHAINOFRESPONSIBILITY
public class Alocador {
	
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;
	
	protected VooOriginator voo;
	private RegraAlocacao regras;
	private VooCaretakerMap caretaker;
	
	
	
	public Alocador(RegraAlocacao regras, VooOriginator voo) {
		this.voo = voo;
		this.regras = regras;
		this.caretaker = new VooCaretakerMap(this.voo);
	}
	
	
	public String alocar() {
		int posicao[] = this.regras.alocar(voo); 

		char chLinha = (char) ('1' + posicao[Alocador.LINHA]);
		char chColuna = (char) ('A' + posicao[Alocador.COLUNA]);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		return poltrona;
	}
	

	public void checkpoint() {
		this.caretaker.checkpoint();
	};
	
	public void undo(String key) {
		this.caretaker.undo(key);
	};
	
	public VooCaretakerMap getCaretaker() {
		return this.caretaker;
	}
	
	

}

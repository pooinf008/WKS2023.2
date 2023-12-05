package br.edu.ifba.inf011.service.cor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import br.edu.ifba.inf011.model.memento.impl1.VooOriginator;
import br.edu.ifba.inf011.model.memento.impl1.VooSnapshot;

//CLIENT em um CHAINOFRESPONSIBILITY
public class Alocador {
	
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;
	
	protected VooOriginator voo;
	private RegraAlocacao regras;
	
	protected Stack<VooSnapshot> snapshots;
	
	
	public Alocador(RegraAlocacao regras, VooOriginator voo) {
		this.voo = voo;
		this.regras = regras;
		this.snapshots = new Stack<VooSnapshot>();
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
		VooSnapshot snapshot = this.voo.save();
		this.snapshots.push(snapshot);
	}
	
	public void undo() {
		VooSnapshot snapshot = this.snapshots.pop();
		this.voo.restore(snapshot);
	}
	
	
	

}

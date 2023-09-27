package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.prototype.Prototipavel;

public class Roteiro implements Prototipavel{
	
	private String nome;
	private List<Diario> diarios;
	
	public Roteiro(Roteiro roteiro) {
		this.nome = roteiro.nome;
		this.diarios = new ArrayList<Diario>();
		for(Diario diario : roteiro.diarios)
			this.diarios.add((Diario) diario.prototipar());
	}
	
	public Roteiro(String nome, List<Diario> diarios) {
		this.nome = nome;
		this.diarios = diarios;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}	
	
	public String toString() {
		StringBuilder str = new StringBuilder(this.nome + "\n");
		for(int iCount = 0; iCount < this.diarios.size(); iCount++) {
			str.append("Dia " + iCount + "\n");
			str.append(this.diarios.get(iCount).toString());
		}	
		return str.toString();
	}
	
	public void visitPoI(PontoDeInteresse poi, Integer ordem, Integer dia) {
		int tamAtual = this.diarios.size() - 1;
		for(int iCount = tamAtual; iCount < dia; iCount++)
			this.diarios.add(new Diario());
		this.diarios.get(dia).addPoI(ordem, poi);
	}	

	public Prototipavel prototipar() {
		return new Roteiro(this);
	}
	
	

}

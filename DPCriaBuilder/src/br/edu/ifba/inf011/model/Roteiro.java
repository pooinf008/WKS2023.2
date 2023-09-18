package br.edu.ifba.inf011.model;

import java.util.List;

public class Roteiro {
	
	private String nome;
	private List<Diario> diarios;
	
	public Roteiro(String nome, List<Diario> diarios) {
		this.nome = nome;
		this.diarios = diarios;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder(this.nome + "\n");
		for(int iCount = 0; iCount < this.diarios.size(); iCount++) {
			str.append("Dia " + iCount + "\n");
			str.append(this.diarios.get(iCount).toString());
		}	
		return str.toString();
	}
	
	

}

package br.edu.ifba.inf011.principles;

import java.util.List;
import java.util.ArrayList;

public class Hotel {
	
	private List<Boolean> quartos;
	private String nome;
	
	public Hotel(String nome, Integer capacidade) {
		this.nome = nome;
		this.quartos = new ArrayList<Boolean>();
		for(int iCount = 0; 
			iCount < capacidade; iCount++)
			this.quartos.add(Boolean.valueOf(false));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	};
	
	public Integer reservar() {
		for(int iCount = 0;
				iCount < this.quartos.size();
				iCount++)
			if(!this.quartos.get(iCount).booleanValue()) {
				this.quartos.set(iCount, Boolean.valueOf(true));
				return iCount;
			}	
		return -1; 
	}
	
	public void liberar(Integer reservaNumber) {
		if(reservaNumber < 0 || reservaNumber > this.quartos.size())
			return;
		this.quartos.set(reservaNumber, Boolean.valueOf(false));
	}
	
	

}

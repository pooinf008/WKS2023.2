package br.edu.ifba.inf011.builder.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.builder.Builder;
import br.edu.ifba.inf011.model.Diario;
import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.Roteiro;
import br.edu.ifba.inf011.model.impl.Hotel;

public class RoteiroBuilder implements Builder{
	
	private List<Diario> diarios;
	private List<Hotel> hotels;
	private String nome;
	
	public void reset() {
		this.diarios = new ArrayList<Diario>();
		this.hotels = new ArrayList<Hotel>();
	};

	@Override
	public void withName(String nome) {
		this.nome = nome;
	};
	
	@Override
	public void withHospedagem(Hotel hotel, Integer inicio, Integer fim) {
		for(int iCount = inicio; iCount < fim; iCount++) {
			if(iCount > this.hotels.size() - 1)
				this.hotels.add(hotel);
			else
				this.hotels.set(iCount, hotel);
		}
	}

	@Override
	public void visitPoI(PontoDeInteresse poi, Integer ordem, Integer dia) {
		int tamAtual = this.diarios.size() - 1;
		for(int iCount = tamAtual; iCount < dia; iCount++)
			this.diarios.add(new Diario());
		this.diarios.get(dia).addPoI(ordem, poi);
	}
	
	
	public Roteiro get() {
		
		for(int iCount = 0; iCount < this.diarios.size(); iCount++)
			if(iCount < this.hotels.size())
				this.diarios.get(iCount).setHospedagem(this.hotels.get(iCount));
		
		for(int iCount = 0; iCount < this.hotels.size(); iCount++)
			if(iCount >= this.diarios.size()) {
				this.diarios.add(new Diario());
				this.diarios.get(this.diarios.size() - 1).setHospedagem(this.hotels.get(iCount));
			}
			
		
		return new Roteiro(this.nome, this.diarios);
	}
	
	

}

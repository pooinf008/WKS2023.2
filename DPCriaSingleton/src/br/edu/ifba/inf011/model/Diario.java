package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.prototype.Prototipavel;

public class Diario implements Prototipavel{
	
	private Hotel hotel;
	private List<PontoDeInteresse> pois;
	
	public Diario(Hotel hotel) {
		this.hotel = hotel;
		this.pois = new ArrayList<PontoDeInteresse>();
	}	
	
	public Diario() {
		this.hotel = null;
		this.pois = new ArrayList<PontoDeInteresse>();
	}		

	public Diario(Diario diario) {
		this.hotel = (Hotel) diario.hotel.prototipar();
		this.pois = new ArrayList<PontoDeInteresse>();
		for(PontoDeInteresse pois : diario.pois)
			this.pois.add((PontoDeInteresse) pois.prototipar());
	}

	public void addPoI(Integer ordem, PontoDeInteresse poi) {
		int tamAtual = this.pois.size() - 1;
		for(int iCount = tamAtual; iCount < ordem; iCount++)
			this.pois.add(PontoDeInteresse.LIVRE);
		this.pois.set(ordem, poi);
	};

	public void setHospedagem(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("");
		if(this.hotel != null)
			str.append("\tPernoite: " + this.hotel.getNome() + "\n");
		for(int iCount = 0; iCount < this.pois.size(); iCount++)
			if(this.pois.get(iCount)!=null && !this.pois.get(iCount).equals(PontoDeInteresse.LIVRE))
				str.append("\t\t" + iCount + ": " + this.pois.get(iCount) + "\n");
		return str.toString();
	}
	
	
	
	public static void main(String[] args) {
		Diario diario = new Diario();
		System.out.println(diario);
	}

	@Override
	public Prototipavel prototipar() {
		return new Diario(this);
	}


}

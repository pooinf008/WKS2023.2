package br.edu.ifba.inf011.model.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.ReservaException;

public abstract class VooBase implements Voo{
	
	private Voo pai;
	protected List<Voo> voos;
	
	public VooBase() {
		this.voos = new ArrayList<Voo>();
		this.pai = null;
	}
	
	public void addVoo(Voo voo) throws ReservaException {
		this.voos.add(voo);
		voo.setPai(this);
	}	

	public void removeVoo(Voo voo)  throws ReservaException {
		this.voos.remove(voo);
		voo.setPai(null);
	}	
	
	public void setPai(Voo voo) {
		this.pai = voo;
	}
	

}

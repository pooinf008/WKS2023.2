package br.edu.ifba.inf011.model.memento.impl2;

import br.edu.ifba.inf011.model.Voo;

public interface VooOriginator extends Voo{
	
	public VooSnapshot save();
	public void restore(VooSnapshot snapshot);

}

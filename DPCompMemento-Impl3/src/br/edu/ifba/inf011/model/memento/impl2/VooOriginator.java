package br.edu.ifba.inf011.model.memento.impl2;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.VooImpl;

public interface VooOriginator extends Voo{
	
	public VooImpl.VooSnapshot save();
	public void restore(VooImpl.VooSnapshot snapshot);

}

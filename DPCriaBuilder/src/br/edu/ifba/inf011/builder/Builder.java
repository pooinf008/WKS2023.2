package br.edu.ifba.inf011.builder;

import br.edu.ifba.inf011.model.PontoDeInteresse;
import br.edu.ifba.inf011.model.impl.Hotel;

public interface Builder {

	public void reset();
	public void withName(String string);
	public void withHospedagem(Hotel hotel, Integer inicio, Integer fim);
	public void visitPoI(PontoDeInteresse poi, Integer dia, Integer ordem);

}

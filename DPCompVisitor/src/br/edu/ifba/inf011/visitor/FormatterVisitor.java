package br.edu.ifba.inf011.visitor;

import br.edu.ifba.inf011.model.impl.Atracao;
import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.model.impl.Restaurante;

public interface FormatterVisitor {
	
	public String visitarHotel(Hotel hotel);
	public String visitarRestaurante(Restaurante restaurante);
	public String visitarAtracao(Atracao atracao);

}

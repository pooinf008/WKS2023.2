package br.edu.ifba.inf011.visitor;

import br.edu.ifba.inf011.model.impl.Atracao;
import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.model.impl.Restaurante;

public class JSONVisitor implements FormatterVisitor {

	@Override
	public String visitarHotel(Hotel hotel) {
		StringBuffer str = new StringBuffer("{\n");
		str.append("\t\"nome\" : \"" + hotel.getNome() + "\",\n");
		str.append("\t\"avaliacao\" : " + hotel.getEstrelas() + "\n");
		str.append("}");
		return str.toString();
	}

	@Override
	public String visitarRestaurante(Restaurante restaurante) {
		StringBuffer str = new StringBuffer("{\n");
		str.append("\t\"nome\" : \"" + restaurante.getNome() + "\",\n");
		str.append("\t\"tipoCozinha\" : \"" + restaurante.getTipoCozinha() + "\",\n");
		str.append("\t\"avaliacao\" : " + restaurante.getEstrelas() + "\n");
		str.append("}");
		return str.toString();
	}

	@Override
	public String visitarAtracao(Atracao atracao) {
		StringBuffer str = new StringBuffer("{\n");
		str.append("\t\"nome\" : \"" + atracao.getNome() + "\",\n");
		str.append("\t\"isGratuita\" : \"" + atracao.isGratuita() + "\",\n");
		str.append("\t\"avaliacao\" : " + atracao.getEstrelas() + "\n");
		str.append("}");
		return str.toString();
	}

}

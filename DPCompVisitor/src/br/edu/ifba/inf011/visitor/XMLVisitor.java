package br.edu.ifba.inf011.visitor;

import br.edu.ifba.inf011.model.impl.Atracao;
import br.edu.ifba.inf011.model.impl.Hotel;
import br.edu.ifba.inf011.model.impl.Restaurante;

public class XMLVisitor implements FormatterVisitor{

	@Override
	public String visitarHotel(Hotel hotel) {
		StringBuffer str = new StringBuffer("<HOTEL>\n");
		str.append("\t<NOME>" + hotel.getNome() + "</NOME>\n");
		str.append("\t<AVALIACAO>" + hotel.getEstrelas() + "</AVALIACAO>\n");
		str.append("</HOTEL>");
		return str.toString();
	}

	@Override
	public String visitarRestaurante(Restaurante restaurante) {
		StringBuffer str = new StringBuffer("<RESTAURANTE>\n");
		str.append("\t<NOME>" + restaurante.getNome() + "</NOME>\n");
		str.append("\t<CULINARIA>" + restaurante.getTipoCozinha() + "</CULINARIA>\n");
		str.append("\t<AVALIACAO>" + restaurante.getEstrelas() + "</AVALIACAO>\n");
		str.append("</RESTAURANTE>");
		return str.toString();
	}

	@Override
	public String visitarAtracao(Atracao atracao) {
		StringBuffer str = new StringBuffer("<ATRACAO>\n");
		str.append("\t<NOME>" + atracao.getNome() + "</NOME>\n");
		str.append("\t<GRATUITA>" + atracao.isGratuita() + "</GRATUITA>\n");
		str.append("\t<AVALIACAO>" + atracao.getEstrelas() + "</AVALIACAO>\n");
		str.append("</ATRACAO>");
		return str.toString();
	}

}

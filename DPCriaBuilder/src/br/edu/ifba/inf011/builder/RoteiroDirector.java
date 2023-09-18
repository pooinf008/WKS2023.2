package br.edu.ifba.inf011.builder;

import br.edu.ifba.inf011.factory.CreatorPOI;
import br.edu.ifba.inf011.factory.CreatorPOI_Hotel;
import br.edu.ifba.inf011.factory.TipoPOI;
import br.edu.ifba.inf011.model.impl.Hotel;

public class RoteiroDirector {
	
	private Builder builder;
	
	public RoteiroDirector() {
	}	
	
	public RoteiroDirector(Builder builder) {
		this.setBuilder(builder);
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	
	public void criarRoteiroSalvador3Dias() {
		
		CreatorPOI creatorPOI = new CreatorPOI_Hotel();
		Hotel hotel =  (Hotel) creatorPOI.createPOI(TipoPOI.HOTEL, "Hotel da Bahia", 13.0, 45.0);
		hotel.avaliar(5);
		
		this.builder.reset();
		this.builder.withName("Salvador 3 dias");
		this.builder.withHospedagem(hotel , 0, 3);
		this.builder.visitPoI(creatorPOI.createPOI(TipoPOI.ATRACAO, "Farol da Barra", 13.0, 44.0, 5), 1, 1);
		this.builder.visitPoI(creatorPOI.createPOI(TipoPOI.RESTAURANTE, "Boca de Siri", 13.0, 44.0, 5), 1, 0);
		this.builder.visitPoI(creatorPOI.createPOI(TipoPOI.ATRACAO, "Farol de Itapu�", 13.0, 44.0, 4), 2, 1);
		this.builder.visitPoI(creatorPOI.createPOI(TipoPOI.ATRACAO, "Farol de Humait�", 13.0, 44.0, 4), 0, 1);
		
	}

}

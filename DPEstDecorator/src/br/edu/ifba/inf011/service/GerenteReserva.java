package br.edu.ifba.inf011.service;

import br.edu.ifba.inf011.model.Voo;


//CLIENT em DECORATOR
public class GerenteReserva {
	
	public Reserva reservar(String nome, Voo voo) throws ReservaException{
		return new Reserva(nome, voo.getNumero(), voo.getIATAPartida(), voo.getIATAChegada(),
						   voo.getPreco());
		
	}

}

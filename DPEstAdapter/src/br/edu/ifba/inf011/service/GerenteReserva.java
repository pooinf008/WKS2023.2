package br.edu.ifba.inf011.service;

import br.edu.ifba.inf011.model.Voo;


//CLIENT em ADAPTER
public class GerenteReserva {
	
	public Reserva reservar(String nome, Voo voo, Integer linha, Integer coluna) throws ReservaException{
		if(!voo.disponivel(linha, coluna))
			throw new ReservaException();
		voo.reservar(linha, coluna);
		
		char chColuna = (char) ('A' + coluna);
		char chLinha = (char) ('1' + linha);
		String poltrona = Character.toString(chLinha)  +
						  Character.toString(chColuna);
		
		
		return new Reserva(nome, voo.getNumero(), voo.getIATAPartida(), voo.getIATAChegada(),
						   poltrona, voo.getPreco());
		
	}

}

package br.edu.ifba.inf011.abstractfactory;

import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;


//ABSTRACT FACTORY em um ABSTRACT FACTORY
public interface VoucherDataFactory {
	public Voo createVoo(String iATAPartida, String iATAChegada, Double preco);
	public Passageiro createPassageiro(String nome, String rg, String passaporte);
}

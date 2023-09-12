package br.edu.ifba.inf011.abstractfactory;

import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.PassageiroNacional;
import br.edu.ifba.inf011.model.impl.VooNacional;

//CONCRETE FACTORY em um ABSTRACT FACTORY
public class VoucherNacionalDataFactory implements VoucherDataFactory{

	@Override
	public Voo createVoo(String iATAPartida, String iATAChegada, Double preco) {
		return new VooNacional(iATAPartida, iATAChegada, preco);
	}

	@Override
	public Passageiro createPassageiro(String nome, String rg, String passaporte) {
		return new PassageiroNacional(nome, rg, passaporte);
	}

}

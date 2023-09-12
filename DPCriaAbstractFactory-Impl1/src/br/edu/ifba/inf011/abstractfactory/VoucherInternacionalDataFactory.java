package br.edu.ifba.inf011.abstractfactory;

import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.PassageiroInternacional;
import br.edu.ifba.inf011.model.impl.VooInternacional;

//CONCRETE FACTORY em um ABSTRACT FACTORY
public class VoucherInternacionalDataFactory implements VoucherDataFactory{

	@Override
	public Voo createVoo(String iATAPartida, String iATAChegada, Double preco) {
		return new VooInternacional(iATAPartida, iATAChegada, preco);
	}

	@Override
	public Passageiro createPassageiro(String nome, String rg, String passaporte) {
		return new PassageiroInternacional(nome, rg, passaporte);
	}

}

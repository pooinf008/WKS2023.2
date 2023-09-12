package br.edu.ifba.inf011.abstractfactory;

import java.util.Optional;

import br.edu.ifba.inf011.model.DataVoucher;
import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;


//ABSTRACT FACTORY em um ABSTRACT FACTORY
public interface VoucherDataFactory {
	public Optional<DataVoucher> create(TipoDataVoucher tipo);
}

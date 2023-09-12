package br.edu.ifba.inf011.abstractfactory;

import java.time.LocalDateTime;
import java.util.Optional;

import br.edu.ifba.inf011.model.DataVoucher;
import br.edu.ifba.inf011.model.Lounge;
import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.PassageiroInternacional;
import br.edu.ifba.inf011.model.impl.PassageiroNacional;
import br.edu.ifba.inf011.model.impl.VooInternacional;
import br.edu.ifba.inf011.model.impl.VooNacional;
import br.edu.ifba.inf011.model.impl.LoungeInternacional;

//CONCRETE FACTORY em um ABSTRACT FACTORY
public class VoucherInternacionalDataFactory implements VoucherDataFactory{

	
	@Override
	public Optional<DataVoucher> create(TipoDataVoucher tipo) {
		Optional<DataVoucher> optDataVoucher;
		switch(tipo) {
			case VOO : optDataVoucher = Optional.of(new VooNacional()) ; break; 
			case PASSAGEIRO :  optDataVoucher = Optional.of(new PassageiroNacional()); break;
			case LOUNGE : optDataVoucher = Optional.of(new LoungeInternacional()); break;
			default : optDataVoucher = Optional.empty();
		}
		return optDataVoucher;
	}


}

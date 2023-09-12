package br.edu.ifba.inf011;

import br.edu.ifba.inf011.abstractfactory.VoucherDataFactory;
import br.edu.ifba.inf011.abstractfactory.VoucherInternacionalDataFactory;
import br.edu.ifba.inf011.abstractfactory.VoucherNacionalDataFactory;
import br.edu.ifba.inf011.servico.EmissorVoucher;

public class AppEmissorVoucher {
	
	public void rodar(VoucherDataFactory dataFactory) {
		EmissorVoucher emissor = new EmissorVoucher();
		String voucher = emissor.gerarVoucher(dataFactory, "SSA", "GRU", 1000.0, "ZÉ DAS COUVES", "00001111", "PAS001", "GATE A");
		System.out.println(voucher);
	}	

	
	public void rodar(boolean nacional) {
		if(nacional)
			this.rodar(new VoucherNacionalDataFactory());
		else
			this.rodar(new VoucherInternacionalDataFactory());
	}
		
	
	
	
	

}

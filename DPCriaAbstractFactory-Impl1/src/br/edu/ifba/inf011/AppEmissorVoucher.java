package br.edu.ifba.inf011;


import br.edu.ifba.inf011.abstractfactory.VoucherDataFactory;
import br.edu.ifba.inf011.abstractfactory.VoucherInternacionalDataFactory;
import br.edu.ifba.inf011.abstractfactory.VoucherNacionalDataFactory;
import br.edu.ifba.inf011.servico.EmissorVoucher;

//CLIENT em um ABSTRACT FACTORY
public class AppEmissorVoucher {
	
	private void rodar(VoucherDataFactory dataFactory) {
		EmissorVoucher emissor = new EmissorVoucher();
		String voucher = emissor.gerarVoucher(dataFactory, "SSA", "GRU", 1000.0, "ZÉ DAS COUVES", "00001111", "PAS001");
		System.out.println(voucher);
	}	
	
	public void rodar(boolean nacional) {
		if(nacional)
			this.rodar(new VoucherNacionalDataFactory());
		else
			this.rodar(new VoucherInternacionalDataFactory());
	}
	
	

}

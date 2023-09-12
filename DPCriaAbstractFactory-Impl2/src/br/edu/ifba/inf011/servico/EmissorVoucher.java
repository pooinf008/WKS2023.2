package br.edu.ifba.inf011.servico;

import java.util.Optional;

import br.edu.ifba.inf011.abstractfactory.TipoDataVoucher;
import br.edu.ifba.inf011.abstractfactory.VoucherDataFactory;
import br.edu.ifba.inf011.model.DataVoucher;
import br.edu.ifba.inf011.model.Lounge;
import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;

//CLIENT em um ABSTRACT FACTORY
public class EmissorVoucher {

	
	public String gerarVoucher(VoucherDataFactory af,
			   String iATAPartida, String iATAChegada, Double preco,
			   String nome, String rg, String passaporte, String loungeGate) {

		Passageiro passageiro = null;
		Voo voo = null;
		Lounge lounge = null;
		
		
		Optional<DataVoucher> optPassageiro = af.create(TipoDataVoucher.PASSAGEIRO);
		Optional<DataVoucher> optVoo = af.create(TipoDataVoucher.VOO);
		Optional<DataVoucher> optLounge = af.create(TipoDataVoucher.LOUNGE);

		
		if(optPassageiro.isPresent()) {
			passageiro = (Passageiro) optPassageiro.get();
			passageiro.init(nome, rg, passaporte);
		}
		
		if(optVoo.isPresent()) {
			voo = (Voo) optVoo.get();
			voo.init(iATAPartida, iATAChegada, preco);
		}	
		
		if(optLounge.isPresent()) {
			lounge = (Lounge) optLounge.get();
			lounge.init(loungeGate);
		}		
		
		return this.gerarVoucher(passageiro, voo, lounge);
	}
	
	
	private String gerarVoucher(Passageiro passageiro, Voo voo, Lounge lounge) {
		
		StringBuilder str = new StringBuilder("<<<< VOUCHER >>>>\n\n");
		if(passageiro != null) {
			str.append("Passageiro : " + passageiro.getNome() + "\n");
			str.append("Documento de Identificacao : " + passageiro.getDocumentoEmbarque() + "\n");
		}
		if(voo != null) {
			str.append(voo.getIATAPartida() + " ----> "  + voo.getIATAChegada() + "\n");
			str.append("Preco Moeda de Emissao: " + voo.getPrecoOriginal() + "\n");
			str.append("Preco em Real: " + voo.getPrecoConvertido() + "\n");
		}
		if(lounge!=null) {
			str.append("Lounge Gate: " + lounge.getGate() + "\n");
		}
		str.append("\n<<<< ------- >>>>");
		
		return str.toString();		
		
	}
	
	
	
}

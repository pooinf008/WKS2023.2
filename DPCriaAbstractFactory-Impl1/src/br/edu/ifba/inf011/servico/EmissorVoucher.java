package br.edu.ifba.inf011.servico;


import br.edu.ifba.inf011.abstractfactory.VoucherDataFactory;
import br.edu.ifba.inf011.model.Passageiro;
import br.edu.ifba.inf011.model.Voo;

//CLIENT em um ABSTRACT FACTORY
public class EmissorVoucher {

	public String gerarVoucher(VoucherDataFactory af,
							   String iATAPartida, String iATAChegada, Double preco,
							   String nome, String rg, String passaporte) {
		Passageiro passageiro = af.createPassageiro(nome, rg, passaporte);
		Voo voo = af.createVoo(iATAPartida, iATAChegada, preco);
		
		StringBuilder str = new StringBuilder("<<<< VOUCHER >>>>\n\n");
		str.append("Passageiro : " + passageiro.getNome() + "\n");
		str.append("Documento de Identificacao : " + passageiro.getDocumentoEmbarque() + "\n");
		str.append(voo.getIATAPartida() + " ----> "  + voo.getIATAChegada() + "\n");
		str.append("Preco Moeda de Emissao: " + voo.getPrecoOriginal() + "\n");
		str.append("Preco em Real: " + voo.getPrecoConvertido() + "\n\n");
		str.append("<<<< ------- >>>>");
		
		return str.toString();
	}
	
}

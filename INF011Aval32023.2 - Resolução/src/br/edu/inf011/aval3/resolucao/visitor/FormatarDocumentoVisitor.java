package br.edu.inf011.aval3.resolucao.visitor;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public class FormatarDocumentoVisitor implements DocumentoVisitor{

	@Override
	public Optional<Object> visitarCartaoCredito(CartaoCredito cc) {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CARTÃO DE CRÉDITO\n");
		fmt.append(cc.getNome() + "\n");
		fmt.append(cc.getNumero().substring(0, 4) + " ");
		fmt.append(cc.getNumero().substring(4, 8) + " ");
		fmt.append(cc.getNumero().substring(8, 12) + " ");
		fmt.append(cc.getNumero().substring(12, 16) + "\n");
		fmt.append(cc.getCvc() + "\n");
		fmt.append(cc.getVencimento().format(DateTimeFormatter.ofPattern("MM/yy")));
		return Optional.of(fmt.toString());
	}

	@Override
	public Optional<Object>  visitarCPF(CPF cpf) {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CPF\n");
		fmt.append(cpf.getNome() + " - ");
		fmt.append(cpf.getNumero().substring(0, 3) + "." + 
				   cpf.getNumero().substring(3, 6) + "." +
				   cpf.getNumero().substring(6, 9) + "-" + 
				   cpf.getNumero().substring(9, 11));
		return Optional.of(fmt.toString());
	}

	@Override
	public Optional<Object>  visitarEmail(EMail email) {
		return Optional.of("E-MAIL\n" + email.getConta());
	}

	@Override
	public Optional<Object>  visitarRG(RG rg) {
		StringBuilder fmt = new StringBuilder();
		fmt.append("RG\n");
		fmt.append(rg.getNome() + "\n");
		fmt.append(rg.getNumero().substring(0, rg.getNumero().length() - 2) + "-");
		fmt.append(rg.getNumero().substring(rg.getNumero().length() - 2, rg.getNumero().length()) + " - ");
		fmt.append(rg.getExpedidor() + "\n");
		fmt.append("Validade: " + rg.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		return Optional.of(fmt.toString());
	}

}

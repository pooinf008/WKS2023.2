package br.edu.inf011.aval3.resolucao.visitor;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public interface DocumentoVisitor {
	
	public Optional<Object> visitarCartaoCredito(CartaoCredito cc);
	public Optional<Object> visitarCPF(CPF cpf);
	public Optional<Object> visitarEmail(EMail email);
	public Optional<Object> visitarRG(RG rg);

}

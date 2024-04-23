package br.edu.inf011.aval3.resolucao.visitor;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public class PontuarVisitor implements DocumentoVisitor {

	private Integer total;
	
	
	public PontuarVisitor() {
		this.reset(); 
	}
	
	public void reset() {
		this.total = 0;
	}
	
	@Override
	public Optional<Object>  visitarCartaoCredito(CartaoCredito cc) {
		this.total += 2;
		return Optional.of(2);
	}

	@Override
	public Optional<Object>  visitarCPF(CPF cpf) {
		this.total += 3;
		return Optional.of(3);
	}

	@Override
	public Optional<Object>  visitarEmail(EMail email) {
		this.total += 1;
		return Optional.of(1);
	}

	@Override
	public Optional<Object>  visitarRG(RG rg) {
		this.total += 1;
		return Optional.of(1);
	}
	
	public Integer getTotal() {
		return this.total;
	}

}

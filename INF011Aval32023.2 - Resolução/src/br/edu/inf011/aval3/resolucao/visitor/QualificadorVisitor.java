package br.edu.inf011.aval3.resolucao.visitor;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public class QualificadorVisitor implements DocumentoVisitor{
	
	private Integer totalCC;
	private Integer totalCPF;
	private Integer totaleMail;
	private Integer totalRG;
	
	
	
	public QualificadorVisitor() {
		this.reset(); 
	}
	
	public void reset() {
		this.totalCC = 0;
		this.totalCPF = 0;
		this.totaleMail = 0;
		this.totalRG = 0;
	}
	

	@Override
	public Optional<Object> visitarCartaoCredito(CartaoCredito cc) {
		this.totalCC++;
		return Optional.of(this.totalCC);
	}

	@Override
	public Optional<Object> visitarCPF(CPF cpf) {
		this.totalCPF++;
		return Optional.of(this.totalCPF);
	}

	@Override
	public Optional<Object> visitarEmail(EMail email) {
		this.totaleMail++;
		return Optional.of(this.totaleMail);
	}

	@Override
	public Optional<Object> visitarRG(RG rg) {
		this.totalRG++;
		return Optional.of(this.totalRG);
	}

	public Integer getTotalCC() {
		return this.totalCC;
	}

	public Integer getTotalCPF() {
		return this.totalCPF;
	}

	public Integer getTotaleMail() {
		return this.totaleMail;
	}

	public Integer getTotalRG() {
		return this.totalRG;
	}
	
	
	

}

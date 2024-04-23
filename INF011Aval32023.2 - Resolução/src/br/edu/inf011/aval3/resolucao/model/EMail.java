package br.edu.inf011.aval3.resolucao.model;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.visitor.DocumentoVisitor;

public class EMail implements Documento{
	
	public String conta;
	
	public EMail(String conta) {
		super();
		this.conta = conta;
	}

	public String getConta() {
		return conta;
	}
	
	
	public Optional<Object> aceitar(DocumentoVisitor visitor) {
		return visitor.visitarEmail(this);
	}	
	

}

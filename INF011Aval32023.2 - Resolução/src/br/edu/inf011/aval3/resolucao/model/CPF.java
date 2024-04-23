package br.edu.inf011.aval3.resolucao.model;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.visitor.DocumentoVisitor;

public class CPF implements Documento{
	
	public String nome;
	public String numero;
	
	
	public CPF(String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}


	public String getNumero() {
		return numero;
	}
	
	public Optional<Object> aceitar(DocumentoVisitor visitor) {
		return visitor.visitarCPF(this);
	}	
	

}

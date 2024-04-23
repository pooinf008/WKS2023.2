package br.edu.inf011.aval3.resolucao.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import br.edu.inf011.aval3.resolucao.visitor.DocumentoVisitor;

public class CartaoCredito implements Documento{
	public String nome;
	public String numero;	
	public String cvc;
	public LocalDate vencimento;
	
	public CartaoCredito(String nome, String numero, String cvc, LocalDate vencimento) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.cvc = cvc;
		this.vencimento = vencimento;
	}
	
	public CartaoCredito(String nome, String numero, String cvc, String vencimento) {
		this(nome, numero, cvc, LocalDate.parse(vencimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}	



	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getCvc() {
		return cvc;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public Optional<Object> aceitar(DocumentoVisitor visitor) {
		return visitor.visitarCartaoCredito(this);
	}


	
	
	
}


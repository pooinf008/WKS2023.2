package br.edu.inf011.aval3.enunciado.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RG implements Documento{
	
	public String nome;
	public String numero;
	public String expedidor;
	public LocalDate validade;
	
	public RG(String nome, String numero, String expedidor, LocalDate validade) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.expedidor = expedidor;
		this.validade = validade;
	}
	
	
	public RG(String nome, String numero, String expedidor, String validade) {
		this(nome, numero, expedidor, LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}


	@Override
	public String formatar() {
		StringBuilder fmt = new StringBuilder();
		fmt.append("RG\n");
		fmt.append(this.nome + "\n");
		fmt.append(this.numero.substring(0, this.numero.length() - 2) + "-");
		fmt.append(this.numero.substring(this.numero.length() - 2, this.numero.length()) + " - ");
		fmt.append(this.expedidor + "\n");
		fmt.append("Validade: " + this.validade.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		return fmt.toString();
	}


	@Override
	public boolean validar() {
		return this.validade.isAfter(LocalDate.now());
	}


	@Override
	public Integer pontuar() {
		return this.validar() ? 1 : 0;
	}


	public String getNome() {
		return nome;
	}


	public String getNumero() {
		return numero;
	}


	public String getExpedidor() {
		return expedidor;
	}


	public LocalDate getValidade() {
		return validade;
	}
	
	
	
	

}

package br.edu.inf011.aval3.enunciado.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public String formatar() {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CARTÃO DE CRÉDITO\n");
		fmt.append(this.nome + "\n");
		fmt.append(this.numero.substring(0, 4) + " ");
		fmt.append(this.numero.substring(4, 8) + " ");
		fmt.append(this.numero.substring(8, 12) + " ");
		fmt.append(this.numero.substring(12, 16) + "\n");
		fmt.append(this.cvc + "\n");
		fmt.append(this.vencimento.format(DateTimeFormatter.ofPattern("MM/yy")));
		return fmt.toString();
		
	}

	@Override
	public boolean validar() {
		this.numero.replace(" ", "");
		return this.verificaLuhn() && this.vencimento.isAfter(LocalDate.now());
	}

	@Override
	public Integer pontuar() {
		return this.validar() ? 2 : 0;
	}
	
	
	
	private boolean verificaLuhn() {
		int sum = 0;
		boolean shouldDouble = false;
		for (int iCont = this.numero.length() - 1; iCont >= 0; iCont--) {
			int digit = this.numero.charAt(iCont) - '0';
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }
		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		  return (sum % 10) == 0;		
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
	
	
	
	
	
	
	
}


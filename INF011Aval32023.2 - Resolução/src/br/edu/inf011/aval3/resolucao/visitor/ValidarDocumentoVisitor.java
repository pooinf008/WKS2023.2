package br.edu.inf011.aval3.resolucao.visitor;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public class ValidarDocumentoVisitor implements DocumentoVisitor {
	
	public static final String REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";	

	@Override
	public Optional<Object> visitarCartaoCredito(CartaoCredito cc) {
		String numero = new String(cc.getNumero());
		numero.replace(" ", "");
		return Optional.of(this.verificaLuhn(numero) && cc.getVencimento().isAfter(LocalDate.now()));
	}

	@Override
	public Optional<Object> visitarCPF(CPF cpf) {
		String numero = new String(cpf.getNumero());
	    numero.replace(".", "");
	    numero.replace("-", "");
		return Optional.of(this.cpfValido(numero));		
	}

	@Override
	public Optional<Object> visitarEmail(EMail email) {
	    return Optional.of(Pattern.compile(ValidarDocumentoVisitor.REGEX)
	    	      .matcher(email.getConta())
	    	      .matches());
	}

	@Override
	public Optional<Object> visitarRG(RG rg) {
		return Optional.of(rg.getValidade().isAfter(LocalDate.now()));
	}
	
	
	private boolean verificaLuhn(String numero) {
		int sum = 0;
		boolean shouldDouble = false;
		for (int iCont = numero.length() - 1; iCont >= 0; iCont--) {
			int digit = numero.charAt(iCont) - '0';
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }
		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		  return (sum % 10) == 0;		
	}	
	
	
	private boolean cpfValido(String numero) {
	    int d1, d2;
	    int digito1, digito2, resto;
	    String nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;

	    for (int iCount = numero.length() - 1, mult = 2; iCount >= 0; iCount--, mult++) {
	      int digitoCPF = numero.charAt(iCount) - '0';
	      d1 += (mult * digitoCPF);
	      d2 += ((mult - 1) * digitoCPF);
	    };

	    resto = (d1 % 11);

	    if (resto < 2)
	      digito1 = 0;
	    else
	      digito1 = 11 - resto;

	    d2 += 2 * digito1;
	    resto = (d2 % 11);

	    if (resto < 2)
	      digito2 = 0;
	    else
	      digito2 = 11 - resto;

	    String nDigVerific = numero.substring(numero.length() - 2, numero.length());
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	    return nDigVerific.equals(nDigResult);
	  
	}	

}

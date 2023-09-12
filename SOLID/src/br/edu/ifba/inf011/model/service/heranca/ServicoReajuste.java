package br.edu.ifba.inf011.model.service.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Cargo;
import br.edu.ifba.inf011.model.Funcionario;

public class ServicoReajuste {
	
	public void reajuste(Funcionario funcionario, 
						 LocalDate dtReajuste,
						 BigDecimal pctAumento) throws RHException {
		this.validarReajuste(funcionario, dtReajuste, pctAumento);
		funcionario.reajustar(dtReajuste, pctAumento);
	}

	protected void validarReajuste(Funcionario funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		if(pctAumento.doubleValue() > 0.4 ||
  	      (pctAumento.doubleValue() > 0.2 && funcionario.getCargo() == Cargo.TRAINEE))
			throw new RHException("O valor do aumento viola as regras da empresa");
	}

}

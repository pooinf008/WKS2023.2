package br.edu.ifba.inf011.model.service.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Cargo;
import br.edu.ifba.inf011.model.Funcionario;

public class ServicoReajusteMatriz extends ServicoReajuste {
	
	protected void validarReajuste(Funcionario funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		Period period = Period.between(funcionario.getDataUltimoReajuste(), dtReajuste);
		if(pctAumento.doubleValue() > 0.4 || period.getMonths() < 2)
			throw new RHException("O valor do aumento viola as regras da empresa");
	}	

}

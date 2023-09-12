package br.edu.ifba.inf011.model.service.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.service.Reajustavel;

public class RegraMax40 implements Regra {

	@Override
	public void validar(Reajustavel funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		if(pctAumento.doubleValue() > 0.4) 
			throw new RHException("Reajuste Máximo Permitido é de 40%.");
	}


}

package br.edu.ifba.inf011.model.service.regras;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.service.Reajustavel;

public class RegraMin2Months implements Regra{

	@Override
	public void validar(Reajustavel funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		Period period = Period.between(funcionario.getDataUltimoReajuste(), dtReajuste);
		if(period.getMonths() < 2)
			throw new RHException("O Periodo Mínimo entre Reajustes é de 2 Meses");
	}

	

}

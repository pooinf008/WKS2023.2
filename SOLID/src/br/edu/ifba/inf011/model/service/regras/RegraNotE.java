package br.edu.ifba.inf011.model.service.regras;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.service.Reajustavel;

public class RegraNotE implements Regra{

	@Override
	public void validar(Reajustavel funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		if (funcionario.getNome().charAt(0) == 'E')
			throw new RHException("Pessoas que iniciam com E não tem direito a aumento");
	}


}

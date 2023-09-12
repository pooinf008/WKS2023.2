package br.edu.ifba.inf011.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Cargo;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.service.regras.Regra;
import br.edu.ifba.inf011.model.service.regras.RegraMin2Months;
import br.edu.ifba.inf011.model.service.regras.RegraMax40;

public class ServicoReajuste2 {
	
	private RegraMax40 regra1 = new RegraMax40();
	private RegraMin2Months regra2 = new RegraMin2Months();

	
	public ServicoReajuste2() {
	}
	
	
	public void reajuste(Reajustavel funcionario, 
						 LocalDate dtReajuste,
						 BigDecimal pctAumento) throws RHException {
		this.regra1.validar(funcionario, dtReajuste, pctAumento);
		this.regra2.validar(funcionario, dtReajuste, pctAumento);
		funcionario.reajustar(dtReajuste, pctAumento);
	}

	protected void validarReajuste(Funcionario funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		if(pctAumento.doubleValue() > 0.4 ||
  	      (pctAumento.doubleValue() > 0.2 && funcionario.getCargo() == Cargo.TRAINEE))
			throw new RHException("O valor do aumento viola as regras da empresa");
	}

}

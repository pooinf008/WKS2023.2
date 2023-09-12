package br.edu.ifba.inf011.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Cargo;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.service.regras.Regra;

public class ServicoReajuste {
	
	private List<Regra> regras;
	
	public ServicoReajuste(List<Regra> regras) {
		this.regras = regras;
	}
	
	
	public void reajuste(Reajustavel reajustavel, 
						 LocalDate dtReajuste,
						 BigDecimal pctAumento) throws RHException {
		for(Regra regra : this.regras)
			regra.validar(reajustavel, dtReajuste, pctAumento);
		reajustavel.reajustar(dtReajuste, pctAumento);
	}

	protected void validarReajuste(Funcionario funcionario, LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		if(pctAumento.doubleValue() > 0.4 ||
  	      (pctAumento.doubleValue() > 0.2 && funcionario.getCargo() == Cargo.TRAINEE))
			throw new RHException("O valor do aumento viola as regras da empresa");
	}

}

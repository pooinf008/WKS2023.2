package br.edu.ifba.inf011.model.service;

import java.time.LocalDate;
import java.time.Period;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.Terceirizado;

public class ServicoPromocao {
	
	public void promover(Promovivel promovivel, LocalDate dtMovimentacao) throws RHException{
		Period period = Period.between(promovivel.getDataUltimaMovimentacao(), dtMovimentacao);
		if(period.getMonths() < 2)
			throw new RHException("O Periodo Mínimo entre Promocoes é de 2 Meses");
		promovivel.movimentar();
		
	}
	
	public void promover(Terceirizado terceirizado, LocalDate dtMovimentacao) throws RHException{
		Period period = Period.between(terceirizado.getDataUltimaMovimentacao(), dtMovimentacao);
		if(period.getMonths() < 2)
			throw new RHException("O Periodo Mínimo entre Promocoes é de 2 Meses");
		terceirizado.movimentar();
		
	}	

}

package br.edu.ifba.inf011.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifba.inf011.exception.RHException;

public interface Reajustavel {
	public BigDecimal getSalario();
	public String getNome();
	public void reajustar(LocalDate dtReajuste, BigDecimal pctAumento) throws RHException;
	public LocalDate getDataUltimoReajuste();
}

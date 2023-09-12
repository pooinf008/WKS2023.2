package br.edu.ifba.inf011.model.service;

import java.time.LocalDate;

public interface Promovivel {
	public LocalDate getDataUltimaMovimentacao();
	public void movimentar();
}

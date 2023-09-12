package br.edu.ifba.inf011.model;

import java.time.LocalDateTime;

public interface Lounge extends DataVoucher{
	
	public LocalDateTime getInicio();
	public LocalDateTime getFim();
	public String getGate();
	public void init(String gate);
	

}

package br.edu.ifba.inf011.model.impl;

import java.time.LocalDateTime;

import br.edu.ifba.inf011.model.Lounge;

public class LoungeInternacional implements Lounge{

	private String gate;
	
	public LoungeInternacional() {
		
	}
	
	public LoungeInternacional(String gate) {
		this.init(gate);
	}
	
	
	public void init(String gate) {
		this.gate = gate;
	}
	
	@Override
	public LocalDateTime getInicio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getFim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGate() {
		return this.gate;
	}

}

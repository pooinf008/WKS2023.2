package br.edu.inf011.decorator;

import br.edu.inf011.model.Request;

public class LZ78Decorator extends RequestDecorator implements Request {

	public LZ78Decorator(Request component) {
		super(component);
	}
	
	@Override
	public String getMessage() {
		return "[COMPACTADA COM LZ78 <<" + super.getMessage() + ">>]";
	}	

}

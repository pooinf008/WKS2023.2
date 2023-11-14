package br.edu.inf011.decorator;

import br.edu.inf011.model.Request;

public class AESDecorator extends RequestDecorator implements Request {

	public AESDecorator(Request component) {
		super(component);
	}
	
	@Override
	public String getMessage() {
		return "[CRIPTOGRAFADA COM RSA <<" + super.getMessage() + ">>]";
	}	

}

package br.edu.inf011.decorator;

import br.edu.inf011.model.Request;

public class RSADecorator extends RequestDecorator implements Request {

	public RSADecorator(Request component) {
		super(component);
	}
	
	@Override
	public String getMessage() {
		return "[CRIPTOGRAFADA COM AES <<" + super.getMessage() + ">>]";
	}	

}

package br.edu.inf011.adapter;

import java.nio.charset.StandardCharsets;

import br.edu.inf011.decorator.RequestDecorator;
import br.edu.inf011.model.Request;

public class AES256Adapter extends RequestDecorator implements Request{
	
	private AES256 adaptee;
	
	public AES256Adapter(AES256 adaptee, Request component) {
		super(component);
		this.adaptee = adaptee;
	}
	
	@Override
	public String getMessage() {
		this.adaptee.init();
		return new String(this.adaptee.doFinal(super.getMessage().getBytes()), StandardCharsets.UTF_8);
	}

	
}

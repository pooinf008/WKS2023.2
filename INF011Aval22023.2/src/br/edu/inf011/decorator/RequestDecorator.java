package br.edu.inf011.decorator;

import br.edu.inf011.model.Request;

public class RequestDecorator implements Request{
	
	protected Request component;
	
	public RequestDecorator(Request component) {
		this.component = component;
	}

	@Override
	public void addHeader(String key, String value) {
		this.component.addHeader(key, value);
	}

	@Override
	public String readHeader(String key) {
		return this.component.readHeader(key);
	}

	@Override
	public byte[] getContent() {
		return this.component.getContent();
	}

	@Override
	public void setContent(byte[] content) {
		this.component.setContent(content);
	}

	@Override
	public String getMessage() {
		return this.component.getMessage();
	}
	
	@Override
	public void setMessage(String message) {
		this.component.setMessage(message);
	}	
	
	@Override
	public String toString() {
		return this.component.toString();
	}		

}

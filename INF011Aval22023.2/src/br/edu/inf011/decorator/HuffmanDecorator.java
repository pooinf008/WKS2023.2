package br.edu.inf011.decorator;

import br.edu.inf011.model.Request;

public class HuffmanDecorator extends RequestDecorator implements Request {

	public HuffmanDecorator(Request component) {
		super(component);
	}
	
	@Override
	public String getMessage() {
		return "[COMPACTADA COM HUFFMAN <<" + super.getMessage() + ">>]";
	}	

}

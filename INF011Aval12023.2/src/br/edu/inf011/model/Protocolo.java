package br.edu.inf011.model;

import br.edu.inf011.exception.ProtocoloException;

public interface Protocolo {

	public void init(String host, Integer port)  throws ProtocoloException;
	public void open() throws ProtocoloException;
	public void message(Request request, Response response) throws ProtocoloException;
	public void close() throws ProtocoloException;
	

}

package br.edu.inf011.abstractFactory;

import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.Request;
import br.edu.inf011.model.Response;

public interface ProtocoloAbstractFactory {
	
	public Request getRequest(String content) throws ProtocoloException;
	public Request getRequest() throws ProtocoloException;
	public Response getResponse() throws ProtocoloException;
	public Protocolo getProtocolo(String host, Integer port) throws ProtocoloException;

}

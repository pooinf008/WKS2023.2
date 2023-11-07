package br.edu.inf011.model.http;

import br.edu.inf011.abstractFactory.ProtocoloAbstractFactory;
import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.factoryMethod.ProtocoloFactory;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.Request;
import br.edu.inf011.model.Response;
import br.edu.inf011.model.TipoProtocolo;

public class HTTPFactory implements ProtocoloAbstractFactory{

	@Override
	public Request getRequest() throws ProtocoloException{
		return new HTTPRequest();
	}

	@Override
	public Response getResponse() throws ProtocoloException{
		return new HTTPResponse();
	}

	@Override
	public Protocolo getProtocolo(String host, Integer port) throws ProtocoloException {
		return (new ProtocoloFactory()).create(TipoProtocolo.HTTP, host, port);
	}

}

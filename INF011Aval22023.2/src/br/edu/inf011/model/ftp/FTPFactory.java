package br.edu.inf011.model.ftp;

import br.edu.inf011.abstractFactory.ProtocoloAbstractFactory;
import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.factoryMethod.ProtocoloFactory;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.Request;
import br.edu.inf011.model.Response;
import br.edu.inf011.model.TipoProtocolo;

public class FTPFactory implements ProtocoloAbstractFactory{

	@Override
	public Request getRequest() throws ProtocoloException{
		return new FTPRequest();
	}
	
	@Override
	public Request getRequest(String message) throws ProtocoloException{
		Request request = new FTPRequest();
		request.setMessage(message);
		return request;
	}
	

	@Override
	public Response getResponse() throws ProtocoloException{
		return new FTPResponse();
	}

	@Override
	public Protocolo getProtocolo(String host, Integer port) throws ProtocoloException {
		return (new ProtocoloFactory()).create(TipoProtocolo.FTP, host, port);
	}
	

}

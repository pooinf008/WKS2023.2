package br.edu.inf011.model.http;

import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.Request;
import br.edu.inf011.model.Response;

public class HTTPProtocolo implements Protocolo {

	private String host;
	private Integer port;
	
	public HTTPProtocolo() throws ProtocoloException{
		this.init("http", Integer.valueOf(80));
	}	
	
	public HTTPProtocolo(String host, Integer port) throws ProtocoloException{
		this.init(host, port);
	}	
	
	@Override
	public void init(String host, Integer port) throws ProtocoloException {
		this.host = host;
		this.port = port;
	}

	@Override
	public void open() throws ProtocoloException {
		System.out.println("Abrindo : http://" + this.host + ":" + this.port + "/");
	}

	@Override
	public void message(Request request, Response response) throws ProtocoloException {
		System.out.println("Mensagem em processamento recebida via " + request);
		System.out.println("Resposta gerada em " + response);
	}	

	@Override
	public void close() throws ProtocoloException {
		System.out.println("Fechando : http://" + this.host + ":" + this.port + "/");
	}
	
	public String toString() {
		return "HTTP PROTOCOLO buscando " + this.host + ":" + this.port;
	}

}

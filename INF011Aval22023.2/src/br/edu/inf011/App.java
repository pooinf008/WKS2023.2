package br.edu.inf011;


import br.edu.inf011.abstractFactory.ProtocoloAbstractFactory;
import br.edu.inf011.adapter.AES256;
import br.edu.inf011.adapter.AES256Adapter;
import br.edu.inf011.decorator.AESDecorator;
import br.edu.inf011.decorator.HuffmanDecorator;
import br.edu.inf011.decorator.LZ78Decorator;
import br.edu.inf011.decorator.RSADecorator;
import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.Request;
import br.edu.inf011.model.Response;
import br.edu.inf011.model.http.HTTPFactory;

public class App {
    
	public static void main(String[] args) throws ProtocoloException {
		App app = new App();
		app.runQ1();
		app.runQ2();
	}

	private void runQ1() throws ProtocoloException {
		ProtocoloAbstractFactory af = new HTTPFactory();
		
		Protocolo protocolo = af.getProtocolo("http.inf011.ifba.edu.br", Integer.valueOf(80));
		Response response = af.getResponse();
		
		System.out.println("****************************************************************");
		protocolo.open();
		Request request1 = af.getRequest("MENSAGEM ORIGINAL");
		protocolo.message(request1, response);
		Request request2 = new AESDecorator(af.getRequest("MENSAGEM ORIGINAL"));
		protocolo.message(request2, response);
		Request request3 = new HuffmanDecorator(af.getRequest("MENSAGEM ORIGINAL"));
		protocolo.message(request3, response);
		Request request4 = new RSADecorator(new LZ78Decorator(af.getRequest("MENSAGEM ORIGINAL")));
		protocolo.message(request4, response);
		Request request5 = new AES256Adapter(new AES256(), af.getRequest("MENSAGEM ORIGINAL"));
		protocolo.message(request5, response);
		protocolo.close();
		System.out.println("****************************************************************");
		
		
	}
	
	private void runQ2() throws ProtocoloException {
		
		ProtocoloAbstractFactory af = new HTTPFactory();
		Protocolo protocolo = af.getProtocolo("http.inf011.ifba.edu.br", Integer.valueOf(80));
		Response response = af.getResponse();
		System.out.println("****************************************************************");
		protocolo.open();
		Request request = new AES256Adapter(new AES256(), af.getRequest("MENSAGEM ORIGINAL"));
		protocolo.message(request, response);
		protocolo.close();
		System.out.println("****************************************************************");
	}	
}

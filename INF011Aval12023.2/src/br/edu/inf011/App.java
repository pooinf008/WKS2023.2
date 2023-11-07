package br.edu.inf011;

import br.edu.inf011.abstractFactory.ProtocoloAbstractFactory;
import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.factoryMethod.ProtocoloFactory;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.TipoProtocolo;
import br.edu.inf011.model.ftp.FTPFactory;
import br.edu.inf011.model.ftp.FTPRequest;
import br.edu.inf011.model.http.HTTPFactory;
import br.edu.inf011.model.http.HTTPResponse;

public class App {
    
	public static void main(String[] args) throws ProtocoloException {
		App app = new App();
		app.runQ1();
		app.runQ2();
	}

	private void runQ1() throws ProtocoloException {
		Protocolo protocolo = (new ProtocoloFactory()).create(TipoProtocolo.FTP, 
															  "ftp.inf011.ifba.edu.br", 
															  Integer.valueOf(21));

		System.out.println("****************************************************************");
		protocolo.open();
		protocolo.message(new FTPRequest(), new HTTPResponse());
		protocolo.close();
		System.out.println("****************************************************************");
		
	}
	
	private void runQ2() throws ProtocoloException {
		
		ProtocoloAbstractFactory af = new HTTPFactory();
		
		Protocolo protocolo = af.getProtocolo("ftp.inf011.ifba.edu.br", Integer.valueOf(21));
		
		System.out.println("****************************************************************");
		protocolo.open();
		protocolo.message(af.getRequest(), af.getResponse());
		protocolo.close();
		System.out.println("****************************************************************");
		
	}	
}

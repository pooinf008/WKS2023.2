package br.edu.inf011;

import br.edu.inf011.abstractFactory.ProtocoloAbstractFactory;
import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.factoryMethod.ProtocoloFactory;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.TipoProtocolo;
import br.edu.inf011.model.ftp.FTPFactory;
import br.edu.inf011.model.ftp.FTPProtocolo;
import br.edu.inf011.model.ftp.FTPRequest;
import br.edu.inf011.model.ftp.FTPResponse;
import br.edu.inf011.model.http.HTTPFactory;
import br.edu.inf011.model.http.HTTPProtocolo;
import br.edu.inf011.model.http.HTTPRequest;
import br.edu.inf011.model.http.HTTPResponse;

public class App2 {
    
	public static void main(String[] args) throws ProtocoloException {
		App2 app = new App2();
		app.runQ1();
		app.runQ2();
	}

	private void runQ1() throws ProtocoloException {
		
		TipoProtocolo tipo = TipoProtocolo.FTP;
		
		System.out.println("****************************************************************");
		if(tipo == TipoProtocolo.FTP) {
			FTPProtocolo ftp = new FTPProtocolo("ftp.inf011.ifba.edu.br", 
												Integer.valueOf(21));
			ftp.open();
			ftp.message(new FTPRequest(), new FTPResponse());
			ftp.close();
			
		}else if(tipo == TipoProtocolo.HTTP) {
			HTTPProtocolo http = new HTTPProtocolo("http.inf011.ifba.edu.br", 
					Integer.valueOf(21));
			http.open();
			http.message(new HTTPRequest(), new HTTPResponse());
			http.close();
		}
		
		System.out.println("****************************************************************");
		
	}
	
	private void runQ2() throws ProtocoloException {
		
		
		TipoProtocolo tipo = TipoProtocolo.FTP;
		
		System.out.println("****************************************************************");
		if(tipo == TipoProtocolo.FTP) {
			FTPProtocolo ftp = new FTPProtocolo("ftp.inf011.ifba.edu.br", 
												Integer.valueOf(21));
			ftp.open();
			ftp.message(new FTPRequest(), new HTTPResponse());
			ftp.close();
			
		}else if(tipo == TipoProtocolo.HTTP) {
			HTTPProtocolo http = new HTTPProtocolo("http.inf011.ifba.edu.br", 
					Integer.valueOf(21));
			http.open();
			http.message(new HTTPRequest(), new FTPResponse());
			http.close();
		}
		
		System.out.println("****************************************************************");
		
	}	
}

package br.edu.inf011.factoryMethod;

import br.edu.inf011.exception.ProtocoloException;
import br.edu.inf011.model.Protocolo;
import br.edu.inf011.model.TipoProtocolo;
import br.edu.inf011.model.ftp.FTPProtocolo;
import br.edu.inf011.model.http.HTTPProtocolo;

public class ProtocoloFactory {
	
	
	public Protocolo create(TipoProtocolo tipo, String host, Integer port) throws ProtocoloException {
		Protocolo protocolo;
		switch(tipo) {
			case FTP : protocolo = new FTPProtocolo(); break;
			case HTTP : protocolo = new HTTPProtocolo(); break;
			default : throw new ProtocoloException();
		}
		protocolo.init(host, port);
		return protocolo;
	}

}

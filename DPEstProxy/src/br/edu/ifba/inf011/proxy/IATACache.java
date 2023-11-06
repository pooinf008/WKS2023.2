package br.edu.ifba.inf011.proxy;

import java.util.Map;
import java.util.HashMap;

import br.edu.ifba.inf011.IATAResolver;

//PROXY em um PROXY
public class IATACache implements IATAResolver{

	public Map<String, String> localIATA;
	public IATAResolver clientIATA;
	public boolean habilitado;
	
	
	public IATACache(IATAResolver clientIATA, String user, String pwd) {
		this.localIATA = new HashMap<String, String>();
		this.clientIATA = clientIATA;
		this.habilitado = user.equalsIgnoreCase("ADM") &&
				          pwd.equalsIgnoreCase("123"); 
	}
	
	
	@Override
	public String consultarIATA(String iata) throws Exception {
		if (!this.habilitado)
			throw new Exception("OPERACAO NÃO AUTORIZADA");
		
		String cidade = this.localIATA.get(iata);
		if(cidade != null)
			return cidade;
		cidade = this.clientIATA.consultarIATA(iata);
		this.localIATA.put(iata, cidade);
		return cidade;
	}

}

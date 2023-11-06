package br.edu.ifba.inf011.client;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.IATAResolver;

public class LocalClientIATA implements IATAResolver{

	private Map<String, String> iatas;
	
	public LocalClientIATA(){
		this.init();
	}	
	
	private void init() {
		this.iatas = new HashMap<String, String>();
		this.iatas.put("SSA", "SALVADOR");
		this.iatas.put("GRU", "GUARULHOS");
		this.iatas.put("CGH", "CONGONHAS");
		this.iatas.put("CNF", "CONFINS");
		this.iatas.put("POA", "PORTO ALEGRE");
		this.iatas.put("REC", "RECIFE");
		this.iatas.put("LAX", "LOS ANGELES");
		this.iatas.put("MAD", "MADRID");		
		
	}	
	
	@Override
	public String consultarIATA(String iata) throws Exception {
		return this.iatas.get(iata);
	}

}

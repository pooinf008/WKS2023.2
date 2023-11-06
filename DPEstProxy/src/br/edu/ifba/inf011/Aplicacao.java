package br.edu.ifba.inf011;

import br.edu.ifba.inf011.client.ClientIATA;
import br.edu.ifba.inf011.proxy.IATACache;

//CLIENT em um PROXY
public class Aplicacao {
	
	public void run() throws  Exception {
		IATAResolver client = new IATACache(new ClientIATA(), "ADM", "123");
		for(int iCont = 0; iCont < 50 ; iCont++) {
			System.out.println(client.consultarIATA("SSA"));
			System.out.println(client.consultarIATA("GRU"));
			System.out.println(client.consultarIATA("LAX"));
			System.out.println(client.consultarIATA("SSA"));
		}	
	}
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).run();
	}

}

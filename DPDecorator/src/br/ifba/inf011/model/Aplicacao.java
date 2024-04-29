package br.ifba.inf011.model;

import br.ifba.inf011.model.af.ProtocoloAbstractFactory;
import br.ifba.inf011.model.af.ProtocoloFTPFactory;
import br.ifba.inf011.model.decorator.SemEspaco;
import br.ifba.inf011.model.decorator.SemVogal;
import br.ifba.inf011.model.protocolos.transporte.TCPProtocolo;

//CREATOR em FACTORY METHOD
public class Aplicacao {
	
	public void send() throws Exception {
		
		ProtocoloAbstractFactory paf = new ProtocoloFTPFactory();
		
		AplicacaoProtocolo aplicacao = paf.createProtocolo();
		aplicacao.setTransporte(new TCPProtocolo());
		Mensageiro<String> mensageiro = 
				new SemEspaco(new SemVogal(new MensageiroINF011(aplicacao, paf.createRequest(), paf.createResponse())));
		mensageiro.enviar("MENSAGEM ENVIADA PELO MENSAGEIRO");
		
	}		
	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).send();
	}		

}

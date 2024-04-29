package br.ifba.inf011.model;

import br.ifba.inf011.model.decorator.MensageiroDecorator;

public class MensageiroINF011 implements MensageiroDecorator{
	
	private MessageRequest request;
	private MessageResponse response;
	private AplicacaoProtocolo aplicacao;
	
	public MensageiroINF011(AplicacaoProtocolo aplicacao, MessageRequest request, 
						    MessageResponse response){
		this.request = request;
		this.response = response;
		this.aplicacao = aplicacao;
	}
	
	
	@Override
	public void enviar(String conteudo) throws Exception {
		aplicacao.open();
		request.addHeader("MESSAGE", "GET");
		request.setBody(new Conteudo(conteudo));
		aplicacao.message(request, response);
		aplicacao.close();	
	}

}

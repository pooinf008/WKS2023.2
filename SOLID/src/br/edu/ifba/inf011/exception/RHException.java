package br.edu.ifba.inf011.exception;

public class RHException extends Exception{
	
	private String mensagem;
	
	public RHException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}

}

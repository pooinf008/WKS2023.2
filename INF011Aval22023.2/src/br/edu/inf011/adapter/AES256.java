package br.edu.inf011.adapter;

import java.nio.charset.StandardCharsets;

public class AES256 {

	public boolean initialized = false;
	
	public AES256() {
		this.initialized = false;
	}
	
	/*Método para a inicialização do AES através de SecretKey gerada de forma aleatória através de KeyGenerator*/ 
	public void init() {
		this.initialized = true;
	};
	
	/*Método para a inicialização do AES através de chave fornecida de forma explícita */
	public void init(byte[] chave) {
		this.initialized = true;
	};
	
	/*Método que faz a cifragem de message usando a chave fornecida/gerada por um dos métodos init. Chamar este método
	 * sem inicializar o algoritmo através de uma das duas formas indicadas, lança a SecurityException
	 */
	public byte[] doFinal(byte[] message) throws SecurityException{
		if(!this.initialized)
			throw new SecurityException();
		return ("[COMPACTADA COM AES256 <<" + new String(message, StandardCharsets.UTF_8) + ">>]").getBytes();
	};

}

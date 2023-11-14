package br.edu.inf011.adapter;

import java.nio.charset.StandardCharsets;

public class AES256 {

	public boolean initialized = false;
	
	public AES256() {
		this.initialized = false;
	}
	
	/*M�todo para a inicializa��o do AES atrav�s de SecretKey gerada de forma aleat�ria atrav�s de KeyGenerator*/ 
	public void init() {
		this.initialized = true;
	};
	
	/*M�todo para a inicializa��o do AES atrav�s de chave fornecida de forma expl�cita */
	public void init(byte[] chave) {
		this.initialized = true;
	};
	
	/*M�todo que faz a cifragem de message usando a chave fornecida/gerada por um dos m�todos init. Chamar este m�todo
	 * sem inicializar o algoritmo atrav�s de uma das duas formas indicadas, lan�a a SecurityException
	 */
	public byte[] doFinal(byte[] message) throws SecurityException{
		if(!this.initialized)
			throw new SecurityException();
		return ("[COMPACTADA COM AES256 <<" + new String(message, StandardCharsets.UTF_8) + ">>]").getBytes();
	};

}

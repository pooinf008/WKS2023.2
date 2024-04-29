package br.ifba.inf011.model.decorator;

import java.util.Arrays;
import java.util.List;

import br.ifba.inf011.model.MensageiroINF011;

public class SemVogal implements MensageiroDecorator{
	
	private MensageiroDecorator mensageiro;
	public List<Character> vogais;
	
	
	public SemVogal(MensageiroINF011 mensageiroINF011) {
		this.mensageiro = mensageiroINF011;
		this.vogais = Arrays.asList('A', 'E', 'I', 'O', 'U');
	}

	@Override
	public void enviar(String conteudo) throws Exception {

		StringBuilder compactado = new StringBuilder();
		for(char c : conteudo.toCharArray())
			if(!this.vogais.contains(Character.toUpperCase(c)))
				compactado.append(c);
		this.mensageiro.enviar(compactado.toString());
	}

}

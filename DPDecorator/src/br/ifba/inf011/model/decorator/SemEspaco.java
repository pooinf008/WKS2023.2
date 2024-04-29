package br.ifba.inf011.model.decorator;

public class SemEspaco implements MensageiroDecorator{
	
	private MensageiroDecorator mensageiro;
	
	
	public SemEspaco(MensageiroDecorator mensageiro) {
		this.mensageiro = mensageiro;
	}

	@Override
	public void enviar(String conteudo) throws Exception {

		StringBuilder compactado = new StringBuilder();
		for(char c : conteudo.toCharArray())
			if(c != ' ')
				compactado.append(c);
		this.mensageiro.enviar(compactado.toString());
	}

}

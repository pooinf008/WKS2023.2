package br.edu.ifba.inf011.bridge;

import br.edu.ifba.inf011.service.Reserva;

public abstract class Impressor {
	
	private Formatador formatador;
	
	public Impressor() {
		this(new FormatadorConsole());
	}
	
	public Impressor(Formatador formatador) {
		this.formatador = formatador;
	}
	
	
	protected String writeTitulo(String string) {
		return this.formatador.bold(string);
	}
	
	protected String writeNegrito(String string) {
		return this.formatador.bold(string);
	}
	
	protected String writeItalico(String string) {
		return this.formatador.italico(string);
	}	
	
	protected String writeConteudo(String string) {
		return this.formatador.write(string);
	}
	
	protected String writeSublinhado(String string) {
		return this.formatador.sublinhado(string);
	}		
	
	protected String newLine() {
		return this.formatador.newLine();
	}		
	
	protected String init() {
		return this.formatador.init();
	}		
		
	protected String end() {
		return this.formatador.end();
	}	
	
	public abstract String getConteudo(Reserva reserva);
	

}

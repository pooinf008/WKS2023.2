package br.edu.ifba.inf011.bridge;

import br.edu.ifba.inf011.service.Reserva;

public class ImpressorResumo extends Impressor{

	public ImpressorResumo() {
		this(new FormatadorConsole());
	}
	
	public ImpressorResumo(Formatador formatador) {
		super(formatador);
	}
	
	public String getConteudo(Reserva reserva) {
		StringBuilder str = new StringBuilder();
		str.append(this.init());
		str.append(this.writeTitulo("Reserva"));
		str.append(this.newLine());
		str.append(this.writeNegrito("Nome: " + reserva.getNome()));
		str.append(this.newLine());
		str.append(this.writeItalico("Localizador: " + reserva.hashCode()));		
		str.append(this.newLine());		
		str.append(this.end());		
		return str.toString();	
	}
	
	
}

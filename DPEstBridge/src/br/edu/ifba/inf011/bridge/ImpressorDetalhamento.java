package br.edu.ifba.inf011.bridge;

import br.edu.ifba.inf011.service.Reserva;

public class ImpressorDetalhamento extends Impressor{

	public ImpressorDetalhamento() {
		this(new FormatadorConsole());
	}
	
	public ImpressorDetalhamento(Formatador formatador) {
		super(formatador);
	}
	
	public String getConteudo(Reserva reserva) {
		StringBuilder str = new StringBuilder();
		str.append(this.init());
		str.append(this.writeTitulo("Reserva"));
		str.append(this.newLine());
		str.append(this.writeNegrito("Nome: "));
		str.append(this.writeConteudo(reserva.getNome()));	
		str.append(this.newLine());		
		str.append(this.writeNegrito("Voo: "));
		str.append(this.writeConteudo(reserva.getNumeroVoo() + "(" + reserva.getIataOrigem() + "-" + reserva.getIataDestino()));		
		str.append(this.newLine());
		str.append(this.writeNegrito("Poltrona: "));
		str.append(this.writeConteudo(reserva.getPoltrona()));	
		str.append(this.newLine());		
		str.append(this.writeNegrito("Preco: "));
		str.append(this.writeConteudo("R$" + reserva.getPreco()));	
		str.append(this.newLine());		
		str.append(this.writeNegrito("Localizador: "));
		str.append(this.writeConteudo(String.valueOf(reserva.hashCode())));	
		str.append(this.newLine());			
		str.append(this.end());
		return str.toString();		
	}
	
	
}

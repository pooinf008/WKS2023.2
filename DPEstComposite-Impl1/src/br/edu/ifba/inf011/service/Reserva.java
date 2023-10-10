package br.edu.ifba.inf011.service;

import java.util.Objects;

public class Reserva {
	
	private String nome;
	private String numeroVoo;
	private String iataOrigem;
	private String iataDestino;
	private String localizador;
	private Double preco;
	
	
	public Reserva(String nome, String numeroVoo, String iataOrigem, String iataDestino, 
				   Double preco) {
		super();
		this.nome = nome;
		this.numeroVoo = numeroVoo;
		this.iataOrigem = iataOrigem;
		this.iataDestino = iataDestino;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public String getIataOrigem() {
		return iataOrigem;
	}


	public String getIataDestino() {
		return iataDestino;
	}


	public String getNumeroVoo() {
		return numeroVoo;
	}


	public String toString() {
		StringBuilder str = new StringBuilder("Reserva\n");
		str.append("Nome: " + this.getNome() + "\n");
		str.append("Voo: " + this.getNumeroVoo() + "(" + this.getIataOrigem() + "-" + this.getIataDestino() +")\n");
		str.append("Preço: R$" + this.getPreco() + "\n");
		
		str.append("Localizador: " + this.hashCode());
		return str.toString();
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(iataDestino, iataOrigem, localizador, nome, numeroVoo, preco);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(iataDestino, other.iataDestino) && Objects.equals(iataOrigem, other.iataOrigem)
				&& Objects.equals(localizador, other.localizador) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroVoo, other.numeroVoo)
				&& Objects.equals(preco, other.preco);
	}


	public Double getPreco() {
		return this.preco;
	}
	
	

}

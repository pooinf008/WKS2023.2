package br.edu.ifba.inf011.service;

import java.util.Objects;

import br.edu.ifba.inf011.bridge.Impressor;
import br.edu.ifba.inf011.bridge.Formatador;

public class ReservaDetalhada implements Reserva{
	
	private String nome;
	private String numeroVoo;
	private String iataOrigem;
	private String iataDestino;
	private String poltrona;
	private String localizador;
	private Double preco;
	

	public ReservaDetalhada(String nome, String numeroVoo, String iataOrigem, String iataDestino, String poltrona,
					Double preco) {
		this.nome = nome;
		this.numeroVoo = numeroVoo;
		this.iataOrigem = iataOrigem;
		this.iataDestino = iataDestino;
		this.poltrona = poltrona;
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


	public String getPoltrona() {
		return poltrona;
	}


	public String getNumeroVoo() {
		return numeroVoo;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(iataDestino, iataOrigem, localizador, nome, numeroVoo, poltrona, preco);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaDetalhada other = (ReservaDetalhada) obj;
		return Objects.equals(iataDestino, other.iataDestino) && Objects.equals(iataOrigem, other.iataOrigem)
				&& Objects.equals(localizador, other.localizador) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroVoo, other.numeroVoo) && Objects.equals(poltrona, other.poltrona)
				&& Objects.equals(preco, other.preco);
	}


	public Double getPreco() {
		return this.preco;
	}
	
	

}

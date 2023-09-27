package br.edu.ifba.inf011.adapter;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.Flight;

//ADAPTER (Object) EM ADAPTER
public class AdapterObjectFlight implements Voo{
	
	private Flight flight;
	private MapaCadeiras mapaCadeiras;
	private Double cotacaoDolar;
	
	public AdapterObjectFlight(Flight flight, Double cotacaoDolar) {
		this.flight = flight;
		this.mapaCadeiras = new MapaCadeiras(this.flight.getCapacity());
		this.cotacaoDolar = cotacaoDolar;
	}

	@Override
	public String getIATAPartida() {
		return this.flight.getIataFrom();
	}

	@Override
	public String getIATAChegada() {
		return this.flight.getIataTo();
	}

	@Override
	public Double getPreco() {
		return this.flight.getPrice() * this.cotacaoDolar;
	}
	

	@Override
	public String getNumero() {
		return this.flight.getCod();
	}

	@Override
	public void reservar(Integer linha, Integer coluna) {
		this.mapaCadeiras.reservar(linha, coluna);
		this.flight.reserve();
	}

	@Override
	public boolean disponivel(Integer linha, Integer coluna) {
		return this.mapaCadeiras.disponivel(linha, coluna);
	}

}

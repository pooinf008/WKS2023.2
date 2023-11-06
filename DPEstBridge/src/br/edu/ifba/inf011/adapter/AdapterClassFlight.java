package br.edu.ifba.inf011.adapter;

import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.model.impl.Flight;

//ADAPTER (Class) EM ADAPTER
public class AdapterClassFlight extends Flight implements Voo{

	private Double cotacaoDolar;
	private MapaCadeiras mapaCadeiras;
	
	public AdapterClassFlight(String iataFrom, String iataTo, Double price, String cod, Integer capacity,
			Integer used, Double cotacaoDolar) {
		super(iataFrom, iataTo, price, cod, capacity, used);
		this.cotacaoDolar = cotacaoDolar;
		this.mapaCadeiras = new MapaCadeiras(this.getCapacity());
	}

	@Override
	public String getIATAPartida() {
		return this.getIataFrom();
	}

	@Override
	public String getIATAChegada() {
		return this.getIataTo();
	}

	@Override
	public Double getPreco() {
		return super.getPrice() * this.cotacaoDolar;
	}

	@Override
	public String getNumero() {
		return this.getCod();
	}

	@Override
	public void reservar(Integer linha, Integer coluna) {
		this.mapaCadeiras.reservar(linha, coluna);
		this.reserve();
	}

	@Override
	public boolean disponivel(Integer linha, Integer coluna) {
		return this.mapaCadeiras.disponivel(linha, coluna);
	}

}

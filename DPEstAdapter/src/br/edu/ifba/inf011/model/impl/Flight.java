package br.edu.ifba.inf011.model.impl;


//ADAPTEE em ADAPTER
public class Flight {
	
	
	private String iataFrom;
	private String iataTo;
	private Double price;
	private String cod;
	private Integer capacity;
	private Integer used;
	
	
	public Flight(String iataFrom, String iataTo, Double price, String cod, Integer capacity, Integer used) {
		super();
		this.iataFrom = iataFrom;
		this.iataTo = iataTo;
		this.price = price;
		this.cod = cod;
		this.capacity = capacity;
		this.used = used;
	}


	public String getIataFrom() {
		return iataFrom;
	}


	public String getIataTo() {
		return iataTo;
	}


	public Double getPrice() {
		return price;
	}


	public String getCod() {
		return cod;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public Integer getUsed() {
		return used;
	}
	
	public void reserve() {
		this.used++;
	}
	
	
		

}

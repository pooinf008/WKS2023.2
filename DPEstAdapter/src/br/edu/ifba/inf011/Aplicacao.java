package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.Flight;
import br.edu.ifba.inf011.model.impl.VooImpl;
import br.edu.ifba.inf011.adapter.AdapterClassFlight;
import br.edu.ifba.inf011.adapter.AdapterObjectFlight;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.GerenteReserva;
import br.edu.ifba.inf011.service.Reserva;
import br.edu.ifba.inf011.service.ReservaException;

public class Aplicacao {
	
	public void run() throws ReservaException {
		
//		Voo flight = new AdapterClassFlight("GRU", "EZE", 500.0, "AA1258", 30, 0, 5.0);

		Voo flight = new AdapterObjectFlight(new Flight("GRU", "EZE", 500.0, "AA1258", 30, 0), 5.0);
		
		
		Voo voo = new VooImpl("SSA", "GRU", 1000.0, "G31400", 5, 6);
		GerenteReserva gerenteReserva = new GerenteReserva();
		Reserva reserva = gerenteReserva.reservar("Fred", voo, 0, 0);
		System.out.println(reserva);
		System.out.println("***************************************\n");
		
		Reserva reserva2 = gerenteReserva.reservar("Zé", voo, 0, 1);
		System.out.println(reserva2);
		System.out.println("***************************************\n");
		
		Reserva reserva3 = gerenteReserva.reservar("Fred", flight, 0, 0);
		System.out.println(reserva3);
		System.out.println("***************************************\n");
		
		Reserva reserva4 = gerenteReserva.reservar("Zé", flight, 0, 1);
		System.out.println(reserva4);
		System.out.println("***************************************\n");
		
	}
	
	public static void main(String[] args) throws ReservaException {
		(new Aplicacao()).run();
	}

}

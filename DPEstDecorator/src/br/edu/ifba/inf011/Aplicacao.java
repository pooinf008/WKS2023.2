package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooDireto;
import br.edu.ifba.inf011.decorator.concrete.VooClienteFidelidadeDecorator;
import br.edu.ifba.inf011.decorator.concrete.VooDecoratorDummy;
import br.edu.ifba.inf011.decorator.concrete.VooExecutivaDecorator;
import br.edu.ifba.inf011.decorator.concrete.VooMalaDecorator;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.GerenteReserva;
import br.edu.ifba.inf011.service.Reserva;
import br.edu.ifba.inf011.service.ReservaException;


//CLIENT em DECORATOR
public class Aplicacao {
	
	public void run() throws ReservaException {
		
		Voo vooSSA_FLN = new VooDireto("SSA", "FLN", 1000.0, "G31400");
		
		Voo v1 = new VooDireto("FLN", "EZE", 1000.0, "G31500");
		Voo v2 = new VooExecutivaDecorator(v1);
		Voo v3 = new VooMalaDecorator(v2);
		
		Voo vooFLN_EZE = new VooMalaDecorator(new VooExecutivaDecorator(new VooDireto("FLN", "EZE", 1000.0, "G31500")));
		
		Voo vooEZE_FTE = new VooMalaDecorator(new VooMalaDecorator(new VooExecutivaDecorator(new VooClienteFidelidadeDecorator(new VooDireto("EZE", "FTE", 1000.0, "G32500")))));
		
		Voo vooFTE_USH =  new VooExecutivaDecorator(new VooExecutivaDecorator(new VooDireto("FTE", "USH", 1000.0, "AA1600")));
		
		
		GerenteReserva gerenteReserva = new GerenteReserva();
		Reserva reserva = gerenteReserva.reservar("Fred", vooSSA_FLN);
		System.out.println(reserva);
		System.out.println("***************************************\n");
		reserva = gerenteReserva.reservar("Fred", vooFLN_EZE);
		System.out.println(reserva);
		System.out.println("***************************************\n");

		reserva = gerenteReserva.reservar("Fred", vooEZE_FTE);
		System.out.println(reserva);
		System.out.println("***************************************\n");

		reserva = gerenteReserva.reservar("Fred", vooFTE_USH);
		System.out.println(reserva);
		System.out.println("***************************************\n");
		
		
	}
	
	public static void main(String[] args) throws ReservaException {
		(new Aplicacao()).run();
	}

}

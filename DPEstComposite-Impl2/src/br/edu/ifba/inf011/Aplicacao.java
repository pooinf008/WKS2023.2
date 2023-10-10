package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.VooComposto;
import br.edu.ifba.inf011.model.impl.VooDireto;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.GerenteReserva;
import br.edu.ifba.inf011.service.Reserva;
import br.edu.ifba.inf011.service.ReservaException;


//CLIENT em COMPOSITE
public class Aplicacao {
	
	public void run() throws ReservaException {
		
		Voo vooSSA_FLN = new VooDireto("SSA", "FLN", 1000.0, "G31400");
		
				
		Voo vooFLN_EZE = new VooDireto("FLN", "EZE", 1000.0, "G31500");
		
		vooFLN_EZE.addVoo(vooSSA_FLN);
		
		Voo vooEZE_FTE = new VooDireto("EZE", "FTE", 1000.0, "G32500");
		
		Voo vooFTE_USH = new VooDireto("FTE", "USH", 1000.0, "AA1600");
		
		Voo vooSSA_EZE = new VooComposto("G35000");
		vooSSA_EZE.addVoo(vooSSA_FLN);
		vooSSA_EZE.addVoo(vooFLN_EZE);
		
		Voo vooSSA_USH = new VooComposto("G35555");
		vooSSA_USH.addVoo(vooSSA_EZE);
		vooSSA_USH.addVoo(vooEZE_FTE);
		vooSSA_USH.addVoo(vooFTE_USH);
		
		
		
		GerenteReserva gerenteReserva = new GerenteReserva();
		Reserva reserva = gerenteReserva.reservar("Fred", vooSSA_USH);
		System.out.println(reserva);
		System.out.println("***************************************\n");
		
	}
	
	public static void main(String[] args) throws ReservaException {
		(new Aplicacao()).run();
	}

}

package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.impl.Flight;
import br.edu.ifba.inf011.model.impl.VooImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.edu.ifba.inf011.adapter.AdapterClassFlight;
import br.edu.ifba.inf011.adapter.AdapterObjectFlight;
import br.edu.ifba.inf011.bridge.Formatador;
import br.edu.ifba.inf011.bridge.FormatadorHTML;
import br.edu.ifba.inf011.bridge.FormatadorWhatsApp;
import br.edu.ifba.inf011.bridge.Impressor;
import br.edu.ifba.inf011.bridge.ImpressorDetalhamento;
import br.edu.ifba.inf011.bridge.ImpressorResumo;
import br.edu.ifba.inf011.model.Voo;
import br.edu.ifba.inf011.service.GerenteReserva;
import br.edu.ifba.inf011.service.Reserva;
import br.edu.ifba.inf011.service.ReservaDetalhada;
import br.edu.ifba.inf011.service.ReservaException;

public class Aplicacao {
	
	private	Impressor impressor;
	private String extensao;
	
	public Aplicacao(Impressor impressor, String extensao) {
		this.impressor = impressor;
		this.extensao = extensao;
	}
	
	
	public void saveReserva(String fileName, Reserva reserva) throws IOException {
		String str = this.impressor.getConteudo(reserva);
		Path path = Paths.get(fileName);
		byte[] strToBytes = str.getBytes();
		Files.write(path, strToBytes);
	}
	
	
	public void run() throws ReservaException, IOException {
		String diretorio = "C:\\Users\\fredericojorge\\reservas\\";
		Voo flight = new AdapterObjectFlight(new Flight("GRU", "EZE", 500.0, "AA1258", 30, 0), 5.0);
		
		Voo voo = new VooImpl("SSA", "GRU", 1000.0, "G31400", 5, 6);
		GerenteReserva gerenteReserva = new GerenteReserva();
		Reserva reserva = gerenteReserva.reservar("Fred", voo, 0, 0);
		this.saveReserva(diretorio + "Reserva01." + this.extensao, reserva);
		System.out.println("***************************************\n");
		
		Reserva reserva2 = gerenteReserva.reservar("Zé", voo, 0, 1);
		this.saveReserva(diretorio + "Reserva02." + this.extensao, reserva2);
		System.out.println("***************************************\n");
		
		Reserva reserva3 = gerenteReserva.reservar("Fred", flight, 0, 0);
		this.saveReserva(diretorio + "Reserva03." + this.extensao, reserva3);
		System.out.println("***************************************\n");
		
		Reserva reserva4 = gerenteReserva.reservar("Zé", flight, 0, 1);
		this.saveReserva(diretorio + "Reserva04." + this.extensao, reserva4);
		System.out.println("***************************************\n");
		
	}
	
	public static void main(String[] args) throws ReservaException, IOException {
		(new Aplicacao(new ImpressorResumo(new FormatadorWhatsApp()), "txt")) 
				.run();
	}

}

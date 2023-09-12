package br.edu.ifba.inf011.principles;

public class App {
	
	private Hotel hotel;
	
	public App() {
		this.hotel = new Hotel("Meu Hotel", 3);
	}

	private int reservar() {
		return this.hotel.reservar();
	}
	
	public void run() {
		int reserva;
		for(int iCount = 0; iCount < 5; iCount++) {
			reserva = this.reservar();
			if(reserva >= 0)
				System.out.println("Reservado o quarto #" + reserva);
			else
				System.out.println("LOTADO");
		}	
	}

	public static void main(String[] args) {
		(new App()).run();
	}

}

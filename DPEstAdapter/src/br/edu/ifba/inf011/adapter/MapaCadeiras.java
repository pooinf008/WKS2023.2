package br.edu.ifba.inf011.adapter;

public class MapaCadeiras {
	
	private boolean[][] cadeiras;
	
	public MapaCadeiras(Integer capacidade) {
		this(6, capacidade);
	}
	
	public MapaCadeiras(Integer poltronas, Integer capacidade) {
		Integer fileira = capacidade /  poltronas;
		this.cadeiras = new boolean[fileira][poltronas];
		for(int iCont = 0; iCont < this.cadeiras.length; iCont++)
			for(int jCont = 0; jCont < this.cadeiras[iCont].length; jCont++)
				this.cadeiras[iCont][jCont] = false;
	}
	
	public void reservar(Integer linha, Integer coluna) {
		this.cadeiras[linha][coluna] = true;
	}

	public boolean disponivel(Integer linha, Integer coluna) {
		return !this.cadeiras[linha][coluna];
	}	

}

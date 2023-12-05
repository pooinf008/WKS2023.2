package br.edu.ifba.inf011.model.memento.impl1;

public class VooSnapshot {
	
	private boolean[][] cadeiras;
	
	public VooSnapshot(boolean[][] cadeiras) {
		this.cadeiras = new boolean[cadeiras.length][cadeiras[0].length];
		for(int iCount = 0; iCount < this.cadeiras.length; iCount++)
			for(int jCount = 0; jCount < this.cadeiras[iCount].length; jCount++)
				this.cadeiras[iCount][jCount] = cadeiras[iCount][jCount];
	}
	
	
	public boolean[][] getState(){
		return this.cadeiras;
	}
	
}

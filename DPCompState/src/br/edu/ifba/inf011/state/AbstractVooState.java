package br.edu.ifba.inf011.state;

import br.edu.ifba.inf011.model.Voo;

//STATE em um STATE
public abstract class AbstractVooState implements VooState{

	@Override
	public int[] reservar(Voo voo, int linha, int coluna) {
		return null;
	}

	@Override
	public int[] reservar(Voo voo) {
		return null;
	}

	@Override
	public void cancelarReserva(Voo voo, int linha, int coluna) {
	}

	@Override
	public VooState abrirCheckin() {
		return this;
	}

	@Override
	public VooState abrirEmbarque() {
		return this;
	}

	@Override
	public VooState cancelar() {
		return this;
	}

	@Override
	public VooState abrirReserva() {
		return this;
	}

	@Override
	public VooState finalizar() {
		return this;
	}
	
	protected int[] facaReserva(Voo voo, Integer linha, Integer coluna) {
		if(!voo.disponivel(linha, coluna))
			return null;
		int[] posicao = new int[2];
		posicao[0] = linha;
		posicao[1] = coluna;
		voo.facaReserva(linha, coluna);
		return posicao;
	}
	
	protected void facaCancelamento(Voo voo, Integer linha, Integer coluna) {
		voo.facaCancelamento(linha, coluna);
	}
	
	protected int[] facaReserva(Voo voo) {
		int[] posicao = new int[2];
		for(int iCount = 0; iCount < voo.getQtdeLinhas(); iCount++)
				for(int jCount = 0; jCount < voo.getQtdeColunas(); jCount++)
					if(voo.disponivel(iCount, jCount)) {
						posicao[Voo.LINHA] = iCount;
						posicao[Voo.COLUNA] = jCount;
						return this.facaReserva(voo, posicao[Voo.LINHA], posicao[Voo.COLUNA]);
					}	
		
		return null;
	}
		

}

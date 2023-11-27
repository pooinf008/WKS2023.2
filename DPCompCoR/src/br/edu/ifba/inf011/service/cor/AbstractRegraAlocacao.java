package br.edu.ifba.inf011.service.cor;

import br.edu.ifba.inf011.model.Voo;

//ABSTRACTCLASS em um TEMPLATEMETHOD
public abstract class AbstractRegraAlocacao implements RegraAlocacao{

	private AbstractRegraAlocacao sucessor;
	private Integer divisor;
	
	public AbstractRegraAlocacao(){
		this(null, null);
	}	
	
	public AbstractRegraAlocacao(Integer divisor, AbstractRegraAlocacao sucessor){
		this.divisor = divisor;
		this.sucessor = sucessor;
	}
	
	public int[] alocar(Voo voo) {
		if(!this.isAplicavel(voo))
			if(hasNext())
				return this.sucessor.alocar(voo);
			else
				return null;
		return this.procederAlocacao(voo);
	}

	protected boolean hasNext() {
		return this.sucessor != null;
	};

	public abstract int[] procederAlocacao(Voo voo);
	protected abstract boolean isAplicavel(Voo voo);

	protected Integer getDivisor() {
		return this.divisor;
	}

}

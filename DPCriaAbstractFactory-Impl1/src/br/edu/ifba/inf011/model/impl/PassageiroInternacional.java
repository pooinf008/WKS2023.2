package br.edu.ifba.inf011.model.impl;

import br.edu.ifba.inf011.model.Passageiro;

//CONCRETE PRODUCT em um ABSTRACT FACTORY
public class PassageiroInternacional implements Passageiro{
	
	private PassageiroData data = new PassageiroData();

	public PassageiroInternacional() {
		
	}
	
	public PassageiroInternacional(String nome, String rg, String passaporte) {
		super();
		this.init(nome, rg, passaporte);
	}
	public void init(String nome, String rg, String passaporte) {
		this.data.setNome(nome);
		this.data.setRg(rg);
		this.data.setPassaporte(passaporte);
	}
	public String getNome() {
		return this.data.getNome();
	}
	public String getRg() {
		return this.data.getRg();
	}
	public String getPassaporte() {
		return this.data.getPassaporte();
	}
	
	@Override
	public String getDocumentoEmbarque() {
		return "Passaporte: " +  this.getPassaporte();
	}
	

}

package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.impl.PoI;

public interface PontoDeInteresse {

	
	public static final PontoDeInteresse LIVRE = new PoI();
	
	public Integer getEstrelas();
	public String getNome();
	public Double getLatitude();
	public Double getLongitude();
	public void avaliar(Integer estrelas);
	public void setNome(String nome);
	public void setLatitude(Double latitude);
	public void setLongitude(Double longitude); 

}

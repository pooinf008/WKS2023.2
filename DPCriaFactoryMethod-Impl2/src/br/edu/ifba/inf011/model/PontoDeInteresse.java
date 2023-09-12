package br.edu.ifba.inf011.model;

//PRODUCT em um Factory Method
public interface PontoDeInteresse {
	
	public Integer getEstrelas();
	public String getNome();
	public Double getLatitude();
	public Double getLongitude();
	public void avaliar(Integer estrelas);
	public void setNome(String nome);
	public void setLatitude(Double latitude);
	public void setLongitude(Double longitude); 

}

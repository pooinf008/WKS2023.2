package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.prototype.Prototipavel;

public interface Localizacao extends Prototipavel{
	public Double getLatitude();
	public Double getLongitude();
	public void setLatitude(Double latitude);
	public void setLongitude(Double longitude);
}

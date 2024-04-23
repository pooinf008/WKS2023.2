package br.edu.inf011.aval3.resolucao.model.service.proxy;

import br.edu.inf011.aval3.resolucao.model.Perfil;
import br.edu.inf011.aval3.resolucao.model.service.Classificador;
import br.edu.inf011.aval3.resolucao.model.service.NivelPerfil;

public class ClassificadorAutenticador implements Classificador{
	
	private Classificador classificador;
	private String user;
	private String pwd;
	
	public ClassificadorAutenticador(Classificador classificador, String user, String pwd) {
		this.classificador = classificador;
		this.user = user;
		this.pwd = pwd;
	}
	
	public boolean autenticar() {
		return this.user.equals(this.classificador.getPerfil().getUser()) &&
			   this.pwd.equals(this.classificador.getPerfil().getPwd());
	}

	@Override
	public NivelPerfil nivel() {
		if(!this.autenticar())
			return NivelPerfil.DESCONHECIDO;
		return this.classificador.nivel();
	}

	@Override
	public Perfil getPerfil() {
		return this.classificador.getPerfil();
	}

}

	
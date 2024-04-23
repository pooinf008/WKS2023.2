package br.edu.inf011.aval3.resolucao.builder;

import java.util.LinkedList;
import java.util.List;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.Documento;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.Perfil;
import br.edu.inf011.aval3.resolucao.model.RG;

public class PerfilBuilder implements CadastroBuilder<Perfil>{
	
	
	public static final Integer MAX_CARTAO = 3;
	public static final Integer MAX_MAIL = 2;
	

	private List<Documento> listaDocumentos;
	private boolean cpf;
	private boolean rg;
	private int qtdeEmail;
	private int qtdeCartao;
	private String user = null;
	private String pwd = null;
	
	
	public PerfilBuilder() {
		this.listaDocumentos = new LinkedList<Documento>();
		this.reset();
	}
	
	@Override
	public CadastroBuilder<Perfil> reset() {
		this.listaDocumentos.clear();
		this.user = null;
		this.pwd = null;
		this.cpf = false;
		this.rg = false;
		this.qtdeEmail = 0;
		this.qtdeCartao = 0;
		return this;
	};
	
	

	@Override
	public CadastroBuilder<Perfil> adicionarRG(RG rg) {
		if(this.rg)
			return this;
		this.listaDocumentos.add(rg);
		this.rg = true;
		return this;
	}

	@Override
	public CadastroBuilder<Perfil> adicionarCPF(CPF cpf) {
		if(this.cpf)
			return this;
		this.listaDocumentos.add(cpf);
		this.cpf = true;
		return this;
		
	}

	@Override
	public CadastroBuilder<Perfil> adicionarEMail(EMail email) {
		if(this.qtdeEmail > PerfilBuilder.MAX_MAIL - 1)
			return this;
		this.qtdeEmail++;
		this.listaDocumentos.add(email);
		return this;
	}

	@Override
	public CadastroBuilder<Perfil> adicionarCartaoCredito(CartaoCredito cartaoCredito) {
		if(this.qtdeCartao > PerfilBuilder.MAX_CARTAO - 1)
			return this;
		this.qtdeCartao++;
		this.listaDocumentos.add(cartaoCredito);
		return this;
	}
	
	@Override
	public CadastroBuilder<Perfil> setUser(String user) {
		this.user = user;
		return this;
	}

	@Override
	public CadastroBuilder<Perfil> setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}	

	@Override
	public Perfil get(String nome) {
		this.user  = (this.user == null) ? nome : this.user;
		this.pwd  = (this.pwd == null) ? nome : this.pwd;
		return new Perfil(nome, user, pwd, this.listaDocumentos);
	}



}

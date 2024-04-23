package br.edu.inf011.aval3.resolucao.builder;

import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.RG;

public interface CadastroBuilder<T> {
	
	public CadastroBuilder<T> reset();
	public CadastroBuilder<T> setUser(String user);
	public CadastroBuilder<T> setPwd(String pwd);
	public CadastroBuilder<T> adicionarRG(RG rg);
	public CadastroBuilder<T> adicionarCPF(CPF cpf);
	public CadastroBuilder<T> adicionarEMail(EMail email);
	public CadastroBuilder<T> adicionarCartaoCredito(CartaoCredito cartaoCredito);
	public T get(String nome);
	

}

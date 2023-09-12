package br.edu.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.service.Promovivel;

public class Terceirizado implements Promovivel{
	
	private String empresa;
	private DadosCadastrais dados;

	public Terceirizado(String matricula, String nome, String cpf, Cargo cargo, BigDecimal salario,
			LocalDate dataUltimoReajuste, 
			LocalDate dataUltimaMovimentacao, String empresa) {
		super();
		this.dados = new DadosCadastrais(nome, 
				matricula, cpf, cargo, salario, 
				dataUltimoReajuste, dataUltimaMovimentacao);
		this.empresa = empresa;
	}
	
	
	public String getNome() {
		return dados.getNome();
	}
	public void setNome(String nome) {
		this.dados.setNome(nome);
	}
	public String getCpf() {
		return dados.getCpf();
	}
	public void setCpf(String cpf) {
		this.dados.setCpf(cpf);
	}
	public Cargo getCargo() {
		return dados.getCargo();
	}
	public void setCargo(Cargo cargo) {
		this.dados.setCargo(cargo);
	}
	public BigDecimal getSalario() {
		return dados.getSalario();
	}
	public void setSalario(BigDecimal salario) {
		this.dados.setSalario(salario);
	}
	public LocalDate getDataUltimoReajuste() {
		return dados.getDataUltimoReajuste();
	}
	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dados.setDataUltimoReajuste(dataUltimoReajuste);
	}


	public String getMatricula() {
		return dados.getMatricula();
	}


	public void setMatricula(String matricula) {
		this.dados.setMatricula(matricula);
	}

	public LocalDate getDataUltimaMovimentacao() {
		return dados.getDataUltimaMovimentacao();
	}
	public void setDataUltimaMovimentacao(LocalDate dataUltimaMovimentacao) {
		this.dados.setDataUltimaMovimentacao(dataUltimaMovimentacao);
	}	

	@Override
	public String toString() {
		return "Terceirizado [nome=" + dados.getNome() + ", cargo=" + dados.getCargo() + ", salario=" + dados.getSalario()
					+ "]";
	}
	
	public void movimentar() {
		this.setCargo(this.getCargo().next());
	}	
		
	

	
}

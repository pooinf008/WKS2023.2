package br.edu.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DadosCadastrais {
	private String nome;
	private String matricula;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	private LocalDate dataUltimaMovimentacao;
	
	public DadosCadastrais(String nome, String matricula, String cpf, Cargo cargo, BigDecimal salario,
			LocalDate dataUltimoReajuste,
			LocalDate dataUltimaMovimentacao) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.dataUltimoReajuste = dataUltimoReajuste;
		this.dataUltimaMovimentacao = dataUltimaMovimentacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public LocalDate getDataUltimaMovimentacao() {
		return dataUltimaMovimentacao;
	}

	public void setDataUltimaMovimentacao(LocalDate dataUltimaMovimentacao) {
		this.dataUltimaMovimentacao = dataUltimaMovimentacao;
	}
	
	
}
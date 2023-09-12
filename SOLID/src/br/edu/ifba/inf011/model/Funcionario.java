package br.edu.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.service.Promovivel;
import br.edu.ifba.inf011.model.service.Reajustavel;

public class Funcionario implements FuncionarioIF{
	
	private DadosCadastrais dados;

	public Funcionario(String matricula, String nome, String cpf, 
					   Cargo cargo, BigDecimal salario, 
					   LocalDate dataUltimoReajuste,
					   LocalDate dataUltimaMovimentacao) {
		super();
		this.dados = new DadosCadastrais(nome, 
				matricula, cpf, cargo, salario, 
				dataUltimoReajuste, dataUltimaMovimentacao);
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

	public LocalDate getDataUltimaMovimentacao() {
		return dados.getDataUltimaMovimentacao();
	}
	public void setDataUltimaMovimentacao(LocalDate dataUltimaMovimentacao) {
		this.dados.setDataUltimaMovimentacao(dataUltimaMovimentacao);
	}

	
	public String getMatricula() {
		return dados.getMatricula();
	}


	public void setMatricula(String matricula) {
		this.dados.setMatricula(matricula);
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(dados.getMatricula());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(dados.getMatricula(), other.dados.getMatricula());
	}


	@Override
	public String toString() {
		return "Funcionario [nome=" + dados.getNome() + ", cargo=" + dados.getCargo() + ", salario=" + dados.getSalario()
				+ "]";
	}
	
	public void reajustar(LocalDate dtReajuste, BigDecimal pctAumento) throws RHException {
		BigDecimal aumento = this.getSalario().multiply(pctAumento);
		BigDecimal novoSalario = this.getSalario().add(aumento);
		this.setSalario(novoSalario);
		this.setDataUltimoReajuste(dtReajuste);
	}

	public void movimentar() {
		this.setCargo(this.getCargo().next());
	}	
	

}

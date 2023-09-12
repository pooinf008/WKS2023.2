package br.edu.ifba.inf011;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import br.edu.ifba.inf011.exception.RHException;
import br.edu.ifba.inf011.model.Cargo;
import br.edu.ifba.inf011.model.Funcionario;
import br.edu.ifba.inf011.model.Terceirizado;
import br.edu.ifba.inf011.model.service.ServicoReajuste;
import br.edu.ifba.inf011.model.service.regras.Regra;
import br.edu.ifba.inf011.model.service.regras.RegraMax40;
import br.edu.ifba.inf011.model.service.regras.RegraMin2Months;
import br.edu.ifba.inf011.model.service.regras.RegraNotE;
import br.edu.ifba.inf011.model.service.ServicoPromocao;

import java.util.List;

public class App {
	
	public void run() throws RHException {
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new RegraMax40());
		regras.add(new RegraMin2Months());
		
		ServicoReajuste servicoReajuste = new ServicoReajuste(regras);
		ServicoPromocao servicoPromocao = new ServicoPromocao();
		
		BigDecimal pctAumento = new BigDecimal(0.20);
		LocalDate dtReajuste = LocalDate.of(2022, 12, 31);
		
		Funcionario erichGamma = 
				new Funcionario("001", "Erich Gamma",
								"000000000-01", 
								Cargo.TRAINEE, new BigDecimal(1000),
								LocalDate.of(2020, 8, 14),
								LocalDate.of(2020, 8, 14));
		Terceirizado richardHelm
			= new Terceirizado("002", "Richard Helm", 
								 "000000000-02",
								 Cargo.SENIOR, new BigDecimal(5000),
								 LocalDate.of(2020, 8, 14),
								 LocalDate.of(2021, 8, 14),
								 "GOF");

		System.out.println(richardHelm);

		System.out.println(erichGamma);
		servicoReajuste.reajuste(erichGamma, dtReajuste, pctAumento);
		servicoPromocao.promover(erichGamma, dtReajuste);
		servicoPromocao.promover(richardHelm, dtReajuste);
		System.out.println(erichGamma);
		
		System.out.println(richardHelm);
	}
	
	public static void main(String[] args)  {
		App app = new App();
		try {
			app.run();
		}catch(RHException ex) {
			System.err.println(ex.getMensagem());
		}
	}

}

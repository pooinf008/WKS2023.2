package br.edu.inf011.aval3.resolucao.app;

import br.edu.inf011.aval3.resolucao.model.service.Classificador;
import br.edu.inf011.aval3.resolucao.builder.PerfilBuilder;
import br.edu.inf011.aval3.resolucao.model.CPF;
import br.edu.inf011.aval3.resolucao.model.CartaoCredito;
import br.edu.inf011.aval3.resolucao.model.EMail;
import br.edu.inf011.aval3.resolucao.model.Perfil;
import br.edu.inf011.aval3.resolucao.model.RG;
import br.edu.inf011.aval3.resolucao.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.resolucao.model.service.proxy.ClassificadorAutenticador;

public class Aplicacao {
	
	public void run() {
		 
		Perfil perfil = new PerfilBuilder()
									 .reset()
									 .setPwd("ze123")
									 .setUser("ze.moringa")
									 .adicionarCartaoCredito(new CartaoCredito("ZE MORINGA", "5550321069865882", "973", "31/12/2024"))
									 .adicionarCartaoCredito(new CartaoCredito("ZE MORINGA", "4024007137015284", "221", "31/12/2024"))
									 .adicionarCartaoCredito(new CartaoCredito("ZE MORINGA", "6062820053986652", "961", "31/12/2032"))
									 .adicionarCartaoCredito(new CartaoCredito("ZE MORINGA", "5028536656271061", "392", "31/12/2028"))
									 .adicionarCartaoCredito(new CartaoCredito("ZE MORINGA", "6011321873201366", "187", "31/12/2026"))
									 .adicionarRG(new RG("ZE MORINGA", "16054897", "SSP/BA", "04/12/2023"))
									 .adicionarEMail(new EMail("ze.moringa@yahoo.com"))
									 .adicionarCPF(new CPF("ZE MORINGA", "42824707399"))
									 .get("Zé da Moringa");
		
		System.out.println(perfil);
		Classificador classificador = new ClassificadorAutenticador(new ClassificadorPerfil(perfil), "ze.moringa", "ze1234");
		System.out.println("Nível do Perfil: " + classificador.nivel());
		classificador = new ClassificadorAutenticador(new ClassificadorPerfil(perfil), "ze.moringa", "ze123");
		System.out.println("Nível do Perfil: " + classificador.nivel());
		
		
		
		
	}
	
	public static void main(String[] args) {
		(new Aplicacao()).run();
	}

}

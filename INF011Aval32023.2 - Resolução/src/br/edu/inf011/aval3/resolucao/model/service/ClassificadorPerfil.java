package br.edu.inf011.aval3.resolucao.model.service;

import java.util.Iterator;

import br.edu.inf011.aval3.resolucao.model.Documento;
import br.edu.inf011.aval3.resolucao.model.Perfil;
import br.edu.inf011.aval3.resolucao.visitor.PontuarVisitor;
import br.edu.inf011.aval3.resolucao.visitor.QualificadorVisitor;

public class ClassificadorPerfil implements Classificador{
	
	private Perfil perfil;
	
	public ClassificadorPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public NivelPerfil nivel() {
		PontuarVisitor pontuador = new PontuarVisitor();
		QualificadorVisitor qualificador = new QualificadorVisitor();
		boolean hasCPF = false;
		Integer qtdeCC = 0;
		Integer pontuacao = 0;
		
		pontuador.reset();
		qualificador.reset();
		Iterator<Documento> docs = perfil.documentos().iterator();
		while(docs.hasNext()) {
			Documento doc = docs.next();
			doc.aceitar(pontuador);
			doc.aceitar(qualificador);
		}
		
		hasCPF = qualificador.getTotalCPF() >= 1;
		qtdeCC = qualificador.getTotalCC();
		pontuacao = pontuador.getTotal();
		
		if(hasCPF && pontuacao >= 5)
			return NivelPerfil.OURO;
		else if(qtdeCC >= 1 && pontuacao >=5)			
			return NivelPerfil.PRATA;
		else if(pontuacao >=3)
			return NivelPerfil.BRONZE;
		return NivelPerfil.NAO_VERIFICADO;
	}

	@Override
	public Perfil getPerfil() {
		return this.perfil;
	}
	
	

}

package br.edu.inf011.aval3.resolucao.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import br.edu.inf011.aval3.resolucao.visitor.DocumentoVisitor;
import br.edu.inf011.aval3.resolucao.visitor.FormatarDocumentoVisitor;
import br.edu.inf011.aval3.resolucao.visitor.ValidarDocumentoVisitor;

public class Perfil {
	
	private List<Documento> documentos;
	private String nome;
	private String user;
	private String pwd;
	
	
	public Perfil(String nome, String user, String pwd) {
		this(nome, user, pwd, new LinkedList<Documento>());
	}
	
	public Perfil(String nome, String user, String pwd, List<Documento> documentos) {
		this.documentos = documentos;
		this.nome = nome;
		this.user = user;
		this.pwd = pwd;
	}	
	
	public void adicionar(Documento documento) {
		this.documentos.add(documento);
	}

	public String getNome() {
		return this.nome;
	}
	
	public String toString() {
		DocumentoVisitor formatador = new FormatarDocumentoVisitor();
		DocumentoVisitor validador = new ValidarDocumentoVisitor();
		StringBuilder str = new StringBuilder();
		str.append(this.nome + "\n");
		for(Documento doc : this.documentos) {
			str.append(doc.aceitar(formatador).get()  + (((Boolean)doc.aceitar(validador).get()) ? " [Válido]" : "") + "\n");
		}	
		return str.toString();
		
	}
	
	
	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

	public Stream<Documento> documentos(){
		return this.documentos.stream();
	}

	
	
}

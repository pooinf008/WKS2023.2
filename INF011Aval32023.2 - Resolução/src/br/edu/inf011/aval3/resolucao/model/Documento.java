package br.edu.inf011.aval3.resolucao.model;

import java.util.Optional;

import br.edu.inf011.aval3.resolucao.visitor.DocumentoVisitor;

public interface Documento {
	public Optional<Object> aceitar(DocumentoVisitor visitor);
}

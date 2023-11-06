package br.edu.ifba.inf011.bridge;

public interface Formatador {
	
	public String init();
	public String bold(String str);
	public String italico(String str);
	public String write(String str);
	public String newLine();
	public String sublinhado(String str);
	public String end();

}

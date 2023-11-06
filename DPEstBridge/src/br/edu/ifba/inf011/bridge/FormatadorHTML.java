package br.edu.ifba.inf011.bridge;

public class FormatadorHTML implements Formatador{

	@Override
	public String init() {
		return "<html><head></head><body>\n";
	}

	@Override
	public String bold(String str) {
		return "<strong>"+str+"</strong>";
	}

	@Override
	public String italico(String str) {
		return "<en>"+str+"</en>";
	}

	@Override
	public String write(String str) {
		return str;
	}

	@Override
	public String newLine() {
		return "</p>";
	}

	@Override
	public String sublinhado(String str) {
		return "<u>"+str+"</u>";
	}

	@Override
	public String end() {
		return "</body>";
	}

}

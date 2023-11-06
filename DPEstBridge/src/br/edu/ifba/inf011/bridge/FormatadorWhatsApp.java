package br.edu.ifba.inf011.bridge;

public class FormatadorWhatsApp implements Formatador{

	@Override
	public String init() {
		return "";
	}

	@Override
	public String bold(String str) {
		return "*" + str + "*";
	}

	@Override
	public String italico(String str) {
		return "_" + str + "_";
	}

	@Override
	public String write(String str) {
		return str;
	}

	@Override
	public String newLine() {
		return "\n";
	}

	@Override
	public String sublinhado(String str) {
		return "~" + str + "~";
	}

	@Override
	public String end() {
		return "";
	}

}

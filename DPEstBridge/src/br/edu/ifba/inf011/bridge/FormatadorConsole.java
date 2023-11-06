package br.edu.ifba.inf011.bridge;

public class FormatadorConsole implements Formatador{

	@Override
	public String bold(String str) {
		System.out.print(str);
		return str;
	}

	@Override
	public String italico(String str) {
		System.out.print(str);
		return str;
	}

	@Override
	public String write(String str) {
		System.out.print(str);
		return str;
	}

	@Override
	public String newLine() {
		System.out.print("\n");
		return "\n";
	}

	@Override
	public String sublinhado(String str) {
		return str;
	}

	@Override
	public String init() {
		return "";
	}

	@Override
	public String end() {
		return "";
	}

}

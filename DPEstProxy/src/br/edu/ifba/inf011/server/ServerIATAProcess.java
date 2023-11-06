package br.edu.ifba.inf011.server;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class ServerIATAProcess implements Runnable {

	private Socket socket;
	private Map<String, String> iatas;
	
	
	public ServerIATAProcess(Socket s){
		this.socket = s;
		this.init();
	}
	
	private void init() {
		this.iatas = new HashMap<String, String>();
		this.iatas.put("SSA", "SALVADOR");
		this.iatas.put("GRU", "GUARULHOS");
		this.iatas.put("CGH", "CONGONHAS");
		this.iatas.put("CNF", "CONFINS");
		this.iatas.put("POA", "PORTO ALEGRE");
		this.iatas.put("REC", "RECIFE");
		this.iatas.put("LAX", "LOS ANGELES");
		this.iatas.put("MAD", "MADRID");		
		
	}

	@Override
	public void run() {
		
		try {
			BufferedReader input = new BufferedReader(
										new InputStreamReader(
												this.socket.getInputStream()));
			BufferedWriter output = new BufferedWriter(
					new OutputStreamWriter(
							this.socket.getOutputStream()));
			
			String iata = input.readLine();
			String cidade = this.iatas.get(iata);
			
			output.append(cidade);
			output.newLine();
			output.flush();
		}catch(Exception ex) {
			
		}

	}

}

package br.edu.ifba.inf011.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import br.edu.ifba.inf011.IATAResolver;

//REALSUBJECT em um PROXY
public class ClientIATA implements IATAResolver{
	
	private static final String SERVIDOR = "localhost";
	private static final int PORT = 6400;
	
	
	public String consultarIATA(String iata) throws IOException {
		Socket socket = new Socket(ClientIATA.SERVIDOR, ClientIATA.PORT);
		try {
			BufferedReader input = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream()));
			BufferedWriter output = new BufferedWriter(
					new OutputStreamWriter(
							socket.getOutputStream()));
			
			
			output.append(iata);
			output.newLine();
			output.flush();
			String cidade = input.readLine();
			socket.close();
			return cidade;
			
		}catch(Exception ex) {
			return null;
		}
		
	}
	

}

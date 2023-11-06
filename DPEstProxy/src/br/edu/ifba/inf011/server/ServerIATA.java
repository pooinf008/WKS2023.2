package br.edu.ifba.inf011.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerIATA {
	
	private static final int PORT = 6400;
	
	
	public void run() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(ServerIATA.PORT);
		
		System.out.println("Servidor executando....");
		try {
			while(true) {
				Socket s = serverSocket.accept();
				Thread thread = new Thread(new ServerIATAProcess(s));
				Thread.sleep(1000);
				thread.start();
				System.out.print("+");
			}
		}finally {	
			serverSocket.close();
		}	
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		(new ServerIATA()).run();
	}
	

}

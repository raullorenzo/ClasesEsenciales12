package edu.upc.eetac.dsa.rlorenzo.Ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public static void main(String[] args) {

		ServerSocket s; // Socket servidor
		Socket sc; // Socket cliente

		PrintStream p; // Canal de escritura
		BufferedReader b; // Canal de Lectura
		String mensaje;

		Date now = new Date();

		try {
			// Creo el socket server

			s = new ServerSocket(4444);
			System.out.println("Esperando conexi�n");

			// Invoco el metodo accept del socket servidor, me devuelve una
			// referencia al socket cliente
			sc = s.accept();

			// Obtengo una referencia a los canales de escritura y lectura del
			// socket cliente
			p = new PrintStream(sc.getOutputStream());

			while (true) {
				SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				mensaje = fecha.format(now);

				// Escribo en canal de escritura el mismo mensaje recibido
				p.println(mensaje);
				break;
			}
			p.close();

			sc.close();
			s.close();
		} catch (IOException e) {
			System.out.println("No puedo crear el socket");
		}
	}

}
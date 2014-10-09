package edu.upc.eetac.dsa.rlorenzo.Ejercicio12;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerUDP {

	public static void main(String args[]) throws Exception {
		DatagramSocket server = new DatagramSocket(9090);
		byte[] enviar = new byte[1024];
		byte[] recibir = new byte[1024];
		String mensaje;
		Date now = new Date();

		while (true) {
			System.out.println("Escuchando");
			DatagramPacket p = new DatagramPacket(recibir, recibir.length);
			server.receive(p);
			InetAddress IPAddress = p.getAddress();
			int port = p.getPort();
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			mensaje = fecha.format(now);

			enviar = mensaje.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(enviar,
					enviar.length, IPAddress, port);
			server.send(sendPacket);
			break;
		}
		server.close();
	}
}
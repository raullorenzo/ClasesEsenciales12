package edu.upc.eetac.dsa.rlorenzo.Ejercicio12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
	public static void main(String args[]) throws Exception {

		DatagramSocket client = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");

		byte[] recibir = new byte[1024];
		byte[] enviar = new byte[1024];
		try {
			DatagramPacket packet = new DatagramPacket(enviar, enviar.length,
					IPAddress, 9090);
			client.send(packet);
			DatagramPacket receivePacket = new DatagramPacket(recibir,
					recibir.length);
			client.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("FROM SERVER:" + modifiedSentence);
			client.close();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
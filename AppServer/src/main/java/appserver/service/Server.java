package appserver.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void start(int port) {
		ObjectOutputStream exit;
		ObjectInputStream input;
		boolean finish = false;
		String message = "";
		String movies = "";

		try {
			// Creating a socket to listen on the port and with a queue of size 5.
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(port, 5);
			Socket connection;
			while (!finish) {
				System.out.println("Listening at the port: " + port);

				// It will be blocked here until a client connects.
				connection = server.accept();

				System.out.println("Connection established with: " + connection.getInetAddress().getHostAddress());

				// Getting in and out flows.
				exit = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());

				// Sending the message below to the customer.
				exit.writeObject("Connection established successfully...\n");

				do {// Stay here until the client sends the FINISH message.
					try {
						// Getting the message sent by the client.
						message = (String) input.readObject();
						System.out.println("Request>> \n" + message);

						movies = new Search().movie(message);

						System.out.println("Response>> \n" + movies);

						exit.writeObject(movies);
					} catch (IOException iOException) {
						System.err.println("erro: " + iOException.toString());
					}
				} while (!message.equals("FINISH"));

				System.out.println("Connection terminated by the client.");
				finish = true;
				exit.close();
				input.close();
				connection.close();
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}
}

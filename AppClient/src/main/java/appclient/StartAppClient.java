package appclient;

import appclient.service.Client;

public class StartAppClient {

	public static void main(String[] args) {
		int port = 1025;
		String ip = "127.0.0.1";

		Client client = new Client();
		client.start(ip, port);
	}
}

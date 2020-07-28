package appserver;

import appserver.service.Server;

public class StartAppServer {
    public static void main(String[] args) {
        int port = 1025;
        Server server = new Server();
        server.start(port);
    }
}

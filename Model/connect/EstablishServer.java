package Model.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EstablishServer {

    // PRIVATE VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////
    private final int LISTENING_PORT = 32001;
    private ServerSocket server;
    private Socket connection;
    //////////////////////////////////////////////////////////////////////////////////////////

    // PUBLIC CONSTRUCTOR CREATES LISTENING SERVER
    //////////////////////////////////////////////////////////////////////////////////////////
    public EstablishServer() {
        try {
            server = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while (true) {
                connection = server.accept();
                if (connection.isConnected()) {
                    provideService(connection);
                }
            }
        } catch (IOException e) {System.out.println("Server shut down with error: " + e);}
    } // EstablishServer()
    //////////////////////////////////////////////////////////////////////////////////////////

    // SERVES THE CLIENT
    //////////////////////////////////////////////////////////////////////////////////////////
    static void provideService(Socket client) {
        try {
            System.out.println("Connection from " + client.getInetAddress().toString());
        
         client.close();
        } catch (Exception e){System.out.println("Error: " + e);}
    } // provideService()
    //////////////////////////////////////////////////////////////////////////////////////////

    // GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////////////////////////
    public int getLISTENING_PORT() {
        return LISTENING_PORT;
    } // getLISTENING_PORT()
    //////////////////////////////////////////////////////////////////////////////////////////

}
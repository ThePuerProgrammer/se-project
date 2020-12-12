package Model.connect;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EstablishServer {

    // PRIVATE VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////
    private final int LISTENING_PORT = 1726;
    private ServerSocket server;
    private Socket connection;
    private OutputStream os;
    //////////////////////////////////////////////////////////////////////////////////////////

    // PUBLIC CONSTRUCTOR CREATES LISTENING SERVER
    //////////////////////////////////////////////////////////////////////////////////////////
    public EstablishServer() {
        try {
            server = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while (true) {
                connection = server.accept();
                os = connection.getOutputStream();
                if (connection.isConnected()) {
                    provideService(connection, os);
                }
            }
        } catch (IOException e) {System.out.println("Server shut down with error: " + e);}
    } // EstablishServer()
    //////////////////////////////////////////////////////////////////////////////////////////

    // SERVES THE CLIENT
    //////////////////////////////////////////////////////////////////////////////////////////
    static void provideService(Socket client, OutputStream os) {
        try {
            String path = new File("/doc/patient_diagnosis_data.xml").getAbsolutePath();
            System.out.println("Connection from " + client.getInetAddress().toString());
            // File myFile = new File (path);
            // byte [] mybytearray  = new byte [(int)myFile.length()];
            // FileInputStream fis = new FileInputStream(myFile);
            // BufferedInputStream bis = new BufferedInputStream(fis);
            // bis.read(mybytearray,0,mybytearray.length);
            // os.write(mybytearray,0,mybytearray.length);
            // os.flush();
        
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
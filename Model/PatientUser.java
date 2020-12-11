package Model;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class PatientUser {

    private boolean connected = false;
    private Socket s;

    public PatientUser(String ip) {
        try{
            s = new Socket(ip, 7123);
            InputStream is = s.getInputStream();
            FileOutputStream fr = new FileOutputStream("testingxml.xml");
            byte[]b = is.readAllBytes();
            is.read(b, 0, b.length);
            fr.write(b, 0, b.length);
            // parse
            // diagnose
            // write back to xml file
            // send back to server

        
            fr.flush();
            fr.close();
            is.close();
            s.close();
        
        }catch(Exception e){System.out.println(e);}
    }

    public Socket getS() {
        return s;
    }
}


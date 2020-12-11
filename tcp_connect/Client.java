package tcp_connect;
import java.io.*;
import java.net.*;

public class Client {

    public Client() {
        try{
            byte []b = new byte[200002];
            Socket s = new Socket("192.168.1.123", 7123);
            InputStream is = s.getInputStream();
            FileOutputStream fr = new FileOutputStream("\\home\\padwan\\Documents\\School Junior\\SE I\\testingxml.xml");
            is.read(b, 0, b.length);
            fr.write(b, 0, b.length);
            fr.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
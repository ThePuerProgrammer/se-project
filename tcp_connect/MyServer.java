package tcp_connect;


import java.io.*;
import java.net.*;

public class MyServer {
    
    public static void main(String[] args) {
        try{
            InetAddress addr = InetAddress.getByName("192.168.1.123");
            SocketAddress addres = new InetSocketAddress(addr, 7123);
            ServerSocket ss = new ServerSocket();
            ss.bind(addres);
            
            Socket s = ss.accept();
            FileInputStream fr = new FileInputStream("xmlfile.xml");
            byte b[]=fr.readAllBytes();
            fr.read(b, 0, b.length);
            OutputStream os = s.getOutputStream();
            os.write(b, 0, b.length);
            os.flush();
            os.close();
            fr.close();
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

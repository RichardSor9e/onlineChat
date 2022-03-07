package client;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class ServerNetwork {
    private static int port = 5001;
private static DataInputStream in;
private static DataOutputStream out;



    public static void network (){

        Socket socket = null;
        try {
            socket = new Socket("localHost",port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting for connect...");
            System.out.println("Connected.");

        try {
            in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
           while (true) {

                       String s = in.readUTF();
                       System.out.println(s);
               }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }





    public static void sentMessage (String a){
        try {
            out.writeUTF(a);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
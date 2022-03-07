package server;
import client.NetworkThread;
import client.ServerNetwork;

import java.net.*;
import java.io.*;
import java.util.*;

public class Main {
    private static int port = 5001;
    private static DataOutputStream out;
    private static DataInputStream in;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for connect...");
            Socket socket = serverSocket.accept();
            System.out.println("Connected.");
             in = new DataInputStream(socket.getInputStream());
             out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Привет от сервера!");


Thread thread = new ServerThread();
thread.start();



            while (true){
                System.out.println(in.readUTF());
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static class ServerThread extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            String b = scanner.next();

            try {
                out.writeUTF(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

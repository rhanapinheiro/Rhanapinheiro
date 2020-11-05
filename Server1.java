package com.company;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server1 {
    public static void main(String[] args) throws IOException {

        ServerSocket ss1 = new ServerSocket(5058);


        while (true)
        {
            Socket s1 = null;

            try
            {

                s1 = ss1.accept();

                System.out.println("A new client is connected : " + s1);


                DataInputStream dis1 = new DataInputStream(s1.getInputStream());
                DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());

                System.out.println("Assigning new thread for this client");


                Thread t = new ClientHandler1(s1, dis1, dos1);


                t.start();

            }
            catch (Exception e){
                s1.close();
                e.printStackTrace();
            }
        }
    }
}
package com.company;
import java.io.*;
import java.net.*;


public class Serve2 {
    public static void main(String[] args) throws IOException
    {

        ServerSocket ss2 = new ServerSocket(5059);


        while (true)
        {
            Socket s2 = null;

            try
            {

                s2 = ss2.accept();

                System.out.println("A new client is connected : " + s2);


                DataInputStream dis2 = new DataInputStream(s2.getInputStream());
                DataOutputStream dos2 = new DataOutputStream(s2.getOutputStream());

                System.out.println("Assigning new thread for this client");


                Thread t = new ClientHandler2(s2, dis2, dos2);


                t.start();

            }
            catch (Exception e){
                s2.close();
                e.printStackTrace();
            }
        }
    }
}

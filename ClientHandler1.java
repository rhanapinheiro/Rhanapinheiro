package com.company;
import java.io.*;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;



// ClientHandler class
class ClientHandler1 extends Thread
{
    final OutputStream o1;
    final InputStream i1;
    final Socket s1;


    // Constructor
    public ClientHandler1(Socket s1, InputStream i1, OutputStream o1) {
        this.s1 = s1;
        this.i1 = i1;
        this.o1 = o1;
    }


    public void run()
    {
        String op_str1,n1_str1, n2_str1, total_str1;
        double num1_num, num2_num, total1 = 0;
        while (true) {
            try {

                byte[] op = new byte[100];
                this.i1.read(op);
                op_str1 = new String(op);
                System.out.println(op_str1);

                byte[] n1 = new byte[100];
                this.i1.read(n1);
                n1_str1 = new String(n1);
                num1_num = Double.parseDouble(n1_str1);


                byte[] n2 = new byte[100];
                this.i1.read(n2);
                n2_str1 = new String(n2);
                num2_num = Double.parseDouble(n2_str1);


                if(op_str1.trim().equals("+")) {
                    total1 = num1_num + num2_num;
                }else
                if(op_str1.trim().equals("-")) {
                    total1 = num1_num - num2_num;
                }else
                if(op_str1.trim().equals("/")) {
                    total1 = num1_num/num2_num;
                }else
                if(op_str1.trim().equals("*")) {
                    total1 = num1_num*num2_num;
                }



                total_str1 = String.valueOf(total1);
                this.o1.write(total_str1.getBytes( ));


            } catch (IOException e) {
                e.printStackTrace( );
            }
        }


    }
}

package com.company;

import java.io.*;
import java.net.Socket;

import java.lang.Math;

// ClientHandler class
class ClientHandler2 extends Thread {
    final OutputStream o2;
    final InputStream i2;
    final Socket s2;


    // Constructor
    public ClientHandler2(Socket s2, InputStream i2, OutputStream o2) {
        this.s2 = s2;
        this.i2 = i2;
        this.o2 = o2;
    }


    public void run() {
        String op_str2,n1_str2, n2_str2, total_str2;
        double num1_num, num2_num, total2 = 0;
        while (true) {
            try {

                byte[] op = new byte[100];
                this.i2.read(op);
                op_str2 = new String(op);
                System.out.println(op_str2);

                byte[] n1 = new byte[100];
                this.i2.read(n1);
                n1_str2 = new String(n1);
                num1_num = Double.parseDouble(n1_str2);


                byte[] n2 = new byte[100];
                this.i2.read(n2);
                n2_str2 = new String(n2);
                num2_num = Double.parseDouble(n2_str2);



                if(op_str2.trim().equals("^")) {
                    total2 = Math.pow(num1_num, num2_num);
                }else
                     if(op_str2.trim().equals("#")) {

                        total2 =  Math.pow(num1_num, 2);
                }else
                     if(op_str2.trim().equals("%")) {

                        total2 =   ((num1_num * 100) / num2_num);

                }



                total_str2 = String.valueOf(total2);
                this.o2.write(total_str2.getBytes( ));


            } catch (IOException e) {
                e.printStackTrace( );
            }
        }



    }
}

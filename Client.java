
package com.company;
import java.io.*;
import java.net.*;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Client class
public class Client {
    public static void main(String[] args) throws IOException {
        try {
            String resultado1, resultado2, opcao;
            // double v1,v2;


            InetAddress ip1 = InetAddress.getByName("localhost");
            InetAddress ip2 = InetAddress.getByName("localhost");

            Socket s1 = new Socket(ip1, 5058);
            Socket s2 = new Socket(ip2, 5059);


            InputStream i1 = s1.getInputStream();
            OutputStream o1 = s1.getOutputStream();
            InputStream i2 = s2.getInputStream();
            OutputStream o2 = s2.getOutputStream();


            do {


                System.out.println("Digite 'sair' para finalizar: ");
                // Sair do programa

                System.out.println("Informe a operacao: +|-|/|*|^|%|#");
                byte[] op = new byte[100];
                System.in.read(op);

                opcao = new String(op);

                System.out.println("Digite o primeiro numero: ");
                byte[] n1 = new byte[100];
                System.in.read(n1);
                System.out.println("Digite o segundo numero: ");
                byte[] n2 = new byte[100];
                System.in.read(n2);




                if (opcao.trim( ).equals("+")) {

                    System.out.println("Operação no serve 1");
                    o1.write(op);
                    o1.write(n1);
                    o1.write(n2);

                } else if ((opcao.trim( ).equals("-"))) {
                    System.out.println("Operação no serve 1");
                    o1.write(op);
                    o1.write(n1);
                    o1.write(n2);

                } else if (opcao.trim( ).equals("*")) {

                    System.out.println("Operação no serve 1");
                    o1.write(op);
                    o1.write(n1);
                    o1.write(n2);

                } else if (opcao.trim( ).equals("/")) {

                    System.out.println("Operação no serve 1");
                    o1.write(op);
                    o1.write(n1);
                    o1.write(n2);

                } else if (opcao.trim( ).equals("^")) {
                    System.out.println("Operação no serve 2");
                    o2.write(op);
                    o2.write(n1);
                    o2.write(n2);

                } else if (opcao.trim( ).equals("#")) {
                    System.out.println("Operação no serve 2");
                    o2.write(op);
                    o2.write(n1);
                    o2.write(n2);

                } else if (opcao.trim( ).equals("%")) {

                    System.out.println("Operação no serve 2");
                    o2.write(op);
                    o2.write(n1);
                    o2.write(n2);

                }


                //resultado 1
                byte[] total_str1 = new byte[100];
                i1.read(total_str1);
                resultado1 = new String(total_str1);
                System.out.println("RESULTADO: " + resultado1);

                //resultado 2
                byte[] total_str2 = new byte[100];
                i2.read(total_str2);
                resultado2 = new String(total_str2);
                System.out.println("RESULTADO: " + resultado2);


                byte[] line = new byte[100];

                System.out.println(new String(line));


            } while (!opcao.trim( ).equals("Sair"));
            s1.close( );
            s2.close( );


        } catch (Exception e) {
            e.printStackTrace( );
        }

    }
}
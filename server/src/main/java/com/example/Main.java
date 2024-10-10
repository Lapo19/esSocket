package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server partito");
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        System.out.println("un client si è collegato");

        String stringaRicevuta = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        
        do{
            stringaRicevuta = in.readLine();
            System.out.println("client entrato");
            System.out.println("La stringa ricevuta è: "+ stringaRicevuta);
            if (!stringaRicevuta.equals("?")) {
                String stringaMaiuscola = stringaRicevuta.toUpperCase();
                out.writeBytes(stringaMaiuscola + '\n');
            }
            System.out.println("client uscito");
        }while(!stringaRicevuta.equals("?"));
        

        

        ss.close();

        System.out.println("server finito");
    }
}
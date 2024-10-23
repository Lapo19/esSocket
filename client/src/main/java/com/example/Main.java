package com.example;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s = new Socket("localhost",3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String stringaOpzione = "";
        String stringaFrase = "";
        System.out.println("1-Trasforma la stringa in maiuscolo, 2-Trasforma la stringa in minuscolo, 3-Inverte la stringa, 4-conta i caratteri, 5-esci");

        do{
        stringaOpzione = sc.nextLine();
        
        if(!stringaOpzione.equals("5")){
        out.writeBytes(stringaOpzione + '\n');
        System.out.println("Inserisci la frase");
        stringaFrase= sc.nextLine();
        out.writeBytes(stringaFrase + '\n');

        String stringaRicevuta = in.readLine();
        System.out.println("La stringa ricevuta è: "+ stringaRicevuta);
        System.out.println("1-Trasforma la stringa in maiuscolo, 2-Trasforma la stringa in minuscolo, 3-Inverte la stringa, 4-conta i caratteri, 5-esci");
        }

        }while(!stringaOpzione.equals("5"));
        System.out.println("client finito");
        s.close();

    }   
}
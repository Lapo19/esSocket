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
        String stringa = "";

        do{
        stringa = sc.nextLine();
        out.writeBytes(stringa + '\n');

        String stringaRicevuta = in.readLine();
        System.out.println("La stringa ricevuta è: "+ stringaRicevuta);

        }while(!stringa.equals("exit!"));
        System.out.println("client finito");
        s.close();

    }   
}
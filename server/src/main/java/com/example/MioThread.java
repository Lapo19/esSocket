package com.example;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class MioThread extends Thread{
    Socket s;

    MioThread(Socket s){
        this.s = s;
    }

    public void run(){
        try{
            System.out.println("un client si è collegato");
    String stringaRicevuta = "";
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    DataOutputStream out = new DataOutputStream(s.getOutputStream());

    
    do{
        stringaRicevuta = in.readLine();
        
        if (!stringaRicevuta.equals("exit")) {
            System.out.println("client entrato");
            System.out.println("La stringa ricevuta è: "+ stringaRicevuta);
            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + '\n');
        }
        System.out.println("client uscito");
    }while(!stringaRicevuta.equals("exit"));
        }
        catch(Exception e){

        }
    }
}

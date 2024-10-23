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
            String stringaOpzione = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

    
    do{
        stringaOpzione = in.readLine();
        String stringa = "";
        
        if (!stringaOpzione.equals("5")) {
            String stringaFrase= in.readLine();
            switch (stringaOpzione) {
                case "1":
                    stringa = stringaFrase.toUpperCase();
                break;
            
                case "2":
                    stringa = stringaFrase.toLowerCase();
                break;

                case "3":
                    StringBuilder str = new StringBuilder(stringaFrase);
                    stringa = str.reverse().toString();
                    out.writeBytes(stringa + '\n');
                break;

                case "4":
                    stringa= "" + stringaFrase.length();
                break;
            }
            out.writeBytes(stringa + '\n');
        }
    }while(!stringaOpzione.equals("5"));
        }
        catch(Exception e){

        }
    }
}

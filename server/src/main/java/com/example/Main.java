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
        while(true){
            Socket mioS = ss.accept();
            MioThread m = new MioThread(mioS);
            m.start();
        }
    }
}
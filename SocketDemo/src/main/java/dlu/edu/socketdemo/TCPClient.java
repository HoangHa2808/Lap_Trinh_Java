/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.socketdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author drago
 */
public class TCPClient {

      public static void main(String[] args){
            try {
            Socket socket = new Socket("127.0.0.1", 6789);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        
        
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap du lieu: ");
        String st  = s.nextLine();
        
        System.out.println("Gui: " + st);
        
        out.println(st);
        out.flush();
        
        String line = reader.readLine();
        System.out.println("Nhan: " + line);
        
            reader.close();
            out.close();
            socket.close();
  
    }
    catch(Exception e){
            e.printStackTrace();
    }
      }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dlu.edu.socketdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author drago
 */
public class TCPServer {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Dang Lang  nghe......");
            while(true){
                Socket socket  = serverSocket.accept();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                PrintWriter out  = new PrintWriter(socket.getOutputStream());
                
                String line = reader.readLine();
                
                System.out.println("Nhan: " +line);
                System.out.println("Gui: " +line.toUpperCase());
                
                out.println(line.toUpperCase());
                
                out.flush();
                
                reader.close();
                out.close();
                socket.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

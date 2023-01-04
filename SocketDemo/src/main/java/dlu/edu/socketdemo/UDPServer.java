/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.socketdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author drago
 */
public class UDPServer {
    public static void main(String[] args){
        try{
            DatagramSocket datagram = new DatagramSocket(8077);
            byte[] read = new byte[1024];
            byte[] write = null;
            
            
            System.out.println("Dan cho ket noi....");
            
            while(true){
                DatagramPacket  receive = new DatagramPacket(read, read.length);
                datagram.receive(receive);
                
                String line = new String (receive.getData());
                write = line.toUpperCase().getBytes();
                
                InetAddress host = receive.getAddress();
                int port = receive.getPort();
                
                DatagramPacket sendP = new DatagramPacket(write,write.length, host, port);
                System.out.println("Gui " + line.toUpperCase());
                datagram.send(sendP);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

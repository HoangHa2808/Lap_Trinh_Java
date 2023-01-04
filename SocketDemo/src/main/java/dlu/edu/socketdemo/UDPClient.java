/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.socketdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author drago
 */
public class UDPClient {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nhap du lieu: ");
            String st = s.nextLine();

            DatagramSocket datagram = new DatagramSocket();
            byte[] read = new byte[1024];
            byte[] write = null;

            InetAddress host = InetAddress.getByName("localhost");
            int port = 8077;
            
            write = st.getBytes();

            DatagramPacket sendP = new DatagramPacket(write, write.length, host, port);
            System.out.println("Gui:" + st);
            datagram.send(sendP);

            DatagramPacket receiveP= new DatagramPacket(read, read.length);
            datagram.receive(receiveP);
            
            String line = new String(receiveP.getData());
            System.out.println("Nhan: " + line);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

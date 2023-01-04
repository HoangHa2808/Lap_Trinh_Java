/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ltj_lab01;

import java.util.Random;
import java.util.Scanner;
import com.ltj_lab01.menu;
/**
 *
 * @author Kiet Nguyen
 */
public class Ltj_lab01 {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
   // public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int stt;
        do {
            stt = menu.ChonMenu();
            menu.XuLyMenu(stt);
//            stt = ChonMenu();
//            XuLyMenu(stt);
        } while (stt > 0);
    }
     
     
     
    public static void XuatMenu() {
        System.out.println("+--------------+----------------+");
        System.out.println("| NGAN HANG SO | 2011400@v1.0.0 |"); 
        System.out.println("+--------------+----------------+"); 
        System.out.println("| 1. Nhap CCCD                  |");
        System.out.println("| 0. Thoat                      |");
        System.out.println("+-------------------------------+");
        System.out.print("Chuc nang: ");
    }
    
    public static int ChonMenu() {
        Scanner in = new Scanner(System.in);
        XuatMenu();   
        
        int stt = in.nextInt();
        return stt;
    }
    
    public static void XuLyMenu(int menu) {
        switch (menu) {
            case 0 -> {
                System.out.println("Thoat chuong trinh!");
                return;
            }
            case 1 -> NhapCCCD();
            default -> System.out.println("Loi");
        }  
    }
    
    // Chuc nang 1. Nhap CCCD
    public static void NhapCCCD() {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int stt;
        
        int randOTP = rand.nextInt(999-100+1)+100;
        System.out.print("Nhap ma xac thuc: " + randOTP + "\n");
        int inpOTP = in.nextInt();
        if (randOTP == inpOTP) {
            String cccd = NhapSoCCCD();
            do {
                stt = ChonMenu_NhapCCCD();
                XuLyMenu_NhapCCCD(stt, cccd);
            } while (stt > 0);
        }
        
    }
    
    public static String NhapSoCCCD() {
        Scanner in = new Scanner(System.in);        
        System.out.print("Vui long nhap so CCCD: ");
        String cccd = in.nextLine();

        String isNumber = "[0-9]+"; //regex 0-9
        while (cccd.length() != 12 && !cccd.matches(isNumber)) {
            System.out.println("So CCCD khong hop le.");
            System.out.println("Vui long thu lai hoac 'No' de thoat: ");
            cccd = in.nextLine();
            if ("No".equals(cccd)) break;
        }
        return cccd;
    }
    
    public static void XuatMenu_NhapCCCD() {
        System.out.println("\t| 1. Kiem tra noi sinh");
        System.out.println("\t| 2. Kiem tra tuoi, gioi tinh");
        System.out.println("\t| 3. Kiem tra so ngau nhien");
        System.out.println("\t| 0. Thoat");
        System.out.print("Chuc nang: ");
        
    }
    
    public static int ChonMenu_NhapCCCD() {
        Scanner in = new Scanner(System.in);
        int stt;
        XuatMenu_NhapCCCD();
        stt = in.nextInt();
       
        return stt;
    }
    
    public static void XuLyMenu_NhapCCCD(int menu, String cccd) {
        infoCCCD icccd = new infoCCCD(cccd);
        switch (menu) {
            case 0 -> {
                System.out.println("Thoat chuong trinh!");
                return;
            }
            case 1 -> KiemTraNoiSinh(icccd.getTinhTP());
            case 2 -> KiemTraTuoiGT(icccd.kiemTraTuoiGT());
            case 3 -> KiemTraSoNgauNhien(icccd.getSoNgauNhien());
            default -> System.out.println("Loi");
        }  
    }

    public static void KiemTraTuoiGT(String gt) {
        System.out.println("Gioi tinh: " + gt);
    }

    private static void KiemTraNoiSinh(String ns) {
        System.out.println("Noi sinh: " + ns);
    }
    
    public static void KiemTraSoNgauNhien(String sonn) {
        System.out.println("So ngau nhien: " + sonn);
    }
}

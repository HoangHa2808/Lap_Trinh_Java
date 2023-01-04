package asm02;
import asm02.models.Account;
import asm02.models.Bank;
import asm02.models.Customer;

import java.io.IOException;
import java.util.Scanner;

public class Asm02 {
    private static final Bank bank = new Bank();

    private static final String TITLE  = "NGAN HANG SO";
    private static final String AUTHOR  = "DOAN MINH KHUE";
    private static final String VERSION  = "2.0.0";
    public void menu(){
        Scanner s =new Scanner(System.in);

        while (true){
            System.out.println("+-------------+------------------------+--------+");
            System.out.println("|\t"+ TITLE+"\t|\t"+AUTHOR+"@"+VERSION +"\t|");
            System.out.println("+-------------+------------------------+--------+");
            System.out.println("|\t1. Them Khach hang");
            System.out.println("|\t2. Them tai khoan cho khach hang");
            System.out.println("|\t3. Hien thi danh sach khach hang");
            System.out.println("|\t4. Tim theo CCCD");
            System.out.println("|\t5. Tim theo ten khach hang");
            System.out.println("|\t0. Thoat");
            System.out.println("+-------------+------------------------+--------+");
            System.out.printf("Chuc nang: ");

            int chon = s.nextInt();
            s.nextLine();
            switch (chon)
            {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    System.exit(0);
                    break;
                case 1:
                    Customer newC= new Customer();
                    bank.addCustomer(newC);
                    bank.xuatDanhsachTatCaKhanhHang();
                    menu();
                    break;
                case 2:
                    bank.CheckThemTaiKhoan();
                    bank.xuatDanhsachTatCaKhanhHang();
                    menu();
                    break;
                case 3:
                    bank.xuatDanhsachTatCaKhanhHang();
                    menu();
                    break;
                case 4:
                    bank.searchCustomerByCCCD();
                    menu();
                    break;
                case 5:
                    bank.searchCustomerByName();
                    menu();
                    break;
            }
                System.out.println("Nhap phim ENTER de tiep tuc");
            s.nextLine();
            try{
                Runtime.getRuntime().exec("cls");
            }catch (IOException ex){}
        }
    }

    public static void main(String[] args) {

        Asm02 asm = new Asm02();
        asm.menu();
    }


}

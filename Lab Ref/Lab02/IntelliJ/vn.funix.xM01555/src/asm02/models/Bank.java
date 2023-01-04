package asm02.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.io.*;
import java.io.IOException;


public class Bank {
    private final String Id;
    private final List<Customer> customers;

    public Bank(){
        this.customers = new ArrayList<>();
        this.Id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return Id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public  void addCustomer(Customer newCustomer){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap ten Khach hang: ");
        String tenKh = s.nextLine();

        System.out.println("Nhap so CCCD: ");
        String soCCCD = s.nextLine();

        if (isCustomerExisted(soCCCD)){
            System.out.println("Khach Hang da co trong he thong ngan hang");
        }else {
            newCustomer.setName(tenKh);
            newCustomer.setCustomerId(soCCCD);
            customers.add(newCustomer);
        }
    }

    public boolean isCustomerExisted(String customerId) {
        int i= 0;
        while (i<customers.size())
        {
            if ((customers.get(i).getCustomerId()).equals(customerId)){
                return true;
            }else {i++;}
            }
        return  false;
        }

    /**----------THEM TAI KHOAN CHO KHACH HANG-------------------
     *
     */
    public void addAccount (String customerId, Account account){
        for (Customer kh: customers) {
            if (kh.getCustomerId().equals(customerId)){
                kh.addAccount(account);
                break;
            }
        }
    }
    public void CheckThemTaiKhoan(){
        Account newACC = new Account();
        Scanner s = new Scanner(System.in);
        System.out.printf("Nhap CCCD cua khach hang: ");
        String customerId = s.nextLine();
        //kiem tra so CCCD co ton tai trong he thong khong
        if (isCustomerExisted(customerId)){
            addAccount(customerId, newACC);
        }else {
            System.out.println("Nhap sai so CCCD");
            System.out.println("Xin vui long nhap lai");
            CheckThemTaiKhoan();
        }
    }

    public  void xuatDanhsachTatCaKhanhHang(){
        for (Customer kh: getCustomers()) {
            kh.displayInformation(kh);
        }
    }
    public void searchCustomerByCCCD(){
        System.out.printf("Nhap CCCD cua khach hang can tim: ");
        Scanner s = new Scanner(System.in);
        String soCCCD = s.nextLine();

        for (Customer kh: customers) {
            if (kh.getCustomerId().equals(soCCCD)){
                kh.displayInformation(kh);
                break;
            }
        }
    }

    public void searchCustomerByName(){

        System.out.printf("Nhap ten cua khach hang can tim: ");
        Scanner s = new Scanner(System.in);
        String tenKH = s.nextLine();

        String pattern = ".*"+ tenKH.toLowerCase()+".*";

        for (Customer kh: customers) {
            if (kh.getName().toLowerCase().matches(pattern)){
                kh.displayInformation(kh);
            }
        }

    }


}

package asm03.models;

import asm02.models.Bank;
import asm02.models.Customer;

import java.util.Scanner;

/*
* Lớp định nghĩa cho class quản lý ngân hàng tiềm năng.
* */
public class DigitalBank extends Bank{
    public Customer getCustomerById(String customerId ){
        for (Customer kh: getCustomers()) {
            if (isCustomerExisted(customerId)){
                return kh;
            }
        }
        return null;
    }

    public void addCustomer(String customerId, String name) {
        //super.addCustomer();
        DigitalCustomer newCustomer = new DigitalCustomer();
        if (isCustomerExisted(customerId)) {
            System.out.println("Khach Hang da co trong he thong ngan hang");
        } else {
            newCustomer.setName(name);
            newCustomer.setCustomerId(customerId);
            getCustomers().add(newCustomer);
        }
    }
    public void addAccountATM(String customerId){
            //gọi hàm addAccount từ Bank
            //tu Bank gọi hàm addAccount từ Customer
            if (isCustomerExisted(customerId)){
                SavingsAccount sa = new SavingsAccount();
                super.addAccount(customerId, sa);
            }else {
                System.out.println("So CCCD khong ton tai trong he thong");
            }
        }


    public  void addAccountLoan(String customerId){
        //gọi hàm addAcount từ Bank
        //tu Bank gọi hàm addAcount từ Customer
        if (isCustomerExisted(customerId)){
            LoansAccount la = new LoansAccount();
            super.addAccount(customerId,la);
        }else {
            System.out.println("So CCCD khong ton tai trong he thong");
        }
    }
    /*
    * Hàm rút tiền từ ngân hàng số
    * */

    public void withdraw(String customerId, String accountNumber, double amount){
        if (isCustomerExisted(customerId)){
            Customer ct = getCustomerById(customerId);
            //gọi hàm withdraw của đối tượng khách hàng tìm được.
            //goi tu lop DigitalCustomer
            ct.withdraw(accountNumber,amount);
        }else {
            System.out.println("Khach Hang khong ton tai trong he thong");
        }
    }
}

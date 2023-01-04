package asm03.models;

import asm02.models.Account;
import asm02.models.Customer;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
* Lớp định nghĩa cho class quản lý thông tin khách hàng tiềm năng
* */
public class DigitalCustomer extends Customer{

    /*
    *Hàm tìm tài khoản theo số tài khoản
     */
    public Account getAcountByAcountNumber(String soTk ){
        for (Account ac: getAccounts()) {
            if (ac.getAccountNumber().equals(soTk)){
                return ac;
            }
        }
        return null;
    }

    //Hàm withdraw này kiểm tra nếu accountNumber có tồn tại
    // thì truy xuất đối tượng đó ra và gọi hàm withdraw của đối tượng đó
    public void withdraw(String accountNumber,double amount){
        if (isAccountExisted(accountNumber)){
            Account a = getAcountByAcountNumber(accountNumber);
            if (isLoanAcount(a)){
                ((LoansAccount)a).withdraw(amount);
            }else {
                ((SavingsAccount)a).withdraw(amount);
            }
        }else {
            System.out.println("So tai khoan khong ton tai");

        }
    }

    @Override
    public void  displayInformation(Customer cs){
        System.out.println(cs.getCustomerId()+"\t|\t\t\t"+cs.getName()+"\t|\t"+cs.checkLoaiKhachHang()+"\t|\t"+ Utils.fomatBalance(cs.getBalance()));

        //in ra cac tai khoan cu the
        for (Account ac:cs.getAccounts()) {
            System.out.println((getAccounts().indexOf(ac)+1)+"\t\t"+ac.getAccountNumber()+"\t|\t\t\t"+ ac.loaiTK() +"\t|\t\t\t\t"+Utils.fomatBalance(ac.getBalance()));
        }
    }

    @Override
    public void printHistory(Customer cs){
        displayInformation(cs);
        //in ra lich su giao dich cac tai khoan
        for (Account ac:cs.getAccounts()) {
            ac.printHistory();
        }

    }
}

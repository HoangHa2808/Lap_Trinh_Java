package asm03.models;

import asm02.models.Account;
import asm03.interfaces.*;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account implements ReportService, Withdraw{
    private static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    public SavingsAccount() {
    }

    @Override
    public boolean withdraw(double amount){
        double newBalance = 0.0;
        //Số tiền rút phải lớn hơn hoặc bằng 50.000đ và là bội số của 10.000đ
        //kiểm tra xem có phải là tài khoản Premium
        if (amount >= 50000 && amount % 10000 == 0){
            if (!isPremium() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW){
                System.out.println("Tai khoan thuong chi duoc phep toi da 5.000.000d/lan");
                return false;
            }else {
                newBalance = getBalance() - amount;
                //nếu số dư mới (sau khi rút) thỏa điều kiện còn lại 50 ngàn
                if (isAccepted(newBalance)){
                    //cập nhật số dư mới vào tài khoản
                    setBalance(newBalance);
                    log(amount);
                    //ghi lai lich su giao dich
                    super.logHistory(getAccountNumber(),-amount);
                    return true;
                }
            }
        }else {
            System.out.println("So tien rut phai tren 50.000 va la boi cua 10.000");
        }
        return false;
    }
    @Override
    public boolean isAccepted(double amount) {
        //số dư trong tài khoản sau khi rút phải lớn hơn 50 000
        if (amount >= 50000){
            //cho phép rút tiền
            return true;
        }else {
            System.out.println("So Du con lai khong du 50.000 D");
            System.out.println("Lenh rut khong duoc chap nhan");
            log(0.0);
            return false;
        }
        //return false;
    }

    @Override
    public void log(double amount){
        System.out.println(Utils.getDivider());
        System.out.println("\t\t"+ "BIEN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime(),"\n");
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022","\n");
        System.out.printf("SO TK: %31s%n", getAccountNumber(),"\n");
        System.out.printf("SO TIEN: %29s%n", Utils.fomatBalance(amount),"\n");
        System.out.printf("SO DU: %31s%n",Utils.fomatBalance(getBalance()),"\n");
        System.out.printf("PHI + VAT: %27s%n", Utils.fomatBalance(0.0),"\n");
        System.out.println(Utils.getDivider());
    }
    public String loaiTK(){
        return "SAVINGS";
    }
}

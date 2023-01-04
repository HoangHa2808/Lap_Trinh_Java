package asm03.models;

import asm02.models.Account;
import asm02.models.Customer;
import asm03.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class LoansAccount extends Account implements Withdraw, ReportService {
    private static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;//định nghĩa phí rút tiền cho tài khoản thường
    private static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;//định nghĩa phí rút tiền tài khoản premium
    private static final double  LOAN_ACCOUNT_MAX_BALANCE = 100000000;// định nghĩa hạn mức tối đa cho loại tài khoản LOAN

    public LoansAccount() {
    }

    //Gán số dư  hạn mức cho tài khoản LOAN
    public void setBalance(){
        super.setBalance(LOAN_ACCOUNT_MAX_BALANCE);
    }
    /*
    *Xác định rút tiền
    *Hạn mức tín dụng là số tiền tối đa mà tổ chức tín dụng cấp để có thể sử dụng trên thẻ tín dụng
    * */
    @Override
    public boolean withdraw(double amount){
        double newBalance = 0.0;
        Transaction trans  = new Transaction();
        //Hạn mức rút với tài khoản Loan là 100 triệu đồng
        if (amount <= LOAN_ACCOUNT_MAX_BALANCE){
            newBalance = getBalance() - (amount + (super.getTransactionFee()*amount));

            //nếu số dư mới (sau khi rút) thỏa điều kiện còn  lại 50 ngàn
            if (isAccepted(newBalance)){
                //cập nhật số dư mới vào tài khoản
                setBalance(newBalance);
                log(amount);
                //ghi lich sư giao dich
                super.logHistory(getAccountNumber(),-amount);
                return true;
            }
        }else {
            System.out.println("So tien rut vuot qua han muc");
        }
        return false;
    }


    /**
     * Hàm isAccepted xác định xem giá trị có thoả "điều kiện" rút tiền hay không
     * số tiền rút vượt quá số dư hay không?
     */

    @Override
    public boolean isAccepted(double amount) {
        //số dư trong tài khoản sau khi rút phải lớn hơn 50 000
        if (amount >= 50000){
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
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.println("\t\t"+ "BIEN LAI GIAO DICH LOAN");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime(),"\n");
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022","\n");
        System.out.printf("SO TK: %31s%n", getAccountNumber(),"\n");
        System.out.printf("SO TIEN: %29s%n", Utils.fomatBalance(amount),"\n");
        System.out.printf("SO DU: %31s%n",Utils.fomatBalance(getBalance()));
        System.out.printf("PHI + VAT: %27s%n", Utils.fomatBalance(getTransactionFee()*amount),"\n");
        System.out.println(Utils.getDivider());
    }

    public String loaiTK(){
        return "LOAN";
    }
}

package asm02.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import asm01.*;
import asm03.models.LoansAccount;
import asm03.models.SavingsAccount;
import asm03.models.Transaction;

public abstract class Customer extends User{
    List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    protected boolean isPremium()
    {
        for (Account a: accounts) {
            if (a.isPremium()){
                return true;
            }
        }
        return  false;
    }

    public boolean isAccountExisted(String soTK) {
        for (Account a: accounts) {
            if (a.getAccountNumber().equals(soTK)){
                return true;
            }
        }
        return  false;
    }
    public Double getBalance(){
        double tong = 0;
        for (Account ac:accounts) {
            tong+= ac.getBalance();
        }
        return tong;
    }
    //check khach han co phải là premium
    public String checkLoaiKhachHang(){
        String loai = "Normal";
        for (Account ac: getAccounts()) {
            if (ac.isPremium()){
                loai= "Premium";
            }
        }
        return loai;
    }
    public boolean isLoanAcount(Account a){
        if (a instanceof LoansAccount){
            return true;
        }
        return false;
    }
    //Them tai khoan cho khach hang
    public void addAccount(Account newAccount){
        double soDu = 0.0;
        System.out.print("Nhap ma TK gom 6 chu so: ");
        Scanner s = new Scanner(System.in);
        String soTK = s.nextLine();

        //kiem tra so tai khoan la cac con so va co do dai la 6
        String laSo = "[0-9]+";
        if (soTK.length() ==6 && soTK.matches(laSo)){
            //kiem tra xem tai khoan da co trong he thong chua
            if (isAccountExisted(soTK)){
                System.out.println("Tai khoan da ton tai");
            }else {
                //đưa vào List tài khoản accounts không phân biệt là Loan hay Saving
                newAccount.setAccountNumber(soTK);
                if (newAccount instanceof LoansAccount){
                    ((LoansAccount)newAccount).setBalance();
                }else if (newAccount instanceof SavingsAccount){
                    soDu = inputBalance(newAccount);
                    //ghi lịch sử thêm tài khoản và tiền cho người dùng
                    newAccount.logHistory(soTK, soDu);
                }
                accounts.add(newAccount);
                //ghi lịch sử thêm tài khoản và tiền cho người dùng

            }
        }else {
            System.out.println("Sai dinh danh so tai khoan!");
            System.out.println("So tai khoan phai du 6 chu so, khong co chua ky tu chuoi");
            addAccount(newAccount);
        }
    }

    private double inputBalance(Account newAccount){
        System.out.print("Nhap so du: ");
        Scanner s = new Scanner(System.in);
        double soDu = s.nextDouble();
        s.nextLine();
        if (soDu<50000){
            System.out.println("So du phai tren 50 000");
            inputBalance(newAccount);
        }
        newAccount.setBalance(soDu);
        return soDu;
    }

    //in ra thong tin cac tai khoan cua 1 khach hang
    public abstract void displayInformation(Customer cs);
    public abstract void printHistory(Customer cs);
    public abstract void withdraw(String accountNumber,double amount);

}

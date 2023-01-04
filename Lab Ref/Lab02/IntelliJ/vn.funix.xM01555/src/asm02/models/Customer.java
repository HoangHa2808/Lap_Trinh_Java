package asm02.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import asm01.*;

public class Customer extends User{
    List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }
    public boolean isPremium()
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

    public void addAccount(Account newAccount){
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
                newAccount.setAccountNumber(soTK);
                inputBalance(newAccount);
                accounts.add(newAccount);
            }
        }else {
            System.out.println("Sai dinh danh so tai khoan!");
            System.out.println("So tai khoan phai du 6 chu so, khong co chua ky tu chuoi");
            addAccount(newAccount);
        }
    }
    private void inputBalance(Account newAccount){
        System.out.print("Nhap so du: ");
        Scanner s = new Scanner(System.in);
        double soDu = s.nextDouble();
        s.nextLine();
        if (soDu<50000){
            System.out.println("So du phai tren 50 000");
            inputBalance(newAccount);
        }else {
            newAccount.setBalance(soDu);
        }
    }
    public Double getBalance(){
        double tong = 0;
        for (Account ac:accounts) {
            tong+= ac.getBalance();
        }
        return tong;
    }
    //check khach han co phải là premium

    public String checkLoaiKH (){
        String loai = "Normal";
        for (Account ac: accounts) {
            if (ac.isPremium()){
                loai= "Premium";
            }
        }
        return loai;
    }

    //in ra thong tin cac tai khoan cua 1 khach hang
    public  void  displayInformation(Customer cs ){
        System.out.println(cs.getCustomerId()+"\t|\t\t\t"+cs.getName()+"\t|\t"+cs.checkLoaiKH()+"\t|\t"+ fomatMoney(cs.getBalance()));

        //in ra cac tai khoan cu the
        for (Account ac:cs.accounts) {
            System.out.println((accounts.indexOf(ac)+1)+"\t\t"+ac.getAccountNumber()+"\t|\t\t\t\t\t"+ fomatMoney(ac.getBalance()));
        }
    }

    private String fomatMoney(Double money){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String stringTienTe = currencyVN.format(money);
        return stringTienTe;
    }
}

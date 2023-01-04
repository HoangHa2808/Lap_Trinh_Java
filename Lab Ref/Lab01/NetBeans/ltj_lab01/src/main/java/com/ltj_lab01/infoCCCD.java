/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ltj_lab01;
import com.ltj_lab01.tinhTP;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Kiet Nguyen
 */
public class infoCCCD {
    public ArrayList<tinhTP> dsTinhTP = new ArrayList<tinhTP>(
            Arrays.asList(
                    new tinhTP("Ha Noi","001"),
                    new tinhTP("Hà Giang","002"),
                    new tinhTP("Cao Bằng", "004"),
                    new tinhTP("Bắc Kạn", "006"),
                    new tinhTP("Tuyên Quang", "008"),
                    new tinhTP("Lào Cai", "010"),
                    new tinhTP("Điện Biên", "011"),
                    new tinhTP("Lai Châu","012"),
                    new tinhTP("Sơn La","014"),
                    new tinhTP("Yên Bái","015"),
                    new tinhTP("Hòa Bình","017"),
                    new tinhTP("Thái Nguyên","019"),
                    new tinhTP("Lạng Sơn","020"),
                    new tinhTP("Quảng Ninh","022"),
                    new tinhTP("Bắc Giang","024"),
                    new tinhTP("Phú Thọ","025"),
                    new tinhTP("Vĩnh Phúc","026"),
                    new tinhTP("Bắc Ninh","027"),
                    new tinhTP("Hải Dương","030"),
                    new tinhTP("Hải Phòng","031"),
                    new tinhTP("Hưng Yên","033"),
                    new tinhTP("Thái Bình","034"),
                    new tinhTP("Hà Nam","035"),
                    new tinhTP("Nam Định","036"),
                    new tinhTP("Ninh Bình","037"),
                    new tinhTP("Thanh Hóa","038"),
                    new tinhTP("Nghệ An","040"),
                    new tinhTP("Hà Tĩnh","042"),
                    new tinhTP("Quảng Bình","044"),
                    new tinhTP("Quảng Trị","045"),
                    new tinhTP("Thừa Thiên Huế","046"),
                    new tinhTP("Đà Nẵng","048"),
                    new tinhTP("Quảng Nam","049"),
                    new tinhTP("Quảng Ngãi","051"),
                    new tinhTP("Bình Định","052"),
                    new tinhTP("Phú Yên","054"),
                    new tinhTP("Khánh Hòa","056"),
                    new tinhTP("Ninh Thuận","058"),
                    new tinhTP("Bình Thuận","060"),
                    new tinhTP("Kon Tum","062"),
                    new tinhTP("Gia Lai","064"),
                    new tinhTP("Đắk Lắk","066"),
                    new tinhTP("Đắk Nông","067"),
                    new tinhTP("Lâm Đồng","068"),
                    new tinhTP("Bình Phước","070"),
                    new tinhTP("Tây Ninh","072"),
                    new tinhTP("Bình Dương","074"),
                    new tinhTP("Đồng Nai","075"),
                    new tinhTP("Bà Rịa - Vũng Tàu","077"),
                    new tinhTP("Hồ Chí Minh","079"),
                    new tinhTP("Long An","080"),
                    new tinhTP("Tiền Giang","082"),
                    new tinhTP("Bến Tre","083"),
                    new tinhTP("Trà Vinh","084"),
                    new tinhTP("Vĩnh Long","086"),
                    new tinhTP("Đồng Tháp","087"),
                    new tinhTP("An Giang","089"),
                    new tinhTP("Kiên Giang","091"),
                    new tinhTP("Cần Thơ","092"),
                    new tinhTP("Hậu Giang","093"),
                    new tinhTP("Sóc Trăng","094"),
                    new tinhTP("Bạc Liêu","095"),
                    new tinhTP("Cà Mau","096")
            ));

        
    private String tinhTP;
    private String gioiTinh;
    private int namSinh;
    private String soNN;
    
    public infoCCCD(String cccd) {
        this.tinhTP = xuLyTinhTP(cccd.substring(0, 3));
        this.gioiTinh = xuLyGioiTinh(cccd.substring(3,4));
        this.namSinh = xuLyNamSinh(cccd.substring(4,6), cccd.substring(3,4));
        this.soNN = cccd.substring(6);
        
    }
    
    public infoCCCD() {}
    
    public String getTinhTP() {
        return tinhTP;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public int getNamSinh() {
        return namSinh;
    }
    
    public String getSoNgauNhien() {
        return soNN;
    }
    // ================
    
    
    public void getInfo() {
        System.out.println(tinhTP);
        System.out.println(gioiTinh);
        System.out.println(namSinh);
        System.out.println(soNN);
    }
    
    private String xuLyGioiTinh(String s) {
        int gt = Integer.parseInt(s);
        String check = (gt % 2 == 0) ? "Nam" : "Nu";
        return check;
    }
    
    private int xuLyNamSinh(String nam, String s) {
        int ns;
        if (Integer.parseInt(s) % 2 == 0)
            ns = Integer.parseInt(nam) + 100 * (19 + Integer.parseInt(s)/2);
        else
            ns = Integer.parseInt(nam) + 100 * (19 + (Integer.parseInt(s)+1)/2-1);
        
        return ns;
    }
    
    public String xuLyTinhTP(String ma) {
        for (int i = 0; i < dsTinhTP.size(); i++)
            if ((dsTinhTP.get(i).maTinhTP).equals(ma)) 
                return dsTinhTP.get(i).tenTinhTP;
        return "Loi";
    }
    
    
    public String kiemTraTuoiGT() {
        return gioiTinh + " | " + namSinh;
    }
    

}

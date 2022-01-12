/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Lnhutduy
 */
public abstract class NhanVien implements TinhLuong{
    protected String MaNV;
    protected String TenNV;
    public abstract void xuatTTNV();   
    @Override
    public double TinhLuong() {
        throw new UnsupportedOperationException("Not supported yet..."); //To change body of generated methods, choose Tools | Templates.
    }

    public NhanVien(String MaNV, String TenNV) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
    }
    public NhanVien() {
    }
    public void nhapTTNV(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Nhap Ma Nhan Vien: ");
        MaNV=sc.nextLine();
        System.out.println("Nhap Ten Nhan Vien: ");
        TenNV=sc.nextLine();
    }
 
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    @Override
    public String toString() {
        return "NhanVien: " + "MaNV: " + MaNV + ", TenNV: " + TenNV+ " ";
    }

    
    public String ghifile(){
        return MaNV + ';' + TenNV + ';';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Anh Thư
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private double GiaNhap;
    private double GiaBan;
    private int soluong=0;
    // private NhaCungCap ncc;
    Scanner sc = new Scanner(System.in);
    public int getSoluong() {
        return this.soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public SanPham() {
        // ncc = new NhaCungCap();
    }
    public SanPham(String tenSP){
        // ncc = new NhaCungCap();
        this.TenSP = tenSP;
    }
    // public SanPham(String MaSP, String TenSP, double GiaNhap, double GiaBan, int soluong, String mapn, int ngayNhap) {//,String tenNCC
    //     this.MaSP = MaSP;
    //     this.TenSP = TenSP;
    //     this.GiaNhap = GiaNhap;
    //     this.GiaBan = GiaBan;
    //     // ncc = new NhaCungCap(tenNCC, mapn, ngayNhap);
    // }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }
    public double tienLoi(){
        return this.getGiaBan() - this.getGiaNhap(); 
    }
    // public void nhap(){
    //     Scanner sc=new Scanner(System.in);
    //     System.out.println("Nhap ma san pham: ");
    //     MaSP=sc.nextLine();
    //     setMaSP(MaSP);
    //     if(TenSP == null){

    //         System.out.println("Nhap ten san pham: ");
    //         TenSP=sc.nextLine();
    //         setTenSP(TenSP);
    //     }
    //     System.out.println("Nhap gia nhap: ");
    //     GiaNhap=sc.nextDouble();
    //     setGiaNhap(GiaNhap);
    //     System.out.println("Nhap gia ban: ");
    //     GiaBan=sc.nextDouble();
    //     setGiaBan(GiaBan);
    //     System.out.println("nhap vao so luong");
    //     int soluong = sc.nextInt();
    //     while(soluong <= 0){
    //         System.out.println("nhap vao so luong");
    //         soluong = sc.nextInt();
    //     }
    //     setSoluong(soluong);
    //     ncc.nhap();
        
    // }
    public void ban(int daban){
        if(soluong <=0) System.out.println("Sản phẩm hết hàng");
        else{
            this.soluong = this.soluong - daban;
        }
    }

    public void nhapTTSP(){
        System.out.println("Ma San Pham");
        MaSP=sc.nextLine();
        if(TenSP == null){

            System.out.println("Nhap Ten San Pham");
            TenSP=sc.nextLine();
        }
        System.out.println("Nhap gia nhap: ");
         GiaNhap=sc.nextDouble();
         setGiaNhap(GiaNhap);
         System.out.println("Nhap gia ban: ");
        GiaBan=sc.nextDouble();
        setGiaBan(GiaBan);
    }
    public void nhapTTSP_PN(){
        System.out.println("Ma San Pham");
        MaSP=sc.nextLine();
    }
    @Override
    public String toString() {
        return String.format("%20s,%20s,%20.2f,%20.2f,%20d", MaSP, TenSP, GiaNhap, GiaBan, soluong);
    }
    public String toStringGhiFile() {
        return String.format("%s;%s;%.2f;%.2f;%d", MaSP, TenSP, GiaNhap, GiaBan, soluong);
    }    
    public void xuat(){
        System.out.println(toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lnhutduy
 */
public class HoTroKhachHang extends NhanVien implements TinhLuong{
    private String CongViec="HoTroKhachHang";
    private int LuongThang=600;

    @Override
    public double TinhLuong(){
        double Luong= LuongThang;
        return Luong;
    }
    public HoTroKhachHang(String MaNV, String TenNV) {
        super(MaNV, TenNV);
    }

    public HoTroKhachHang() {
    }
    
    
    @Override
    public void xuatTTNV(){
        System.out.println(toString());
    }
    
        @Override
    public String toString() {
        return super.ghifile()  + CongViec +  ';' + TinhLuong();
    }
}

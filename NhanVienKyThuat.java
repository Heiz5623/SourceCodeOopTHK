/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lnhutduy
 */
public class NhanVienKyThuat extends NhanVien implements TinhLuong{
    private String CongViec="Nhan Vien Ky Thuat";
    private int LuongThang=1000;
    @Override
    public double TinhLuong(){
        double Luong = LuongThang;
        return Luong;
    }
    public void xuatTTNV(){
        System.out.println(toString());
    }
    public NhanVienKyThuat(String MaNV, String TenNV) {
        super(MaNV, TenNV);
    }

    public NhanVienKyThuat() {
    }

    


    @Override
    public String toString() {
        return super.ghifile() + CongViec + ';' + TinhLuong();
    }
    

       public String getCongViec() {
        return CongViec;
    }

    public int getLuongThang() {
        return LuongThang;
    }

    public void setLuongThang(int luongThang) {
        this.LuongThang = luongThang;
    }
 
    
    
    

}

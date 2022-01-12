
public class NhanVienBanHang extends NhanVien implements TinhLuong{
    private String CongViec="NhanVienBanHang";
    private int LuongThang=500;
    
    public NhanVienBanHang(String MaNV, String TenNV) {
        super(MaNV, TenNV);
    }
    @Override
    public double TinhLuong(){
        double Luong= LuongThang;
        return Luong;
    }

    public NhanVienBanHang(){
    }   


    @Override
    public void xuatTTNV(){
        System.out.println(toString());
    }
        @Override
    public String toString() {
        return super.ghifile()  + CongViec + ';' + TinhLuong();
    }
        public String getCongViec() {
        return CongViec;
    }
}

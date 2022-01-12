import java.util.Scanner;

public class HoaDon {
    private String ma;
    private int ngayMua;
    private int thoigianBH;
    private KhachHang khachHang;
    private SanPham sanPham;
    public String getMa() {
        return this.ma;
    }
    public HoaDon(){};
    public HoaDon(SanPham sp){
        this.sanPham = sp;
        khachHang = new KhachHang();
    } 
    public void setMa(String ma) {
        this.ma = ma;
    }
    public int getNgayMua() {
        return this.ngayMua;
    }
    public void setNgayMua(int ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getThoigianBH() {
        return this.thoigianBH;
    }

    public void setThoigianBH(int thoigianBH) {
        this.thoigianBH = thoigianBH;
    }
    /* public HoaDon(){
        sanPham = new SanPham();
        khachHang = new KhachHang();
    };   */
    public HoaDon(String ma, int ngayMua, int thoigianBH, String ten, int sdt,String maSP, String tenSP, double GiaNhap, double GiaBan){
        this.ma = ma;
        this.ngayMua = ngayMua;
        this.thoigianBH = thoigianBH;
        khachHang = new KhachHang(ten,sdt);
        
    }
    public void nhap(){
        khachHang.nhap();
        //sanPham.nhapTTSP();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma hoa don");
        String ma = sc.nextLine();
        setMa(ma);
        System.out.println("nhap vao ngay mua");
        int ngayMua = Integer.parseInt(sc.nextLine());
        while(ngayMua <= 0) {
            ngayMua = Integer.parseInt(sc.nextLine());
        }
        setNgayMua(ngayMua);
        System.out.println("nhap vao thoi gian bao hanh");
        int thoigianBH = Integer.parseInt(sc.nextLine());
        while(thoigianBH <=0){
            thoigianBH = Integer.parseInt(sc.nextLine());
        }
        setThoigianBH(thoigianBH);
    }
    @Override
    public String toString() {
        return " ma hoa don " + this.getMa() + " ngay mua hang " + this.getNgayMua() + " thoi gian bao hanh " + this.getThoigianBH() + khachHang.toString() + sanPham.toString();
    }
    public void xuat(){
        System.out.println(this.toString());
    }
    public double tinhTien(){
        return sanPham.tienLoi()* sanPham.getSoluong();
    }
}

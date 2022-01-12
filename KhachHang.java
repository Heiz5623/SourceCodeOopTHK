import java.util.Scanner;

public class KhachHang {
    private String ten;
    private int sdt;

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSdt() {
        return this.sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public KhachHang(){};
    public KhachHang(String ten, int sdt){
        this.ten = ten;
        this.sdt = sdt;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ten khach hang");
        String ten = sc.nextLine();
        setTen(ten);
        System.out.println("nhap vao so dien thoai khach hang");
        int sdt = Integer.parseInt(sc.nextLine());
        setSdt(sdt);
    }
    @Override
    public String toString() {
        return " ten khach hang " + this.getTen() + " sdt " + this.getSdt();
    }
    public void xuat(){
        System.out.println(this.toString());
    }

}

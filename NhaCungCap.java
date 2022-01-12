import java.util.Scanner;

public class NhaCungCap {
    private String tenNCC;

    public String getTenNCC() {
        return this.tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

   
    public NhaCungCap(){
    };
    public NhaCungCap(String tenNCC,String mapn,  int ngayNhap){
        this.tenNCC = tenNCC;
        
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten nha cung cap");
        String tenNCC = sc.nextLine();
        setTenNCC(tenNCC);
        
    }
    @Override
    public String toString() {
        return tenNCC;
    }
    public void xuat(){
        System.out.println(this.toString());
    }

}

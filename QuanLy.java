import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
public class QuanLy {
    private static DanhSachSanPham DSSP = new DanhSachSanPham();    
    public static PhieuNhap[] DSPN= new PhieuNhap[1];
    static int soluongphieunhap=0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DSSP.docFile();
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        DSHD dshd = new DSHD();
        int x;
       
        do{
            System.out.println("1. Quan li san pham");
            System.out.println("2. Quan li nhan vien");
            System.out.println("3. Doanh thu");
            System.out.println("4. Quan li hoa don");
            System.out.println("5. Thoat");
            
            System.out.println("nhap lenh");
            x = sc.nextInt();
            switch(x){
                case 1: 
                    QuanLySanPham();
                break;
                case 2: 
                    int z;
                    do{
                            System.out.println("1. Nhap danh sach nhan vien");
                            System.out.println("2. Xem danh sach nhan vien");
                            System.out.println("3. Them nhan vien");
                            System.out.println("4. Xoa nhan vien");
                            System.out.println("5. Sap xep");
                            System.out.println("6. Tinh tong luong nhan vien");
                            System.out.println("7. Thoat");
                            z = sc.nextInt();
                            switch(z) {
                                case 1:

                                    dsnv.nhapDanhSach();
                                    dsnv.ghifile();
                                    break;
                                case 2:
                                    dsnv.xuatDanhSach();
                                    break;
                                case 3:
                                    dsnv.them();
                                    break;
                                case 4:
                                    dsnv.xoa();;
                                    break;
                                case 5:
                                    dsnv.sapxep();
                                    break;
                                case 6: 
                                    System.out.println(dsnv.TinhTongLuong());
                                    break;
                                default:

                                    break;
                            }
                        } while(z != 7);
                    break;
                case 3: 
                    System.out.println("Loi nhuan ban dien thoai: " + dshd.tongHoaDon());
                    System.out.println("Phai chi: " + dsnv.TinhTongLuong()) ;
                    System.out.println("Loi nhuan tong: " +(dshd.tongHoaDon() - dsnv.TinhTongLuong()));
                    break;
                case 4:
                    Scanner sc1  = new Scanner(System.in);
                    System.out.println("1. Nhap hoa don moi");
                    System.out.println("2. Xem danh sach hoa don");
                    System.out.println("3. Xoa hoa don");
                    System.out.println("4. Thoat");
                    int o = sc.nextInt();
                    switch (o) {
                        case 1:
                        SanPham chk = DSSP.getHead();
                        if(chk == null){
                            System.out.println("Can nhap vao danh sach san pham truoc");
                            break;
                        }
                        System.out.println("Nhap vao Ma san pham");
                        String maSP = sc1.nextLine();   
                        System.out.println("Nhap vao so luong mua");
                        int soluong = sc1.nextInt();
                        SanPham tmp = DSSP.ban(maSP, soluong);
                        if(tmp.getMaSP().equalsIgnoreCase(maSP)){ //kiem tra sanpham vua nhap co ten trung voi tenSP nhap vao khong                            
                            HoaDon hd = new HoaDon(tmp);
                            hd.nhap();
                            dshd.them(hd); 
                        } else{
                            System.out.println("Nhap sai ten san pham");
                        }
                            break;
                        case 2:
                            dshd.xemDS();
                            break;
                        case 3:
                            
                            dshd.xoa();
                            break;
                        default:
                            break;
                    }
                    break;
                
                default: System.out.println("Nhap lai");
                break;
            }
        } while(x != 5); 
    }

    private static void QuanLySanPham() throws IOException {     
        Danhsachphieunhap dspn = new Danhsachphieunhap();
        System.out.println("Quan Ly San Pham");         
        int t=100;
        int i=soluongphieunhap;
        Scanner sc = new Scanner(System.in);
        while(t!=0){
        System.out.println("key:  \n1: Xuat Danh Sach San Pham\n2: Nhap San Pham Vao Kho\n3: Xuat Tat Ca Phieu Nhap \n4: Khoi Tao Danh Sach San Pham \n5: Quan Ly Danh Sach SP \n0: Quay Lai\n");
        t=Integer.parseInt(sc.nextLine());
        switch (t){
                    case 1:
                            DSSP.docFile();
                            DSSP.xuatDSSP();
                        break;
                    case 2:
                            dspn.NhapDSPN();
                            dspn.ghiFile();
                            DSSP.ghiFile();
                            DSSP.docFile();
                            break;
                    case 3:
                            Danhsachphieunhap DSSPt= new Danhsachphieunhap();
                            DSSPt.XuatToanBoCacPhieuNhap();                    
                            break; 
                    case 4:
                        DSSP.KhoiTaoDSSP();
                        DSSP.ghiFile();
                        DSSP.docFile();
                        break;    
                    case 5:
                    int y;
                    do{
                          System.out.println("1. Sua thong tin san pham");
                          System.out.println("2. Xoa san pham trong danh sach");
                          System.out.println("3. Sap xep danh sach san pham theo gia");
                          System.out.println("4. Sap xep danh sach san pham theo ten");
                          System.out.println("5. Tim cac san pham trong khoang gia");
                          System.out.println("6. Thoat");
                           y = Integer.parseInt(sc.nextLine());
                        switch (y) {
                            case 1:
                                DSSP.docFile();
                                DSSP.sua();
                                DSSP.ghiFile();
                                break;
                            case 2:
                                DSSP.docFile();
                                DSSP.xoa();
                                DSSP.ghiFile();
                                break;
                            case 3: 
                                DSSP.docFile();
                                DSSP.sapxepTheoGia();
                                DSSP.ghiFile();
                                break;
                            case 4:
                                DSSP.docFile();
                                DSSP.sapxepTheoTen();
                                DSSP.ghiFile();
                                break;
                            case 5: 
                                DSSP.docFile();
                                System.out.println("Nhap vao gia");
                                int gia = Integer.parseInt(sc.nextLine());
                                DSSP.timTheoGia(gia);
                                break;
                            case 6:
                            break;
                       }
                     } while(y != 6);
                     break;
                   case 0:
                       break;             
                   default:
                       System.out.println("Nhap SAI key!!!");
                       break;
            }
        }
   }
}

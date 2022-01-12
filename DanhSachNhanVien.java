/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 
public class DanhSachNhanVien {
    private NhanVien[] DSNV = new NhanVien[0];
    private int n;
    public void xuatDanhSach(){
        if(n != 0)
        for(int i=0; i< DSNV.length; i++)
            DSNV[i].xuatTTNV();
        else    
        System.out.println("Chua Co Nhan Vien");
    }
    public void nhapDanhSach() throws IOException{
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap So Luong Nhan Vien");
        n=Integer.parseInt(sc.nextLine());
        DSNV = new NhanVien[n];
        for(int i=0; i<DSNV.length; i++)
        {
            System.out.println("Nhap nhan vien thu" + " " + (i+1));
            int mode=0;            
            while(mode<1||mode>3)
            {
            System.out.println("Chon Cong Viec Nhan Vien \nkey: \n1: Nhan Vien Ban Hang \n2: Nhan Vien Ky Thuat\n3: Ho Tro Khach Hang");
                mode=Integer.parseInt(sc.nextLine());
                switch (mode)
                {
                    case 1:
                        DSNV[i]=new NhanVienBanHang();
                        DSNV[i].nhapTTNV();
                                break;
                            
                        
                    case 2:
                        DSNV[i]=new NhanVienKyThuat();
                        DSNV[i].nhapTTNV();
                                break;
                            
                        
                    case 3: 
                        DSNV[i]=new HoTroKhachHang();
                        DSNV[i].nhapTTNV();
                                break;
                            
                        
                    default:
                        System.out.println("Nhap Sai Key!!!");
                        break;
                    
                }
                                
            }
        } 
    }
    public void docfile() throws IOException{
        FileReader fr =  new FileReader("DSNV.txt");
        BufferedReader br = new BufferedReader(fr);
        String line, MaNV, TenNV, CongViec;
        int LuongThang;
        DSNV = Arrays.copyOf(DSNV, 0);
        while(true){

            line = br.readLine();
            if(line == null) break;
            if(line != null){
                DSNV = Arrays.copyOf(DSNV, DSNV.length+1);
            }
            String[] st = line.split(";");
            MaNV = st[0];
            
            TenNV= st[1];
            CongViec = st[2];
            if(CongViec.equalsIgnoreCase("HoTroKhachHang")){
                DSNV[DSNV.length-1] = new HoTroKhachHang(MaNV,TenNV);
            } 
            else if(CongViec.equalsIgnoreCase("NhanVienBanHang")){
                DSNV[DSNV.length-1] = new NhanVienBanHang(MaNV,TenNV);
            } 
            else if(CongViec.equalsIgnoreCase("NhanVienKyThuat")){
                DSNV[DSNV.length-1] = new NhanVienKyThuat(MaNV,TenNV);
            }    
        }
        br.close();
        fr.close();
        System.out.println(DSNV.length);
        if(DSNV.length==0) System.out.println("Danh sach nhan vien rong");
        else{

            for(int i=0; i< DSNV.length;i++){
                DSNV[i].xuatTTNV();
            } 
        } 
        
    }
    public int TinhTongLuong(){
        int S=0;
        for(int i=0; i<DSNV.length; i++)
        {
            S=(int) (S+DSNV[i].TinhLuong());
        }
        return S;
    }
    public void them(){
        NhanVien nv = new NhanVien();
        Scanner sc = new Scanner(System.in);
        int mode=0;            
            while(mode<1||mode>3)
            {
            System.out.println("Chon Cong Viec Nhan Vien \nkey: \n1: Nhan Vien Ban Hang \n2: Nhan Vien Ky Thuat\n3: Ho Tro Khach Hang");
                mode=Integer.parseInt(sc.nextLine());
                switch (mode)
                {
                    case 1:
                        nv=new NhanVienBanHang();
                        nv.nhapTTNV();
                        for(int i=0;i<DSNV.length;i++){
                            if(nv.getTenNV().equalsIgnoreCase(DSNV[i].getTenNV())){
                                System.out.println("Da co nhan vien nay");
                                nv.nhapTTNV();
                            }
                        }
                        break;
                    case 2:
                        nv=new NhanVienKyThuat();
                        nv.nhapTTNV();
                        for(int i=0;i<DSNV.length;i++){
                            if(nv.getTenNV().equalsIgnoreCase(DSNV[i].getTenNV())){
                                System.out.println("Da co nhan vien nay");
                                nv.nhapTTNV();
                            }
                        }
                        break;
                    case 3: 
                        nv=new HoTroKhachHang();
                        nv.nhapTTNV();
                        for(int i=0;i<DSNV.length;i++){
                            if(nv.getTenNV().equalsIgnoreCase(DSNV[i].getTenNV())){
                                System.out.println("Da co nhan vien nay");
                                nv.nhapTTNV();
                            }
                        }
                        break;
                    default:
                        System.out.println("Nhap Sai Key!!!");
                        break;    
                }                  
            }    
        if(DSNV[0] == null){
            DSNV[0] = nv;
            
        } else{
            DSNV = Arrays.copyOf(DSNV, DSNV.length+1);
            
            DSNV[DSNV.length-1] = nv;
            try {
                FileWriter fw =  new FileWriter("DSNV.txt",true);
                BufferedWriter bf = new BufferedWriter(fw);
                bf.write(nv.toString());
                bf.newLine();
                
            } catch (Exception e) {
                System.out.println("loi them sinh vien");
            }
        }
       
    }
    public void xoa(){ 
        if(n == 0) System.out.println("danh sach rong");
        else{
            int c,i;
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhap Ma Nhan Vien: ");
            String ten = sc.nextLine();
            for(c = i=0;i<n;i++){
                if(!(DSNV[i].getMaNV().equalsIgnoreCase(ten))) {
                    DSNV[c] = DSNV[i];
                    c++;
                }
            }
            n = c;
            xuatDanhSach();
        }
    }
    public void swap(NhanVien[] DSNV, int i, int j){
        NhanVien t = new NhanVien();
        t=DSNV[i];
        DSNV[i]=DSNV[j];
        DSNV[j]=t;
    }
    void sapxep()
    {
        Scanner sc = new Scanner(System.in);
        int n=DSNV.length;
        System.out.println("1: A-Z \n 2: Z-A \n Khac: Thoat");
        while(true){
                int mode =sc.nextInt();
            if(mode==1){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSNV[j].getTenNV().compareTo( DSNV[j+1].getTenNV()) > 1)
                        swap(DSNV, j, j+1);   
                }
            }
            xuatDanhSach();
        }           
            else if(mode==2){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSNV[j].getTenNV().compareTo( DSNV[j+1].getTenNV()) < 1)
                        swap(DSNV, j, j+1);  
                }
            }
            xuatDanhSach();
        }            
            else
            {
                System.out.println("Danh Sach Mac Dinh: ");
                xuatDanhSach();
                break;
            }
            System.out.println("1: A-Z - 2: Z-A - Khac: Thoat");
        }
    }
    public void ghifile(){
        try {
            FileWriter fw =  new FileWriter("DSNV.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            
            for(int i=0;i<DSNV.length;i++){
                bw.write(DSNV[i].toString());
                bw.newLine();
            } 
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("loi ghi file");
        }
    }
   
    
  
}

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


/**
 *
 * @author 
 */
public class DanhSachSanPham {
    private int n;
    // private SanPham[] DanhSachSanPham;
    static SanPham[] DSSP = new SanPham[0];
    private final Scanner sc=new Scanner(System.in);

    public DanhSachSanPham() {
        // n=0;
        // DSSP=null;
    }

    public DanhSachSanPham(int n, SanPham[] DanhSachSanPham) {
        this.n = n;
        this.DSSP = DanhSachSanPham;
    }



    public boolean KhoiTaoDSSP(){
        if(DSSP.length>0)
        {
            String mode;
            while(true)
            {
                System.out.println("Da co danh sach san pham Muon Khoi Tao Lai?(Y/N) ");
                mode=sc.nextLine();
                if(mode.equals("Y")||mode.equals("y"))
                break;
                else
                if(mode.equals("N")||mode.equals("n"))
                {
                    return false;
                }
                System.out.println("Sai Key!!");
            }
        }

        System.out.println("Nhap So Luong San Pham: ");
        n=Integer.parseInt(sc.nextLine());
        DSSP=new SanPham[n];
        for(int i=0; i<n; i++)
        {
            DSSP[i]=new SanPham();
            DSSP[i].nhapTTSP();
        }
        return false;
    };
    public void xuatDSSP(){
        System.out.println("Danh Sach San Pham");
        System.out.println(toString());
    };
    @Override
    public String toString() {
        String s="";
        for(int i=0; i<DSSP.length; i++)
            s=s+DSSP[i].toString()+'\n';
        return s;
    }

    public String toString_GhiFile() {
        String s="";
        for(int i=0; i<DSSP.length; i++)
            s=s+DSSP[i].toStringGhiFile()+'\n';
        return s;
        
    }
    public void ghiFile() throws IOException{
        try {
        FileWriter fw = new FileWriter("DanhSachSanPham.txt");
        BufferedWriter bf = new BufferedWriter(fw);
            bf.write(toString_GhiFile());
        bf.close();
        fw.close();
    } catch (Exception e) {
        System.out.println("loi ghi file");
    }
   }
   public void docFile() throws IOException{
            FileReader fr = new FileReader("DanhSachSanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            String t;
            int i=0;
            String []IF;
            DSSP= Arrays.copyOf(DSSP, 0);
            while(true)
            {
                t=br.readLine();
                if(t==null)
                break;
                if(t!=null)
                    DSSP= Arrays.copyOf(DSSP, DSSP.length+1);
                IF=t.split(";");
                DSSP[i]=new SanPham();
                DSSP[i].setMaSP(IF[0]);
                DSSP[i].setTenSP(IF[1]);    
                DSSP[i].setGiaNhap(Double.parseDouble(IF[2]));
                DSSP[i].setGiaBan(Double.parseDouble(IF[3]));
                DSSP[i].setSoluong(Integer.parseInt(IF[4]));                         
                i++;
            }
            br.close();
            fr.close();
   }
    //Thêm Sản Phẩm Mới
    public void them(){
        SanPham sp = new SanPham();
        sp.nhapTTSP();
        DSSP[n] = sp;
        n++;
    }
    public void swap(SanPham[] DSSP, int i, int j )
    {
        SanPham t = new SanPham();
        t=DSSP[i];
        DSSP[i]=DSSP[j];
        DSSP[j]=t;

    } 
    void sapxepTheoTen()
    {
        n=DSSP.length;
        System.out.println("1: A-Z \n 2: Z-A \n Khac: Thoat");
        while(true){
                int mode =sc.nextInt();
            if(mode==1){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSSP[j].getTenSP().compareTo( DSSP[j+1].getTenSP()) > 1)
                        swap(DSSP, j, j+1);   
                }
            }
            xuatDSSP();
            }
            else if(mode==2){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSSP[j].getTenSP().compareTo( DSSP[j+1].getTenSP()) < 1)
                        swap(DSSP, j, j+1);   
                }
            }
            xuatDSSP();
            }            
            else
            {
                System.out.println("Da Luu Danh Sach: ");
                break;
            }
            System.out.println("1: A-Z - 2: Z-A - Khac: Thoat");
        }
    }
    void sapxepTheoGia()
    {
        n=DSSP.length;
        System.out.println("1: Tang Dan \n 2: Giam Dan \n Khac: Thoat");
        while(true){
                int mode =sc.nextInt();
            if(mode==1){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSSP[j].getGiaBan()>DSSP[j+1].getGiaBan())
                        swap(DSSP, j, j+1);   
                }
            }
            xuatDSSP();
        }           
            else if(mode==2){
            for (int i = 0; i < n-1; i++){    
                for (int j = 0; j < n-i-1; j++){
                    if (DSSP[j].getGiaBan() < DSSP[j+1].getGiaBan())
                        swap(DSSP, j, j+1);   
                }
            }
            xuatDSSP();
        }            
            else
            {
                System.out.println("Danh Sach Mac Dinh: ");
                xuatDSSP();
                break;
            }
            System.out.println("1: Tang Dan - 2: Giam Dan - Khac: Thoat");
        }
    }


    public void timTheoGia(int gia){
        n=DSSP.length;
        for(int i=0;i<n;i++){
            if(DSSP[i].getGiaBan() < gia){
                DSSP[i].xuat();
            }
        }
    }
    public SanPham ban(String MaSP, int daban){
        n=DSSP.length;
        int i;
        if(n == 0){
            SanPham sp = new SanPham(MaSP);
            sp.nhapTTSP();
            n++;
            return sp;
        }

            for(i=0;i<n;i++){
                if(DSSP[i].getMaSP().equalsIgnoreCase(MaSP)){
                    DSSP[i].ban(daban);
                    break;
                }
            }        
        return DSSP[i];
        
    }
    public void xoa(){ 
        n=DSSP.length;
        if(n == 0) System.out.println("danh sach rong");
        else{
            System.out.println("Nhap Vao Ma San Pham Muon Xoa: ");
            String MaSPDel = sc.nextLine();
            for(int i=0; i<n; i++)
            {
                if(DSSP[i].getMaSP().equals(MaSPDel))
                {
                    for(int j=i; j<n-1; j++)
                        DSSP[j]=DSSP[j+1];
                    break;
                }
            }    
            DSSP = Arrays.copyOf(DSSP, DSSP.length-1);
            xuatDSSP();
        }
    }

    public void sua(){
        n=DSSP.length;
        if(n == 0) System.out.println("danh sach rong");
        else{
            
            System.out.println("Nhap vao ma san pham");
            String maSP = sc.nextLine();
            for(int i=0;i<n;i++){
                if(DSSP[i].getMaSP().equalsIgnoreCase(maSP)) {
                    int o;
                    do{
                        System.out.println("1. Sua ten");
                        System.out.println("2. Sua gia ban");
                        System.out.println("3. Sua gia nhap");
                        System.out.println("4. Thoat");
                        o = Integer.parseInt(sc.nextLine());
                        switch (o) {
                            case 1:
                                System.out.println("Nhap ten moi");
                                String newTen = sc.nextLine();
                                DSSP[i].setTenSP(newTen);
                                break;
                            case 2:
                                System.out.println("Nhap gia ban moi");
                                double newGia = Double.parseDouble(sc.nextLine());
                                DSSP[i].setGiaBan(newGia);
                                break;
                            case 3: 
                                System.out.println("Nhap vao gia nhap moi");
                                double newGiaNhap =Double.parseDouble(sc.nextLine());
                                DSSP[i].setGiaBan(newGiaNhap);
                                break;
                            default:
                                break;
                        }
                    } while(o != 4);
                }
            }      
            
            xuatDSSP();
        }
    }


    public SanPham getHead(){
        return DSSP[0];
    }




    public int getN() {
        return DSSP.length;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void setN()
    {
        System.out.println("Nhap vao so luong san pham:");
        n=Integer.parseInt(sc.nextLine());
    }

    public SanPham[] getDanhSachSanPham() {
        return DSSP;
    }
}
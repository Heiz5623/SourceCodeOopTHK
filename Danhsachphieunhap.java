import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Danhsachphieunhap{
    private int n;
    private PhieuNhap[] DSPN;
    DanhSachSanPham DSSP = new DanhSachSanPham();

    public Danhsachphieunhap() {
    }
    public Danhsachphieunhap(PhieuNhap[] dSPN) {
        DSPN = dSPN;
    }
    
    public void NhapDSPN(){
        Scanner sc= new Scanner(System.in);
        if(DSSP.getN()<1){
            System.out.println("Chua co san pham trong danh sach kinh doanh");
        }
        else{
            System.out.println("Nhap so luong phieu nhap");
            n=Integer.parseInt(sc.nextLine());
            DSPN= new PhieuNhap[n];
            
            for(int i=0 ;i<n; i++)
            {       
                while(true)
                {
                    DSPN[i]=new PhieuNhap();
                    System.out.println("Nhap Ma Phieu Nhap");
                    String t=sc.nextLine();
                    DSPN[i].setMaPN(t);
                    if(docFileCheckMPN(t)==1)
                    System.out.println("Phieu Nhap Da Ton Tai!! Nhap Lai");  
                    else
                    break;                  
                }
                DSPN[i].taoPhieu();
            }        
            }
        }
    public int docFileCheckMPN(String MaPNt) {
        FileReader fr;
            try {
                fr = new FileReader("DanhSachPhieuNhap.txt");
                BufferedReader br = new BufferedReader(fr);
                String t; 
                int i=0;
                PhieuNhap [] DSPNcheck= new PhieuNhap[1];
                DSPNcheck =new PhieuNhap[1];
                while(true)
                {
                    DSPNcheck=Arrays.copyOf(DSPNcheck, DSPNcheck.length+1);
                    DSPNcheck[i]=new PhieuNhap();
                    t=br.readLine();
                    if(t==null)
                    break;
                    int slsp=0;                
                    DSPNcheck[i].setMaPN(t);
                    if(t.equals(MaPNt))
                    {
                        br.close();
                        fr.close();
                        return 1;
                    }
                    slsp=Integer.parseInt(br.readLine());
                    SanPham[] DSSPtemp = new SanPham[slsp];
                    for(int j=0; j<slsp; j++)
                    {
                        DSSPtemp[j]=new SanPham();
                        t=br.readLine(); 
                    }
                    i++;
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("erro: Khong Truy Cap Duoc Danh Sach Phieu Nhap ");
            } catch (IOException e) {
                System.out.println("erro: Khong Truy Cap Duoc Danh Sach Phieu Nhap ");
            }
            return 0;
        } 
        
    public void XuatToanBoCacPhieuNhap(){
        FileReader fr;
        try {
            fr = new FileReader("DanhSachPhieuNhap.txt");
            BufferedReader br = new BufferedReader(fr);
            String t; 
            int i=0;
            DSPN =new PhieuNhap[1];
            while(true)
            {
                DSPN=Arrays.copyOf(DSPN, DSPN.length+1);
                DSPN[i]=new PhieuNhap();
                t=br.readLine();
                if(t==null)
                break;
                int slsp=0;                
                DSPN[i].setMaPN(t);
                slsp=Integer.parseInt(br.readLine());
                SanPham[] DSSPtemp = new SanPham[slsp];
                System.out.println("MPN: "+DSPN[i].getMaPN());
                System.out.println("So Luong San Pham: "+slsp);
                System.out.println("Danh Sach San Pham:");
                for(int j=0; j<slsp; j++)
                {
                    
                    DSSPtemp[j]=new SanPham();
                    t=br.readLine();   
                    String []s=t.split(";");                    
                    DSSPtemp[j].setMaSP(s[0]);
                    System.out.print(s[0]+"; ");
                    DSSPtemp[j].setTenSP(s[1]);
                    System.out.print(s[1]+"; ");
                    DSSPtemp[j].setGiaNhap(Double.parseDouble(s[2]));
                    System.out.print(s[2]+"; ");
                    DSSPtemp[j].setGiaBan(Double.parseDouble(s[3]));
                    System.out.print(s[3]+"; ");
                    DSSPtemp[j].setSoluong(Integer.parseInt(s[4]));
                    System.out.print(s[4]+"");
                    System.out.println();
                }
                   
                // System.out.println("soluongSPPN: "+DSPN[i].getDanhSachSanPham());
                System.out.println();
                DSPN[i].setDSSP_PN(DSSPtemp);
                i++;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("erro: Khong Truy Cap Duoc Danh Sach Phieu Nhap ");
        } catch (IOException e) {
            System.out.println("erro: Khong Truy Cap Duoc Danh Sach Phieu Nhap ");
        }
        
    }
    public void ghiFile() throws IOException{
        System.out.println("Dang Ghi File: ");
                FileWriter fw =  new FileWriter("DanhSachPhieuNhap.txt",true);
                BufferedWriter bf = new BufferedWriter(fw);                
                for(int i=0; i<DSPN.length; i++)
                {
                    bf.write(DSPN[i].toString());
                    // SanPham[] dssp = DSPN[i].getDSSP_PN();                    
                    // bf.write(dssp.toString());
                    // bf.newLine();      
                }   
                bf.close();
                fw.close();         
            }
        
    public void xemDS(){
        for(int i=0;i<DSPN.length;i++){
            DSPN[i].xuatPhieu();
        }
    }

}

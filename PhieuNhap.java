/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Lnhutduy
 */
public class PhieuNhap extends DanhSachSanPham{
    private String MaPN;
    private SanPham[] DSSP_PN;
    public PhieuNhap(){};
    int n;
    public void taoPhieu(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Nhap Danh Sach San Pham");
        System.out.println("Nhap So Luong San Pham Phieu Nhap: ");
        n=Integer.parseInt(sc.nextLine());
        DSSP_PN=new SanPham[n];
        String mode;
        for(int i=0; i<n; i++)
        {
            System.out.println("nhap san pham thu " + (i+1));
            DSSP_PN[i]= new SanPham();
            DSSP_PN[i].nhapTTSP_PN();
            for(int j=0; j<DSSP.length; j++)
            {
                if(DSSP_PN[i].getMaSP().equals(DSSP[j].getMaSP()))
                {
                    System.out.println("Nhap So luong: ");
                    int t=Integer.parseInt(sc.nextLine());
                    DSSP_PN[i].setSoluong(t);
                    DSSP[j].setSoluong(DSSP[j].getSoluong()+t);
                    DSSP_PN[i].setTenSP(DSSP[j].getTenSP());
                    DSSP_PN[i].setGiaNhap(DSSP[j].getGiaNhap());
                    DSSP_PN[i].setGiaBan(DSSP[j].getGiaBan());                  
                    break;
                }
                if(j==(DSSP.length-1))
                {
                    System.out.println("San Pham Nay Cua Hang Khong Kinh Doanh");
                    System.out.println("Ban Con Muon Them San Pham Vao Kinh Doanh?(Y/N)");
                    while(true)
                    {   
                        mode = sc.nextLine();
                        if(mode.equals("Y") || mode.equals("y"))
                        {
                            int len_old=(DSSP.length);
                            DSSP=Arrays.copyOf(DSSP, DSSP.length+1);
                            DSSP[len_old]=new SanPham();
                            System.out.println("Xac nhan lai thong tin cho san pham can them: ");
                            DSSP[len_old].nhapTTSP();
                            System.out.println("Nhap So luong: ");
                            int t=Integer.parseInt(sc.nextLine());
                            DSSP_PN[i].setSoluong(t);
                            DSSP[len_old].setSoluong(DSSP[len_old].getSoluong()+t);
                            DSSP_PN[i].setTenSP(DSSP[len_old].getTenSP());
                            DSSP_PN[i].setGiaNhap(DSSP[len_old].getGiaNhap());
                            DSSP_PN[i].setGiaBan(DSSP[len_old].getGiaBan()); 
                            // System.out.println("Dang Trong Phieu Nhap: "+DSSP[i].toString());
                            j++;                              
                            break;
                        }           
                        if(mode.equals("X") || mode.equals("x"))   
                        break;      
                    else
                    System.out.println("(Y/N)?");
                    }
                }
            }
        }
        
    }
    
    public void xuatPhieu(){
        System.out.println(String.format("%s",toString_DSSP_PN()));
    }
    public String toString_DSSP_PN(){
        String s="";
        for(int i=0; i<DSSP_PN.length; i++)
            s=s+DSSP_PN[i].toStringGhiFile()+'\n';
        return s;
    }
    @Override
    public String toString() {
        return String.format("%s\n%d\n%s", MaPN,DSSP_PN.length,toString_DSSP_PN());
    }
    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }
    public SanPham[] getDSSP_PN() {
        return DSSP_PN;
    }

    public void setDSSP_PN(SanPham[] DSSP_PN) {
        this.DSSP_PN = DSSP_PN;
    }
}




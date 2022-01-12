import java.util.Scanner;

public class DSHD {
    private int n = 0;
    Scanner sc = new Scanner(System.in);        
    private HoaDon[] ds = new HoaDon[100];
        public void nhapDS(){
            
            System.out.println("nhap vao so hoa don ");
            int soHoaDon = sc.nextInt();
            ds = new HoaDon[soHoaDon]; 
            for(int i=0;i<soHoaDon;i++){
                ds[i] = new HoaDon();
                ds[i].nhap();
            }
        }   
        public void xemDS(){
            for(int i=0;i<n;i++){
                ds[i].xuat();
            }
        }
        public void them(HoaDon hd){ 
            ds[n] = hd;
            n++;
        }
        public double tongHoaDon(){
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += ds[i].tinhTien();
            }
            return sum;
        }
        public void xoa(){ 
            if(n == 0) System.out.println("danh sach rong");
            else{
                int c,i;
                System.out.println("Nhap vao ma hoa don");
                String MaHD = sc.nextLine();
                for(c = i=0;i<n;i++){
                    if(!(ds[i].getMa().equalsIgnoreCase(MaHD))) {
                        ds[c] = ds[i];
                        c++;
                    }
                }      
                n = c;
                xemDS();
            }
        }
    
}


import java.util.Scanner;


public  class HocPhan {
    protected int MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    
    public HocPhan(int MaHocPhan, String TenHocPhan, int TinChi){
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
    }

    public int getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(int MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }

    public String getTenHocPhan() {
        return TenHocPhan;
    }

    public void setTenHocPhan(String TenHocPhan) {
        this.TenHocPhan = TenHocPhan;
    }

    public int getTinChi() {
        return TinChi;
    }

    public void setTinChi(int TinChi) {
        this.TinChi = TinChi;
    }

    public void capNhat() {
       Scanner scan = new Scanner(System.in);
       int n;
       do{
           System.out.println("vui lòng chọn mục cần chỉnh sữa");
           System.out.println("1. MaHocPhan \n 2.TenHocPhan \n 3.TinChi\4. Thoat" );
           System.out.println("chọn: ");
           n = Integer.parseInt(scan.nextLine());
           switch(n){
               case 1:
                   System.out.println("Nhập Mã Học Phần mới: ");
                   MaHocPhan = Integer.parseInt(scan.nextLine());
                   break;
                   
               case 2:
                   System.out.println("Nhập Tên Học Phần mới: ");
                   TenHocPhan = scan.nextLine();
                   break;
                   
               case 3:
                   System.out.println("Nhập số Tín Chỉ mới: ");
                   TinChi = Integer.parseInt(scan.nextLine());
                   break;
           }
       }while (n!=4);
    }    
  }
    
    
    
   


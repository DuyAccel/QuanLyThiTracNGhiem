
import java.util.Scanner;


public  class HocPhan {
    protected int MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    protected int SoCau;
    
    public HocPhan(int MaHocPhan, String TenHocPhan, int TinChi, int SoCauHoi){
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
        SoCau = SoCauHoi;
    }

    public int getSoCau() {
        return SoCau;
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
           System.out.println("Vui long chon muc chan chinh sua");
           System.out.println("1. MaHocPhan \n 2.TenHocPhan \n 3.TinChi\n4. So Cau Hoi\n5. Thoat" );
           System.out.println("Chon: ");
           n = Integer.parseInt(scan.nextLine());
           switch(n){
               case 1:
                   System.out.println("Nhap Ma Hoc Phan moi: ");
                   MaHocPhan = Integer.parseInt(scan.nextLine());
                   break;
                   
               case 2:
                   System.out.println("Nhap Ten Hoc Phan moi: ");
                   TenHocPhan = scan.nextLine();
                   break;
                   
               case 3:
                   System.out.println("Nhap so Tin Chi moi: ");
                   TinChi = Integer.parseInt(scan.nextLine());
                   break;
                case 4:
                   System.out.println("Nhap so Cau Hoi: ");
                   SoCau = Integer.parseInt(scan.nextLine());
                   break;
                default:
                    System.out.println("Khong hop le!!!");
                    break;
           }
       }while (n!=4);
    }    
  }
    
    
    
   


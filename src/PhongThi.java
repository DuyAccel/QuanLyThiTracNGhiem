
import java.util.Scanner;


public class PhongThi {
    private int MaPhong;
    private String TenFileSinhVien;
    private String TenFileGiamThi;
    private String TenFileBienBan;
    private DSGiamThi GiamThi = new DSGiamThi();
    private DSSinhVien SinhVien = new DSSinhVien();
    private BienBanThi BienBan = new BienBanThi();
            
       public PhongThi(int MaPhong, String TenFileSinhVien, String TenFileGiamThi, String TenFileBienBan){
            this.MaPhong = MaPhong;
            this.TenFileGiamThi = TenFileGiamThi;
            this.TenFileSinhVien = TenFileSinhVien;
            this.TenFileBienBan = TenFileBienBan;
            GiamThi.docFile(this.TenFileGiamThi +".txt");
            SinhVien.docFile(this.TenFileSinhVien +".txt");
            BienBan.docFile(this.TenFileBienBan +".txt");
        }
        public DSGiamThi getGiamThi() {
            return GiamThi;
        }

        public DSSinhVien getSinhVien() {
            return SinhVien;
        }
        
        public BienBanThi getBienBan() {
            return BienBan;
        }
        
        public int getMaPhong() {
            return MaPhong;
        }

        public String getTenFileSinhVien() {
            return TenFileSinhVien;
        }

        public String getTenFileGiamThi() {
            return TenFileGiamThi;
        }

        public String getTenFileBienBan(){
            return TenFileBienBan;
        }

        public void capNhat() {
       Scanner scan = new Scanner(System.in);
       int n;
       do{
           System.out.println("vui lòng chọn mục cần chỉnh sữa");
           System.out.println("1. MaHocPhan \n2.Ten File Giam Thi \n3.Ten File Sinh Vien \n4. Ten File Bien Ban" );
           System.out.println("chọn: ");
           n = scan.nextInt();
           switch(n){
                case 1:
                   System.out.println("Nhập Ma Phong moi: ");
                   MaPhong = Integer.parseInt(scan.nextLine());
                   break;    
                case 2:
                   System.out.println("Nhap ten File Giam Thi moi: ");
                   TenFileGiamThi = scan.nextLine();
                   break; 
                case 3:
                   System.out.println("Nhap Ten File Sinh Vien moi: ");
                   TenFileSinhVien = scan.nextLine();
                   break; 
                case 4:
                    System.out.println("Nhap Ten File Bien Ban moi: ");
                    TenFileBienBan = scan.nextLine();
           }
       }while (n!=4);
    }    
    public void xuatThongTin(){
        System.out.println("Ma Phong: " + MaPhong);
        BienBan.xuatBienBan();
        System.out.println();
        System.out.println("Danh Sach Sinh Vien:");
        SinhVien.xuatDS();
        System.out.println();
        System.out.println("Danh Sach Giam thi:");
        GiamThi.xuatDS();
    }

}

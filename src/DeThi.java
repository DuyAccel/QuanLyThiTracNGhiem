
import java.util.Scanner;
import java.util.Random;

public class DeThi extends HocPhan implements ChinhSua{
    protected int MaDe;
    protected ThoiGian NgayThi;                       
    protected  int ThoiGianLam;
    protected int SoCau;
    protected BoCauHoi De;

    public DeThi(int MaHocPhan, String TenHocPhan, int TinChi, int MaDe,int SoCau, String NgayThi, int ThoiGianLam, BoCauHoi boCauHoi) {
        super(MaHocPhan, TenHocPhan, TinChi);
        this.MaDe = MaDe;
        this.SoCau = SoCau;
        this.NgayThi = new ThoiGian(NgayThi);
        this.ThoiGianLam = ThoiGianLam;
        De.ch = new CauHoi[SoCau];
        taoDeThi(boCauHoi);
    }

    private void taoDeThi(BoCauHoi bch){
        Random rand = new Random();
        boolean[] DanhDau = new boolean [bch.getN()];
        int Gen, i = 0;
        while (i < SoCau){
            Gen = rand.nextInt(bch.getN());
            if (DanhDau[Gen]){
                DanhDau[Gen] = false;
                De.ch[i] = bch.ch[Gen];
                i++;
            }
        }
    }


    public int getMaDe() {
        return MaDe;
    }

    public void setMaDe(int MaDe) {
        this.MaDe = MaDe;
    }

    public ThoiGian getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(ThoiGian NgayThi) {
        this.NgayThi = NgayThi;
    }

    public int getThoiGianLam() {
        return ThoiGianLam;
    }

    public void setThoiGianLam(int ThoiGianLam) {
        this.ThoiGianLam = ThoiGianLam;
    }

    @Override
    public void chinhSua() {
    Scanner scan = new Scanner(System.in);
       int n;
       do{
           System.out.println("vui lòng chọn mục cần chỉnh sữa");
           System.out.println("1.NgayThi\n 2.MaDeThi\n 3.ThoiGianLam\n 4.TenHocPhan\n 5.MaHocPhan\n" );
           System.out.println("chon: ");
           n = scan.nextInt();
           switch(n){
               case 1 ->{
                   System.out.println("Nhap ngay thi : ");
                   NgayThi = new ThoiGian(scan.nextLine());
                   break;
               }  
              case 2 -> {
                   System.out.println("Nhap Ma De : ");
                   MaDe = Integer.parseInt(scan.nextLine());
                   break;
               }
               case 3 -> {
                   System.out.println("Nhap Thoi Gian Lam : ");
                   ThoiGianLam = scan.nextInt();
                   break;
               }
               case 4 -> {
                   System.out.println("Nhap ten hoc phan : ");
                   TenHocPhan = scan.next();
                   break;
               }
               case 5 -> {
                   System.out.println("Nhap ma hoc phan : ");
                   MaHocPhan = scan.nextInt();
                   break;
                }
               default -> System.out.print("Lua chon khong hop le!");
           }
        }while (n!=6);
        }

    @Override
    public void nhap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xuat() {
        System.out.println("Ngay thi : " + NgayThi);
        System.out.println("Ma De : " +MaDe);
        System.out.println("Thoi Gian Lam : " + ThoiGianLam);
        System.out.println("Ten hoc phan : " + TenHocPhan);
        System.out.println("Ma hoc phan : " + MaHocPhan);
    }
}


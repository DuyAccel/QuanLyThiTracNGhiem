import java.util.Scanner;
public class SinhVien extends ConNguoi{
    private String Lop;
    private boolean CamThi;
    SinhVien(){}
    SinhVien(String Ten, int MaSo, String Lop, String NgaySinh, boolean GioiTinh, boolean CamThi){
        super(Ten, MaSo, NgaySinh, GioiTinh);
        this.Lop = Lop;
        this.CamThi = CamThi;
    }
    public String getLop() {
        return Lop;
    }
    public boolean getCamthi() {
        return CamThi;
    }
    public String getStringCamThi(){
        if (CamThi)
            return "Co";
        return "Khong";
    }
    public void xuatThongTin(){
        System.out.println("Ma So Sinh Vien: " + MaSo);
        System.out.println("Ten: " + Ten);
        System.out.println("Gioi Tinh:" + getNgaySinh() + "/tNgay Sinh: " + getNgaySinh());
        System.out.println();
    }
    @Override
    public void capNhat() {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Chon muc can chinh sua:");
            System.out.println("1. Ten\n2. Maso\n3. Lop\n4. NgaySinh\n5. CamThi\n6. Gioi Tinh\n7. Thoat");
            System.out.print("Chon: ");
            n = scan.nextInt();
            switch (n){
                case 1:
                    System.out.print("Nhap Ten moi: ");
                    Ten = scan.nextLine();
                    break;
                case 2:
                    do{
                        System.out.print("Nhap Maso moi: ");
                        MaSo = Integer.parseInt(scan.nextLine());
                    }   while(MaSo < 0);
                    break;
                case 3:
                    System.out.print("Nhap Lop moi: ");
                    Lop = scan.nextLine();
                    break;
                case 4:
                    System.out.print("Nhap Ngay sinh moi: ");
                    NgaySinh = new ThoiGian(scan.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap Gioi Tinh moi: ");
                    GioiTinh = Boolean.parseBoolean(scan.nextLine());
                case 6:
                    System.out.print("Nhap trang thai CamThi moi: ");
                    CamThi = Boolean.parseBoolean(scan.nextLine());
                    break;
                default:
                    System.out.print("Lua chon khong hop le!");
            }
        }while (n!= 7);
    }
}

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
        System.out.println("Gioi Tinh:" + getStringGioiTinh() + "\tNgay Sinh: " + getNgaySinh());
        System.out.println();
    }
    @Override
    public void capNhat(Scanner scan) {
      
        super.capNhat(scan);
        
        System.out.print("Nhap Lop moi: ");
        Lop = scan.nextLine();

        System.out.print("Nhap trang thai CamThi moi: ");
        if (scan.nextLine().equalsIgnoreCase("co"))
            CamThi = true;
        else
            CamThi = false;

    }

    @Override
    public String DanhGia(int Loi) {
        if (Loi < 0) 
            return "Khong Xac Dinh";

        switch (Loi){
            case 0:
                    return "Tot";
            case 1:
            case 2:
                    return "Trung Binh";
            default:
                    return "Kem";
        }
    }
}

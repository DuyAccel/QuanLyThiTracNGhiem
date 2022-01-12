import java.util.Scanner;
public class GiamThi extends ConNguoi{
    private String HocVi;
    private int TongLoi = 0;
    GiamThi(){}
    GiamThi(String Ten, int MaSo, String  Hocvi, String NgaySinh, boolean GioiTinh){
        super(Ten, MaSo, NgaySinh, GioiTinh);
        this.HocVi = Hocvi;
    }
    public String getHocVi() {
        return HocVi;
    }
    @Override
    public void capNhat(Scanner scan){

        super.capNhat(scan);
        
        System.out.print("Nhap HocVi moi: ");
        HocVi = scan.nextLine();
    }

    @Override
    public String DanhGia(int Loi){
        TongLoi += Loi;
        if (TongLoi < 0)
            return "Khong Xac Dinh";
        if (TongLoi == 0)
            return "Tot";
        if (TongLoi < 10)
            return "Trung binh";
        return "Kem";
    }
}

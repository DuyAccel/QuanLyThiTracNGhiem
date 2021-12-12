import java.util.Scanner;

public class Thi {
    private SinhVien sv;
    private DeThi deThi;
    private DapAn dapAn;
    private int Dem = 0;
    Thi(SinhVien SinhVien, BoCauHoi BoCauHoi, HocPhan HocPhan, String NgayThi, int ThoiGianLam){
        sv = SinhVien;
        deThi = new DeThi(HocPhan, BoCauHoi, NgayThi, ThoiGianLam);
        dapAn = new DapAn(HocPhan, deThi);
    }
    
    public void menuThi(int index, Scanner scan){
        String DAn = dapAn.getDapAn()[index];
        deThi.inCauHoi(index);
        if (DAn.equalsIgnoreCase(scan.nextLine())){
            Dem++;
        }
    }
    public double tinhDiem(){
        return 10.0*Dem/deThi.getSoCau();
    }
    public SinhVien getSinhVien() {
        return sv;
    }
}

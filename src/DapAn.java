public class DapAn extends HocPhan {
    private int MaDe;
    private String[] DapAn;
    DapAn(HocPhan hocPhan, DeThi dethi){
        super(hocPhan.MaHocPhan, hocPhan.TenHocPhan, hocPhan.TinChi, hocPhan.SoCau);
        MaDe = dethi.getMaDe();
        DapAn = dethi.layDapAn();
    }
    public String[] getDapAn() {
        return DapAn;
    }
    public int getMaDe() {
        return MaDe;
    }
}

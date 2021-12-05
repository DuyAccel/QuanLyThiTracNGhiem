
public abstract class ConNguoi {
    protected String Ten;
    protected int MaSo;
    protected ThoiGian NgaySinh;
    ConNguoi(){}
    ConNguoi(String Ten, int MaSo, String NgaySinh){
        this.Ten = Ten;
        this.MaSo = MaSo;
        this.NgaySinh = new ThoiGian(NgaySinh);
    }
    public int getMaSo() {
        return MaSo;
    }
    public String getTen() {
        return Ten;
    }
    public String getNgaySinh() {
        return String.valueOf(NgaySinh.Ngay) + "/" + String.valueOf(NgaySinh.Thang)
                + "/" + String.valueOf(NgaySinh.Nam);
    }
    public abstract void capNhat();
}

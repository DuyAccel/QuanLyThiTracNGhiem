
public abstract class ConNguoi {
    protected String Ten;
    protected int MaSo;
    protected ThoiGian NgaySinh;
    protected boolean GioiTinh;
    ConNguoi(){}
    ConNguoi(String Ten, int MaSo, String NgaySinh, boolean GioiTinh){
        this.Ten = Ten;
        this.MaSo = MaSo;
        this.NgaySinh = new ThoiGian(NgaySinh);
        this.GioiTinh = GioiTinh;
    }
    public boolean getGioiTinh(){
        return GioiTinh;
    }
    public String getStringGioiTinh(){
        if (GioiTinh)
            return "Nam";
        return "Nu";
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

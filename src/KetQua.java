import java.io.*;
public class KetQua {
    private PhongThi phong;
    private double[] diem;
    private int[]    loi;
    private DSSinhVien DSach;
    KetQua(PhongThi phongThi){
        phong = phongThi;
        DSach = phongThi.getSinhVien();
        diem = new double[DSach.getN()];
        loi = new int[DSach.getN()];
    }
    void nhapDiem(int MaSoSinVien, double DiemThi, int SoViPham){
        int index = DSach.timKiem(MaSoSinVien);
        if (index != -1){
            diem[index] = DiemThi;
            loi[index] = SoViPham;
        }
    }
    void xuatDS(int TongViPham){
        System.out.println("Ma Phong: " + phong.getMaPhong());
        System.out.println("Hoc Phan: " + phong.getBienBan().hp.TenHocPhan);
        System.out.printf("%-3s|%-10s|%-25s|%-6s|%s\n", "STT", "MSSV", "Ten","Diem","Danh Gia");
        for (int i = 0; i < 75; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < DSach.getN(); i++){
            System.out.printf("%-3d|%-10d|%-25s|%-6.2f|%s\n", i, DSach.laySV(i).MaSo, DSach.laySV(i).Ten,
                            diem[i],DSach.laySV(i).DanhGia(loi[i]));
        }
        System.out.println();
        System.out.println("========================================================================================");
        System.out.println("Giam Thi:");
        System.out.printf("%-3s|%-10s|%-25s|%s\n", "STT", "Ma So", "Ten","Danh Gia");
        for (int i = 0; i < phong.getGiamThi().getN(); i++){
            System.out.printf("%-3d|%-10d|%-25s|%s\n", i, phong.getGiamThi().layGiamThi(i).MaSo,
            phong.getGiamThi().layGiamThi(i).Ten, phong.getGiamThi().layGiamThi(i).DanhGia(TongViPham));
        }
        
    }
    void xuatFile(){
        try {
            FileWriter file = new FileWriter("KetQua" + phong.getMaPhong() + ".txt");
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write("Ma phong: " + phong.getMaPhong());
            buffer.newLine();
            buffer.newLine();

            buffer.write(String.format("%-3s|%-10s|%-25s|%-6s|%s", "STT", "MSSV", "Ten","Diem","Danh Gia"));
            buffer.newLine();
            for (int i = 0; i < 75; i++)
                buffer.write("-");
            buffer.newLine();

            for (int i = 0; i < DSach.getN(); i++){
                buffer.write(String.format("%-3d|%-10d|%-25s|%-6.2f|%s\n", i, DSach.laySV(i).MaSo, 
                            DSach.laySV(i).Ten, diem[i],DSach.laySV(i).DanhGia(loi[i])));
            }

            buffer.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Can't Write File !!!");
        }
    }
}

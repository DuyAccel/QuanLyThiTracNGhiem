import java.io.*;

public class ThongKe implements File{
    private static int DiemTuyetDoi = 0;
    private static int NamGioi = 0;
    private static int TongThiSinh = 0;
    private static DSHocPhan dsHocPhan = new DSHocPhan();
    private static int[] XepLoai = new int[5];
    private static int[] DanhSachDiem;

    ThongKe(){

        DanhSachDiem = new int[(dsHocPhan.hp).length];
    }

    public int getIndex(int MaHocPhan){
            for (int i = 0; i < dsHocPhan.hp.length; i++){
                if (dsHocPhan.hp[i].getMaHocPhan() == MaHocPhan){
                    return i;
                }
            }
            return -1;
    }
    
    public void thongkeDiem(double Diem, int MaHP){
        if (Double.compare(Diem, 8.0) >= 0){
            if(Double.compare(Diem, 10.0) == 0){
                DiemTuyetDoi++;
                DanhSachDiem[getIndex(MaHP)]++;
            }
            XepLoai[0]++;
        }
        else if(Double.compare(Diem, 6.5) >= 0){
            XepLoai[1]++;
        }
        else if(Double.compare(Diem, 5.0) >= 0){
            XepLoai[2]++;
        }
        else if(Double.compare(Diem, 3.5) >= 0){
            XepLoai[3]++;
        }
        else    XepLoai[4]++;
    
    }

    
    public void thongkeNam(int MaSV, boolean GioiTinh){
        if (GioiTinh)       NamGioi++;
        TongThiSinh++;
    }

    public double thongkeGioiTinh(){
        if (NamGioi == 0)
            return 0;
        return 100.0*(NamGioi) / TongThiSinh;
    }

    @Override
    public void docFile() {
    }
    public void docFile(String FileName){
        try {
            FileReader file = new FileReader(FileName);
            BufferedReader buffer = new BufferedReader(file);
            String line;
            if ((line = buffer.readLine()) == null){
                buffer.close();
                file.close();
                return;
            }
            int maso = Integer.parseInt(line);
            while ((line = buffer.readLine()) != null){
                String[] data = line.split(";");
                if (Double.compare(Double.parseDouble(data[1]), 10.0) == 0){
                    DanhSachDiem[getIndex(maso)]++;
                    DiemTuyetDoi++;
                }
            }
        
            buffer.close();
            file.close();
           
        } catch (IOException ex) {
            System.out.println("Loi khi mo File!");
            
        }
    }
    @Override
    public void ghiFile() {
        try {
            FileWriter file = new FileWriter("ThongKe.txt");
            BufferedWriter buffer = new BufferedWriter(file);
            double GT = thongkeGioiTinh();
            buffer.write("Ti le gioi Tinh:");
            buffer.newLine();
            buffer.write("Nam: " + GT +"%");
            buffer.newLine();
            buffer.write("Nu:  " + (100 - GT) + "%");
            buffer.newLine();
            buffer.write("------------------------------------------------------------------------------");
            buffer.newLine();
            buffer.newLine();
            int sum = 0;
            for (int i : XepLoai) {
                sum += i;                
            }
            buffer.write("Thong ke xep loai: ");
            buffer.newLine();
            buffer.newLine();

            buffer.write("Diem Gioi: "+ XepLoai[0] + "\t| " + 100.0*XepLoai[0] / sum + "%");
            buffer.newLine();
            buffer.write("Diem Kha:  "+ XepLoai[1] + "\t| " + 100.0*XepLoai[1] / sum + "%");
            buffer.newLine();
            buffer.write("Diem TB:   "+ XepLoai[2] + "\t| " + 100.0*XepLoai[2] / sum + "%");
            buffer.newLine();
            buffer.write("Diem Yeu:  "+ XepLoai[3] + "\t| " + 100.0*XepLoai[3] / sum + "%");
            buffer.newLine();
            buffer.write("Diem Kem:  "+ XepLoai[4] + "\t| " + 100.0*XepLoai[4] / sum + "%");
            buffer.newLine();
            buffer.write("------------------------------------------------------------------------------");
            buffer.newLine();
            buffer.newLine();

            buffer.write("Tong so con diem tuyet doi: " + DiemTuyetDoi);
            buffer.newLine();
            
            buffer.write("So diem tuyet doi theo tung hoc phan:");
            buffer.newLine();

            buffer.write(String.format("%-13s|%-35s|%s","Ma hoc phan","Ten hoc phan","So diem tuyet doi"));
            buffer.newLine();

            for (int i = 0; i < (dsHocPhan.hp).length; i++){
                buffer.write(String.format("%-13d|%-35s|%d",dsHocPhan.hp[i].getMaHocPhan(), dsHocPhan.hp[i].getTenHocPhan(), DanhSachDiem[i]));
                buffer.newLine();
            }
            
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Khong the ghi File!");
        }
    }
    public void xuatThongKe(){
        double GT = thongkeGioiTinh();
        System.out.println("Ti le gioi Tinh:");
        System.out.println("Nam: " + GT +"%");
        System.out.println("Nu:  " + (100 - GT) +"%");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        int sum = 0;
            for (int i : XepLoai) {
                sum += i;                
            }

        System.out.println("Thong ke xep loai: ");
        System.out.println();
        System.out.println();
        System.out.println("Diem Gioi: "+ XepLoai[0] + "\t| " + 100.0*XepLoai[0] / sum + "%");
        System.out.println("Diem Kha:  "+ XepLoai[1] + "\t| " + 100.0*XepLoai[1] / sum + "%");
        System.out.println("Diem TB:   "+ XepLoai[2] + "\t| " + 100.0*XepLoai[2] / sum + "%");
        System.out.println("Diem Yeu:  "+ XepLoai[3] + "\t| " + 100.0*XepLoai[3] / sum + "%");
        System.out.println("Diem Kem:  "+ XepLoai[4] + "\t| " + 100.0*XepLoai[4] / sum + "%");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Tong so con diem tuyet doi: " + DiemTuyetDoi);
        System.out.println("So diem tuyet doi theo tung hoc phan:");
        System.out.printf("%-13s|%-35s|%s\n","Ma hoc phan","Ten hoc phan","So diem tuyet doi");
        for (int i = 0; i < (dsHocPhan.hp).length; i++){
            System.out.printf("%-13d|%-35s|%d\n",dsHocPhan.hp[i].getMaHocPhan(), dsHocPhan.hp[i].getTenHocPhan(), DanhSachDiem[i]);
        }
    }
}
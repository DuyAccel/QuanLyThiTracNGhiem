import java.io.*;
import java.util.Arrays;
public class ThongKe implements File{
    private static int DiemTuyetDoi = 0;
    private static int NamGioi = 0;
    private static DSHocPhan dsHocPhan;
    private static int[] XepLoai = new int[5];
    private static int[] DanhSachDiem;
    private static int[] DanhSachSinhVien = new int[1];
    ThongKe(){
        dsHocPhan.docDSTuFile();
        DanhSachDiem = new int[(dsHocPhan.hp).length];
        DanhSachSinhVien[0] = -1;
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

    public void insertionSort(int[] a){
        int i, key, j;
        for (i = 1; i < a.length; i++){
            key = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }  
    }

    public boolean binarySerach(int[] a, int x){
        int L= 0, R=a.length - 1, mid = 0;
        
        while (L < R){
            if (a[(mid = (L + R)/2)] == x)
                break;
            if (a[mid] > x){
                R = mid - 1;
            }
            else{
                L = mid + 1;
            }
        }
        if (a[mid] == x)    return true;
        return false;
    } 
    public void thongkeNam(int MaSV, boolean GioiTinh){
        if (binarySerach(DanhSachSinhVien, MaSV))
            return;
        DanhSachSinhVien = Arrays.copyOf(DanhSachSinhVien, DanhSachSinhVien.length + 1);
        DanhSachSinhVien[DanhSachSinhVien.length-1] = MaSV;
        insertionSort(DanhSachSinhVien);
        if (GioiTinh)       NamGioi++;
    }

    public double thongkeGioiTinh(){
        if (NamGioi == 0)
            return 0;
        return 1.0*(DanhSachSinhVien.length - 1) / NamGioi;
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

            buffer.write("Ma hoc phan: \t Ten hoc phan\t\t So diem tuyet doi:");
            buffer.newLine();

            for (int i = 0; i < (dsHocPhan.hp).length; i++){
                buffer.write(dsHocPhan.hp[i].getMaHocPhan() + "\t " + dsHocPhan.hp[i].getTenHocPhan() + "\t " + DanhSachDiem[i]);
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
        System.out.println("Ma hoc phan: \t Ten hoc phan\t\t So diem tuyet doi:");
        for (int i = 0; i < (dsHocPhan.hp).length; i++){
            System.out.println(dsHocPhan.hp[i].getMaHocPhan() + "\t " + dsHocPhan.hp[i].getTenHocPhan() + "\t " + DanhSachDiem[i]);
        }
    }
}
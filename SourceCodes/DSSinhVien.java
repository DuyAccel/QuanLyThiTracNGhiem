import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class DSSinhVien implements DuyetDS, File{
    private int MaSoDS;
    private int n;
    private SinhVien[] sv;
     
    DSSinhVien(){}
    @Override
    public void nhapDS() {
        String Ten;
        int MaSo;
        String Lop;
        boolean CamThi;
        String NgaySinh;
        boolean GioiTinh;
        Scanner scan = new Scanner(System.in);
        do{   
            System.out.print("Nhap Ma So Danh Sach: ");
            MaSoDS = Integer.parseInt(scan.nextLine());
        }while(MaSoDS < 0);
        do{   
            System.out.print("Nhap So Luong SV: ");
            n = Integer.parseInt(scan.nextLine());
        }while(n < 0);
        sv = new SinhVien[n];
        for (int i = 0; i < n; i++){
            System.out.println("Sinh Vien " + i);

            System.out.print("Nhap Ten: ");
            Ten = scan.nextLine();

            do{
                System.out.print("Nhap Maso: ");
                MaSo = Integer.parseInt(scan.nextLine());
            }   while(MaSo < 0);

            System.out.print("Nhap Lop: ");
            Lop = scan.nextLine();

            System.out.print("Nhap Ngay sinh: ");
            NgaySinh = scan.nextLine();

            System.out.print("Nhap Gioi Tinh (Nam -> true / Nu -> false): ");
            GioiTinh = Boolean.parseBoolean(scan.nextLine());

            System.out.print("Nhap trang thai CamThi: ");
            CamThi = Boolean.parseBoolean(scan.nextLine());
            
            sv[i] = new SinhVien(Ten, MaSo, Lop, NgaySinh, GioiTinh, CamThi);
        }
    }
    @Override
    public void xuatDS() {
        System.out.println("Ma danh sach: " + MaSoDS);
        System.out.println("So luong sinh vien: " + n);
        for(int i = 0; i < n; i++){
            System.out.println("Sinh vien " + i);
            System.out.println("Ten: " + sv[i].getTen());
            System.out.println("Ma So: " + sv[i].getMaSo());
            System.out.println("Lop: " + sv[i].getLop());
            System.out.println("Ngay Sinh: " + sv[i].getNgaySinh());
            System.out.println("Gioi Tinh: " + sv[i].getStringGioiTinh());
            System.out.println("Cam thi: " + sv[i].getStringCamThi());
        }
    }
    @Override
    public boolean xoaPT(int x) {
        if (x > n)  return false;
        n--;
        if (x > n)  return true;
        for (int i = x; i < n; i++){
            sv[i] = sv[i+1];
        }
        sv[n] = null;
        sv = Arrays.copyOf(sv, n);
        return true;
    }
    @Override
    public boolean themPT() {
        System.out.print("Nhap vi tri muon them: ");
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        if (x > n || x < 0)     return false;
        n++;
        sv = Arrays.copyOf(sv, n);
        for (int i = n - 1; i > x; i--){
            sv[i] = sv[i-1];
        }
        sv[x].capNhat();
        return true;
    }
    @Override
    public void timKiem(){
    }
    public int timKiem(int Maso){
        for (int i = 0; i < n; i++){
            if (sv[i].getMaSo() == Maso)
                return i;
        }
        return -1;
    }
    public int timKiem(String Ten){
        for (int i = 0; i < n; i++){
            if ((sv[i].getTen()).equalsIgnoreCase(Ten))
                return i;
        }
        return -1;
    }
    @Override
    public void sapXep() {     
        SinhVien tmp;           
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n - 1 - i; j++)
                if (sv[j].getMaSo() > sv[j+1].getMaSo()){
                    tmp = sv[j];
                    sv[j] = sv[j+1];
                    sv[j+1] = tmp;
                }
        }
        tmp = null;
    }
    @Override
    public void docFile(){}
    public void docFile(String FileName) {
    try {
        FileReader file = new FileReader(FileName);
        BufferedReader buffer = new BufferedReader(file);
        n = 0;
        sv = new SinhVien[1];
        String line;
        if ((line = buffer.readLine()) != null)
            MaSoDS = Integer.parseInt(line);
        while (true){
            line = buffer.readLine();
            if (line == null)
                break;
            n++;
            sv = Arrays.copyOf(sv, n);
            String []data = line.split(";");
            sv[n-1] = new SinhVien(data[0], Integer.parseInt(data[1]), data[2], data[3],
                                     Boolean.parseBoolean(data[4]), Boolean.parseBoolean(data[5]));
        }
        buffer.close();
        file.close();
    } catch (IOException ex) {
        System.out.println("Loi khi mo File!");
    }
    }
    @Override
    public void ghiFile(){}
    
    public void ghiFile(String filename) {
        try {
            FileWriter file = new FileWriter(filename);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write("Ma so danh sach: " + MaSoDS);
            buffer.newLine();
            buffer.write("So luong sinh vien: " + n);
            buffer.newLine();
            
            buffer.newLine();
            for (SinhVien s : sv) {
                buffer.write(s.getMaSo()+ "\t\t\t" +s.getTen() + "\t\t\t\t\t" + s.getLop() + "\t\t\t"
                            + s.getNgaySinh() + "\t\t" + s.getStringGioiTinh() + "\t\t\t" + s.getStringCamThi());
                buffer.newLine();
            }
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Khong the ghi File!");
        }
        
    }
}
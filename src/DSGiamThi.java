import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class DSGiamThi implements DuyetDS, File{
    private int MaSoDS;
    private int n;
    private GiamThi[] gt;
     
    DSGiamThi(){}
    public int getN() {
        return n;
    }

    public GiamThi layGiamThi(int index){
        return gt[index];
    }

    @Override
    public void nhapDS() {
        String Ten;
        int MaSo;
        String HocVi;
        String NgaySinh;
        boolean GioiTinh;
        Scanner scan = new Scanner(System.in);
        do{   
            System.out.print("Nhap Ma So Danh Sach: ");
            MaSoDS = Integer.parseInt(scan.nextLine());
        }while(MaSoDS < 0);
        do{   
            System.out.print("Nhap So Luong Giam Thi: ");
            n = Integer.parseInt(scan.nextLine());
        }while(n < 0);
        gt = new GiamThi[n];
        for (int i = 0; i < n; i++){
            System.out.println("Giam Thi " + i);

            System.out.print("Nhap Ten: ");
            Ten = scan.nextLine();

            do{
                System.out.print("Nhap Maso: ");
                MaSo = Integer.parseInt(scan.nextLine());
            }   while(MaSo < 0);

            System.out.print("Nhap Hoc Vi: ");
            HocVi = scan.nextLine();

            System.out.print("Nhap Ngay sinh: ");
            NgaySinh = scan.nextLine();

            System.out.print("Nhap Gioi Tinh: ");
            GioiTinh = Boolean.parseBoolean(scan.nextLine());
            gt[i] = new GiamThi(Ten, MaSo, HocVi, NgaySinh, GioiTinh);
        }
    }
    @Override
    public void xuatDS() {
        System.out.println("Ma danh sach: " + MaSoDS);
        System.out.println("So luong Giam Thi: " + n);
        System.out.printf("|%-10s|%-24s|%-15s|%-12s|%s\n", "Ma So", "Ten", "Hoc vi", "Ngay Sinh", "Gioi Tinh" );
        for (int i = 0; i < 70; i++)
            System.out.print("-");
        System.out.println();
        for (GiamThi s : gt) {
            System.out.printf("|%-10s|%-24s|%-15s|%-12s|%s\n",s.getMaSo(), s.getTen(),  s.getHocVi(), s.getNgaySinh(), s.getStringGioiTinh());
        }
    }
    @Override
    public boolean xoaPT(int x) {
        if (x > n)  return false;
        n--;
        if (x > n)  return true;
        for (int i = x; i < n; i++){
            gt[i] = gt[i+1];
        }
        gt[n] = null;
        gt = Arrays.copyOf(gt, n);
        return true;
    }
    @Override
    public void themPT(){}
    public void themPT(Scanner scan)
    {
        n++;
        gt = Arrays.copyOf(gt, n);
        gt[n-1] = new GiamThi();
        gt[n-1].capNhat(scan);
    }
    @Override
    public void timKiem(){
    }
    public int timKiem(int Maso){
        for (int i = 0; i < n; i++){
            if (gt[i].getMaSo() == Maso)
                return i;
        }
        return -1;
    }
    public int timKiem(String Ten){
        for (int i = 0; i < n; i++){
            if ((gt[i].getTen()).equalsIgnoreCase(Ten))
                return i;
        }
        return -1;
    }
    @Override
    public void sapXep() {     
        GiamThi tmp;           
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n - 1 - i; j++)
                if (gt[j].getMaSo() > gt[j+1].getMaSo()){
                    tmp = gt[j];
                    gt[j] = gt[j+1];
                    gt[j+1] = tmp;
                }
        }
        tmp = null;
    }
    @Override
    public void docFile() {}
    public void docFile(String FileName) {
    try {
        FileReader file = new FileReader(FileName);
        BufferedReader buffer = new BufferedReader(file);
        n = 0;
        gt = new GiamThi[1];
        String line;
        if ((line = buffer.readLine()) != null)
            MaSoDS = Integer.parseInt(line);
        while (true){
            line = buffer.readLine();
            if (line == null)
                break;
            n++;
            gt = Arrays.copyOf(gt, n);
            String []data = line.split(";");
            gt[n-1] = new GiamThi(data[0], Integer.parseInt(data[1]), data[2], data[3], Boolean.parseBoolean(data[4]));
        }
        buffer.close();
        file.close();
    } catch (IOException ex) {
        System.out.println("Loi khi mo File!");
    }
    }
    @Override
    public void ghiFile(){}
    public void ghiFile(String Filename) {
        try {
            FileWriter file = new FileWriter(Filename);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write("Ma so danh sach: " + MaSoDS);
            buffer.newLine();
            buffer.write("So luong Giam Thi: " + n);
            buffer.newLine();
            buffer.write(String.format("|%-10s|%-24s|%-15s|%-12s|%s", "Ma So", "Ten", "Hoc vi", "Ngay Sinh", "Gioi Tinh" ));
            buffer.newLine();
            for (GiamThi s : gt) {
                buffer.write(String.format("|%-10s|%-24s|%-15s|%-12s|%s", s.getMaSo(), s.getTen(),
                            s.getHocVi(), s.getNgaySinh(), s.getStringGioiTinh()));
                buffer.newLine();
            }
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Khong the ghi File!");
        }
    }
}
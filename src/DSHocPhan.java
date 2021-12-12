import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class DSHocPhan implements DuyetDS{
    public HocPhan[] hp;
    DSHocPhan(){
        docDSTuFile();
    }
    @Override
    public void nhapDS() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap so luong Hoc Phan:");
        int n = Integer.parseInt(scan.nextLine());
        hp = new HocPhan[n];
        for (int i = 0; i < n; i++){
            hp[i].capNhat();
        }
    }
    @Override
    public void xuatDS() {
        System.out.println("So Luong Hoc Phan:" + hp.length);
        for (int i = 0; i < hp.length; i++){
            System.out.println("Hoc Phan " + i + ":");
            System.out.println("Ma hoc phan: " + hp[i].MaHocPhan);
            System.out.println("Ten hoc phan: " + hp[i].TenHocPhan);
            System.out.println("So tin chi: " + hp[i].TinChi);
        }
    }
    @Override
    public void sapXep() {
        HocPhan tmp;           
        for(int i = 0; i < hp.length-1; i++){
            for(int j = 0; j < hp.length - 1 - i; j++)
                if (hp[j].MaHocPhan > hp[j+1].MaHocPhan){
                    tmp = hp[j];
                    hp[j] = hp[j+1];
                    hp[j+1] = tmp;
                }
        }
        tmp = null;
    }
    @Override
    public boolean xoaPT(int x) {
        if (x > hp.length)  return false;

        if (x > hp.length)  return true;
        for (int i = x; i < hp.length - 1; i++){
            hp[i] = hp[i+1];
        }
        hp[hp.length] = null;
        hp = Arrays.copyOf(hp, hp.length);
        return true;
    }
    @Override
    public boolean themPT() {
        System.out.print("Nhap vi tri muon them: ");
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        if (x > hp.length || x < 0)     return false;
    
        hp = Arrays.copyOf(hp, hp.length+1);
        for (int i = hp.length - 1; i > x; i--){
            hp[i] = hp[i-1];
        }
        hp[x].capNhat();
        return true;
    }

    @Override
    public void timKiem() {
    }
    public int timKiem(int MaSo){
        for (int i = 0; i < hp.length; i++){
            if (hp[i].MaHocPhan == MaSo)
                return i;
        }
        return -1;
    }
    public int timkiem(String Ten){
        for (int i = 0; i < hp.length; i++){
            if ((hp[i].TenHocPhan).equalsIgnoreCase(Ten))
                return i;
        }
        return -1;
    }

    public void docDSTuFile() {
        try {
            FileReader file = new FileReader("HocPhan.txt");
            BufferedReader buffer = new BufferedReader(file);
            int n = 0;
            hp = new HocPhan[1];
            String line;
            while (true){
                line = buffer.readLine();
                if (line == null)
                    break;
                n++;
                hp = Arrays.copyOf(hp, n);
                String []data = line.split(";");
                hp[n-1] = new HocPhan(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            }
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Loi khi mo File!");
        }
    }
}

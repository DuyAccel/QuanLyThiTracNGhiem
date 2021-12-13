
import java.io.*;
import java.util.Arrays;

import java.util.Scanner;

public class BoCauHoi implements DuyetDS,File{
    
    private int n;
    protected CauHoi[] ch;
    
    public BoCauHoi() {
    }
    public int getN() {
        return n;
    }
    public BoCauHoi(String TenFileCauHoi) {
        
        docFile(TenFileCauHoi+".txt");
    }
    @Override
    public void timKiem() {}
    public int timKiem(String NoiDung){
        for (int i = 0; i < n; i++){
            if ((ch[i].getNoiDung()).equalsIgnoreCase(NoiDung))
                return i;
        }
        return -1;
    }
    @Override
    public void sapXep() {  
    }
    @Override
    public boolean themPT() {
        System.out.print("Nhap vi tri muon them: ");
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        if (x > n || x < 0)     return false;
        n++;
        ch = Arrays.copyOf(ch, n);
        for (int i = n - 1; i > x; i--){
            ch[i] = ch[i-1];
        }
        ch[x].chinhSua();
        return true; 
    }
    @Override
    public boolean xoaPT(int x) {
        if (x > n)  return false;
        n--;
        if (x > n)  return true;
        for (int i = x; i < n; i++){
            ch[i] = ch[i+1];
        }
        ch[n] = null;
        ch = Arrays.copyOf(ch, n);
        return true;
    }
    @Override
    public void nhapDS() {
    Scanner scan = new Scanner(System.in);
        do{    
            System.out.print("Nhap so luong cau hoi: ");
            n = Integer.parseInt(scan.nextLine());
        }while(n < 0);
        ch = new CauHoi[n];
        for (int i = 0; i<n; i++){
            ch[i] = new CauHoi();
            ch[i].chinhSua();
        }
    }
    @Override
    public void xuatDS() {       
        System.out.println("So luong cau hoi: " + n);
        for(int i = 0; i < n; i++){
            System.out.println("Cau hoi " + (i + 1)+ ":");   
            ch[i].xuat();
        }
    }
    @Override
    public void docFile(){} 
    public void docFile(String FileName){
    try {
        try (FileReader file = new FileReader(FileName); 
            BufferedReader buffer = new BufferedReader(file)) {
                 n = 0;
                 ch = new CauHoi[1];
                 String []data = new String[6];
                 while (true){
                     data[0] = buffer.readLine();
                     if (data[0] == null)
                         break;
                     n++;
                     ch = Arrays.copyOf(ch, n);
                     data[1] = buffer.readLine();
                     data[2] = buffer.readLine();
                     data[3] = buffer.readLine();
                     data[4] = buffer.readLine();
                     data[5] = buffer.readLine();
                     ch[n-1] = new CauHoi(data[0], data[1], data[2], data[3], data[4], data[5]);
                 }
                buffer.close();
                file.close();
             }
        } catch (IOException ex) {
            System.out.println("Loi khi mo File!");
        }
    }
    @Override
    public void ghiFile() {}
    public void ghiFile(String Filename) {
            try{ FileWriter file = new FileWriter(Filename); 
                BufferedWriter buffer = new BufferedWriter(file); 
                buffer.write("So luong cau hoi: " + n);                            
                buffer.newLine();
                buffer.newLine();
                for (CauHoi s : ch) {
                    buffer.write(s.getNoiDung());
                    buffer.newLine();
                    buffer.write("A. "+s.getPhuongAnA());
                    buffer.newLine();
                    buffer.write("B. "+s.getPhuongAnB());
                    buffer.newLine();
                    buffer.write("C. "+s.getPhuongAnC());
                    buffer.newLine();
                    buffer.write("D. "+s.getPhuongAnD());
                    buffer.newLine();
                    buffer.write("Dap An: "+s.getDapAn());
                    buffer.newLine();
                }
            buffer.close();
            file.close();
            }catch (IOException ex) {
                System.out.println("Khong the ghi File!");
            }           
    }
}


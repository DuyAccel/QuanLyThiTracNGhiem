


import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public  class DSPhongThi implements DuyetDS, File{
    private int Nam;
    private int HocKy;
    private int n;
    private PhongThi[] pt;
    
    public int getNam() {
        return Nam;
    }

    public int getHocKy() {
        return HocKy;
    }
    
    public int getN() {
        return n;
    }
    
    DSPhongThi(){}

    public PhongThi layPhongThi(int index){
        return pt[index];
    }
    @Override
     public void nhapDS() {
     String TenFileSinhVien;
     String TenFileGiamThi;
     String TenFileBienBan;
     int    MaPhong;
     
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap Nam Hoc: ");
            Nam = Integer.parseInt(scan.nextLine());
        }while(Nam < 0);
        do{
            System.out.print("Nhap Hoc Ky: ");
            HocKy = Integer.parseInt(scan.nextLine());
        }while (HocKy<0 || HocKy>3);
        
        do{
            System.out.print("Nhap so luong phong: ");
             n = Integer.parseInt(scan.nextLine());
            }while(n<0);
        
            pt = new PhongThi[n];
            for(int i = 0; i<n; i++){
                System.out.println("Phong thi "+i);
            
                System.out.print("Nhap Ma Phong: ");
                MaPhong = Integer.parseInt(scan.nextLine()); 
                
                System.out.print("Nhap ten file Sinh Vien: ");
                TenFileSinhVien = scan.nextLine();
            
                System.out.print("Nhap ten file Giam Thi: ");
                TenFileGiamThi =  scan.nextLine();

                System.out.print("Nhap ten file Bien Ban:");
                TenFileBienBan = scan.nextLine();
            
                pt[i] = new PhongThi(MaPhong, TenFileSinhVien, TenFileGiamThi, TenFileBienBan);
           }  
    }
    
      @Override
        public void xuatDS() {
          System.out.println("Nam hoc: "+Nam);
          System.out.println("Hoc Ky: "+HocKy);
          System.out.println("So luong phong thi: "+n);
          for(int i = 0; i<n; i++){
              System.out.println("Phong Thi" +i);
              System.out.println("Ma Phong: " + pt[i].getMaPhong());
              System.out.println("Ten file Giam Thi : "+pt[i].getTenFileGiamThi());
              System.out.println("Ten file Sinh Vien : "+pt[i].getTenFileSinhVien());
              System.out.println("Ten File Bien Ban: " + pt[i].getTenFileBienBan());
          }
        }
    @Override
      public boolean xoaPT(int x) {
          if(x>n) return false;
          n--;
          if(x>n)  return true;
          for(int i = x; i<n; i++){
              pt[i] = pt[i+1];
          }
          pt[n] = null;
          pt = Arrays.copyOf(pt,n);
          return true;
      }

     @Override
        public void themPT() {
                n++;
                pt = Arrays.copyOf(pt, n);
                pt[n-1] = new PhongThi();
                pt[n-1].capNhat();
              
           }
    
    @Override
    public void timKiem() {
    }
    
    public int timKiem(int MaSoPhong){
        for(int i = 0; i<n; i++){
            if(pt[i].getMaPhong() == MaSoPhong)
                return i;
        }
        return -1;
    }

    @Override
    public void sapXep() {
       PhongThi tmp;
        for(int i = 0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++)
                if(pt[j].getMaPhong()>pt[j+1].getMaPhong()){
                    tmp =pt[j];
                    pt[j]=pt[j+1];
                    pt[j+1]= tmp;
                }
        }
          tmp =null;  
    }

    @Override
    public void docFile() {}
        public void docFile(String FileName){
         try {
            FileReader file = new FileReader(FileName);
            BufferedReader buffer = new BufferedReader(file);
            n = 0;
            pt = new PhongThi[1];
            String line;
            while (true){
                line = buffer.readLine();
                if (line == null)
                    break;
                n++;
                pt = Arrays.copyOf(pt, n);
                String []data = line.split(";");
                pt[n-1] = new PhongThi(Integer.parseInt(data[0]), data[1], data[2], data[3]);
            }
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Loi khi mo File!");
        }
      }

    @Override
            public void ghiFile() {}
             public void ghiFile(String Filename) {
                try {
                    FileWriter file = new FileWriter(Filename);
                    BufferedWriter buffer = new BufferedWriter(file);
                    buffer.write("So luong Phòng Thi: " + n);
                    buffer.newLine();

                    buffer.newLine();
                    for (PhongThi s : pt) {
                        buffer.write(s.getMaPhong()+ ";" +s.getTenFileGiamThi() + ";"   + s.getTenFileSinhVien() + s.getTenFileBienBan());
                        buffer.newLine();
                    }
                    buffer.close();
                    file.close();
                } catch (IOException ex) {
                    System.out.println("Khong the ghi File!");
                }
            }
}
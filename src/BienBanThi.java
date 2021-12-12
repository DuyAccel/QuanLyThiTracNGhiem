/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;
import java.util.Scanner;


public class BienBanThi implements File{
    protected int MaPhong;
    protected ThoiGian NgayThi;
    protected  int ThoiGianLam;
    protected HocPhan hp;

    BienBanThi(){}
    BienBanThi(int MaPhong, String NgayThi, int ThoiGianLam){
         this.MaPhong = MaPhong;
         this.ThoiGianLam = ThoiGianLam;
         this.NgayThi = new ThoiGian(NgayThi);
     }

    public int getMaPhong() {
        return MaPhong;
    }


    public ThoiGian getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(ThoiGian NgayThi) {
        this.NgayThi = NgayThi;
    }

    public int getThoiGianLam() {
        return ThoiGianLam;
    }

    public void setThoiGianLam(int ThoiGianLam) {
        this.ThoiGianLam = ThoiGianLam;
    }
    
     public void capNhat() {
       Scanner scan = new Scanner(System.in);
       int n;
       do{
           System.out.println("vui lòng chọn mục cần chỉnh sữa");
           System.out.println("1. MaDS \n2.NgayThi \n3.ThoiGianLam\n4. Hoc Phan\n5. Thoat" );
           System.out.println("chọn: ");
           n = scan.nextInt();
           switch(n){
               case 1:
                   System.out.print("Nhập Mã Danh Sách mới: ");
                   MaPhong = Integer.parseInt(scan.nextLine());
                   break;
                   
               case 2:
                   System.out.print("Nhập Ngày Thi mới: ");
                   NgayThi = new ThoiGian(scan.nextLine());
                   break;
                   
               case 3:
                   System.out.print("Nhập Thời Gian Làm mới: ");
                   ThoiGianLam = Integer.parseInt(scan.nextLine());
                   break;
                case 4:
                    hp.capNhat();
                    break;
           }
       }while (n!=4);
     }
    
    @Override
    public void docFile() {}
    public void docFile(String FileName){
        try {
            FileReader file = new FileReader(FileName);
            BufferedReader buffer = new BufferedReader(file);
            String line = buffer.readLine();
            MaPhong = Integer.parseInt(line);
            line = buffer.readLine();
            NgayThi = new ThoiGian(line);
            line = buffer.readLine();
            ThoiGianLam = Integer.parseInt(line);
            String []data = line.split(";");
            hp = new HocPhan(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
            buffer.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi mo File!!!");
        }
    }
    @Override
    public void ghiFile() {
        try {
            FileWriter file = new FileWriter("BienBan" +MaPhong);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(MaPhong);
            buffer.newLine();
            buffer.write(NgayThi.Ngay + "/" + NgayThi.Thang + "/" + NgayThi.Nam);
            buffer.newLine();
            buffer.write(ThoiGianLam);
            buffer.newLine();
            buffer.write(hp.getMaHocPhan() + ";" + hp.getTenHocPhan() + ";" + hp.getTinChi());
            buffer.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Khong the ghi File!");
        }
    }
    }

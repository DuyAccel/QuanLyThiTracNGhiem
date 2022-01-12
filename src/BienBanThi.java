/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;
import java.util.Scanner;


public class BienBanThi implements File{
    protected int MaDS;
    protected ThoiGian NgayThi;
    protected  int ThoiGianLam;
    protected HocPhan hp;

    BienBanThi(){}
    
 
    public String getStringNgay(){
        return NgayThi.Ngay + "/" + NgayThi.Thang + "/" +NgayThi.Nam;
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
                   MaDS = Integer.parseInt(scan.nextLine());
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
            MaDS = Integer.parseInt(line);
            line = buffer.readLine();
            NgayThi = new ThoiGian(line);
            line = buffer.readLine();
            ThoiGianLam = Integer.parseInt(line);
            line = buffer.readLine();
            String []data = line.split(";");
            hp = new HocPhan(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            buffer.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi mo File!!!");
        }
    }
    @Override
    public void ghiFile() {
        try {
            FileWriter file = new FileWriter("BienBan" +MaDS);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(MaDS);
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
    public void xuatBienBan(){
        System.out.println("Hoc Phan thi: "+hp.getTenHocPhan());
        System.out.println("Ma hoc Phan:  "+hp.getMaHocPhan());
        System.out.println("Ngay thi: " + NgayThi.Ngay+"/"+NgayThi.Thang+"/t"+NgayThi.Nam);
        System.out.println("Thoi gian lam bai: "+ThoiGianLam+" phut");
    }
    }

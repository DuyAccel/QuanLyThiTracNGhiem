import java.util.Scanner;
public class App {
    private static Scanner scan = new Scanner(System.in);
    static DSPhongThi dsPhongThi = new DSPhongThi();
    private static String FilePhongThi = "DSPhong.txt";
    private static String MatKhau = "12345";
    public static void clearScreen(){
        for (int i = 0; i < 80; i++)
            System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args){
        dsPhongThi.docFile(FilePhongThi);
        menuDangNhap();
        PhongThi Phong = thietLapPhongThi();
        menuSinhVien(Phong.getSinhVien());
        scan.close();
    }

    private static PhongThi thietLapPhongThi() {
        clearScreen();
        System.out.println("Thiet Lap Phong thi!!!");
        int index;
        while(true){
            System.out.print("Nhap ma phong thi: ");
            index = Integer.parseInt(scan.nextLine());
            if (dsPhongThi.timKiem(index) != -1){
                System.out.println("Hay kiem tra Thong tin phong");
                dsPhongThi.layPhongThi(index).xuatThongTin();
                System.out.println("Nhan phim 1 de xac nhan!");
                if (Integer.parseInt(scan.nextLine()) == 1)
                    break;
            }
            System.out.println("Ma phong sai!!!");
        }
        

        return dsPhongThi.layPhongThi(index);
    }

    public static void menuDangNhap(){
      

        
        int n;
        do{
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Xin lua chon phuong thuc dang nhap:");
            System.out.println("0. Tien hanh thi");
            System.out.println("1. Cap nhat Du lieu!");
            System.out.println();
            System.out.print("Lua chon: ");
            n = Integer.parseInt(scan.nextLine());
            clearScreen();
        }while(n != 0 && n != 1);
        if (n == 0)
            return;
        else
            menuAdmin();
        scan.close();
    }
    public static void menuSinhVien(DSSinhVien sv){
        clearScreen();
        do{
            System.out.print("Vui long nhap Ma so Sinh Vien: ");
            int MaSo = Integer.parseInt(scan.nextLine());
            int x = sv.timKiem(MaSo);
            if (x == -1)
                System.out.println("Khong tim ra Sinh Vien phu hop!");
            else{
                System.out.println("Hay kiem tra thong tin!");
                System.out.println();
                sv.laySV(x).xuatThongTin();
                System.out.println();
                System.out.println("Nhap phim:");
                System.out.println("0. Nhap lai ma sinh vien");
                System.out.println("1. Bat dau thi");
                if (Integer.parseInt(scan.nextLine()) == 1)
                        break;
            }
        }while(true);
    }
    
    public static void menuAdmin(){
        clearScreen();
        System.out.println("Ban dang dang nhap voi vai tro Admin!!");
        while(true){
            System.out.println("Hay nhap MAT KHAU!");
            if (MatKhau.equals(scan.nextLine())){
                break;
            }
            System.out.println("Mat khau sai!!!");
        }
        int n;
        while(true){
            System.out.println("Vui Long lua chon Thao tac!");
            System.out.println("1. Doi Mat Khau");
            System.out.println("2. Doi File Danh Sach Phong thi");
            System.out.println("3. Cap Nhat Thong tin Danh Sach Phong");
            System.out.println("4. Cap Nhat thong tin Phong thi x");
            System.out.println("5. Cap Nhat Danh Sach Hoc Phan");
            System.out.println("6. Thoat");
            n = Integer.parseInt(scan.nextLine());
            switch(n){
                case 1:
                    System.out.print("Nhap Mat khau moi: ");
                    MatKhau = scan.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap ten File DS Phong Thi moi");
                    dsPhongThi.docFile(scan.nextLine()+".txt");
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    while(true){
                        System.out.print("Nhap ma phong thi: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if (dsPhongThi.timKiem(index) != -1){
                            dsPhongThi.layPhongThi(index).capNhat();
                            break; 
                        }
                        System.out.println("Ma phong sai!!!");
                    }
                    
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Khong Hop le!!!!");
                    break;
            }
            System.out.println("Nhan 1 de Tiep Tuc");
            if (Integer.parseInt(scan.nextLine()) != 1)
                return;
        }
    }
}

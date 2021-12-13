import java.util.Scanner;
public class App {
    private static Scanner scan = new Scanner(System.in);
    private static DSPhongThi dsPhongThi = new DSPhongThi();
    private static BoCauHoi boCauHoi = new BoCauHoi();
    private static String FilePhongThi = "DSPhong.txt";
    private static String FileCauHoi = "CauHoi.txt";
    private static ThongKe thongKe = new ThongKe();
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
        boCauHoi.docFile(FileCauHoi);
        dsPhongThi.docFile(FilePhongThi);
        boolean Loop = true;
        while (Loop){
            menuDangNhap();
            PhongThi Phong = thietLapPhongThi();
            Phong.sapXep();
            Thi thi;
            SinhVien sv;
            HocPhan hocPhan;
            boolean flag = true;
            do {
                sv = menuSinhVien(Phong.getSinhVien());
                hocPhan = Phong.getBienBan().hp;
                thi = new Thi(sv, boCauHoi, Phong.getBienBan().hp, Phong.getBienBan().getStringNgay(),
                        Phong.getBienBan().ThoiGianLam);
                clearScreen();
                int n = Phong.getBienBan().hp.getSoCau();
                for (int i = 0; i < n; i++) {
                    thi.menuThi(i, scan);
                }
                thongKe.thongkeDiem(thi.tinhDiem(), hocPhan.getMaHocPhan());
                System.out.println("Chuc Mung ban da hoan thanh Bai Thi");
                System.out.println("Diem ban dat duoc la: " + thi.tinhDiem());
                System.out.println("Nhap ki tu bat ky de THOAT!");
                scan.nextLine();
                clearScreen();
                boolean loop = true;
                do {
                    System.out.println("Vui long Lua chon: ");
                    System.out.println("0. Thoat Qua Trinh Thi");
                    System.out.println("1. Tiep Tuc cho Sinh vien moi trong phong thi");
                    switch (Integer.parseInt(scan.nextLine())) {
                        case 0:
                            flag = false;
                            loop = false;
                            break;
                        case 1:
                            loop = false;
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!!!");
                    }
                } while (loop);
            } while (flag);
            flag = true;
            do {
                clearScreen();
                System.out.println("Chuyen Sang Phong Thi khac?");
                System.out.println("0. No ! Khong Thi nua");
                System.out.println("1. Yes! Tiep Tuc Thi");
                switch (Integer.parseInt(scan.nextLine())) {
                    case 0:
                        flag = false;
                        Loop = false;
                        break;
                    case 1:
                        flag = false;
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!!!");
                }
            } while (flag);
        }
        Loop = true;
            do {
                clearScreen();
                System.out.println("Xem Thong Ke Ky thi?");
                System.out.println("0. Khong! THoat Chuong Trinh luon!");
                System.out.println("1. Co   ! Xem Thong ke thoi~");
                switch (Integer.parseInt(scan.nextLine())) {
                    case 0:
                        Loop = false;
                        break;
                    case 1:
                        Loop = false;
                        clearScreen();
                        thongKe.xuatThongKe();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!!!");
                }
            } while (Loop);
        
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
            System.out.println("Main menu:");
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
    public static SinhVien menuSinhVien(DSSinhVien sv){
        clearScreen();
        int x;
        do{
            System.out.print("Vui long nhap Ma so Sinh Vien: ");
            int MaSo = Integer.parseInt(scan.nextLine());
            x = sv.timKiem(MaSo);
            if (x == -1)
                System.out.println("Khong tim ra Sinh Vien phu hop!");
            else{
                System.out.println("Hay kiem tra thong tin!");
                System.out.println();
                sv.laySV(x).xuatThongTin();
                System.out.println();
                System.out.println("Nhap phim 1 de bat dau thi!");
                if (Integer.parseInt(scan.nextLine()) == 1)
                        break;
            }
        }while(true);
        return sv.laySV(x);
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
            System.out.println("3. Thay Doi Bo Cau Hoi");
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
                    System.out.println("Nhap ten File DS Phong Thi moi!");
                    System.out.print("Ten File: ");
                    FilePhongThi = scan.nextLine() + ".txt";
                    dsPhongThi.docFile(FilePhongThi);
                    break;
                case 3:
                    System.out.println("Nhap ten File cua Bo Cau Hoi moi!");
                    System.out.print("Ten File: ");
                    FileCauHoi = scan.nextLine() + ".txt";
                    boCauHoi.docFile(FileCauHoi);
                    break;
                case 4:
                    while(true){
                        System.out.print("Nhap ma phong thi: ");
                        int index = Integer.parseInt(scan.nextLine());
                        if (dsPhongThi.timKiem(index) == -1){
                            System.out.println("Ma phong sai!!!");
                        }
                        
                        boolean loop = true;
                        while (loop){
                            System.out.println("Lua Chon Thao Tac:");
                            System.out.println("1. Cap nhat Thong Tin co san");
                            System.out.println("2. Them Sinh Vien");
                            System.out.println("3. Xoa Sinh Vien");
                            System.out.println("4. Them Giam Thi");
                            System.out.println("5. xoa Giam thi");
                            System.out.println("6. Thoat");
                            switch (Integer.parseInt(scan.nextLine())){
                                case 1:
                                    dsPhongThi.layPhongThi(index).capNhat();
                                    break;
                                case 2:
                                    dsPhongThi.layPhongThi(index).getSinhVien().themPT();
                                    break;
                                case 3:
                                    System.out.print("Nhap vi tri muon xoa:");
                                    dsPhongThi.layPhongThi(index).getSinhVien().xoaPT(Integer.parseInt(scan.nextLine()));
                                    break;
                                case 4:
                                    dsPhongThi.layPhongThi(index).getGiamThi().themPT();
                                    break;
                                case 5:
                                    System.out.print("Nhap vi tri muon xoa:");
                                    dsPhongThi.layPhongThi(index).getGiamThi().xoaPT(Integer.parseInt(scan.nextLine()));
                                    break;
                                case 6:
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!!!");
                                    break;
                            }
                        }
                        break;
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
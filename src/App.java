import java.util.Scanner;
public class App {
    private static Scanner scan = new Scanner(System.in);
    private static DSPhongThi dsPhongThi = new DSPhongThi();
    private static BoCauHoi boCauHoi = new BoCauHoi();
    private static String FilePhongThi = "DSPhong.txt";
    private static String FileCauHoi = "CauHoi.txt";
    private static ThongKe thongKe = new ThongKe();
    private static String MatKhau = "12345";
    private static KetQua[]   ketQua;
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
        ketQua = new KetQua[dsPhongThi.getN()];
        int vitri = -1, TongViPham, ViPham;
        boolean Loop = true;
        menuDangNhap();
        while (Loop){
            vitri++;
            PhongThi Phong = thietLapPhongThi();
            Phong.sapXep();
            ketQua[vitri] = new KetQua(Phong);
            Thi thi;
            SinhVien sv;
            HocPhan hocPhan;
            boolean flag = true;
            do {
                TongViPham = 0;
                sv = menuSinhVien(Phong.getSinhVien());
                if (sv.getCamthi()){
                    System.out.println("Ban Da bi Cam thi!!!");
                    System.out.println("Vui long lien he Giam Thi!!!!");
                }
                else{
                    hocPhan = Phong.getBienBan().hp;
                    thi = new Thi(sv, boCauHoi, Phong.getBienBan().hp, Phong.getBienBan().getStringNgay(),
                            Phong.getBienBan().ThoiGianLam);
                    clearScreen();
                    int n = Phong.getBienBan().hp.getSoCau();
                    for (int i = 0; i < n; i++) {
                        thi.menuThi(i, scan);
                    }
                    double diem = thi.tinhDiem();
                    thongKe.thongkeDiem(diem, hocPhan.getMaHocPhan());
                    thongKe.thongkeNam(sv.MaSo, sv.GioiTinh);
                    System.out.println("Chuc Mung ban da hoan thanh Bai Thi");
                    System.out.println("Diem ban dat duoc la: " + diem);

                    System.out.println();
                    System.out.println();
                    System.out.println("HAY GIU NGUYEN MAN HINH VA THONG BAO CHO CAN BO COI THI");
                    scan.nextLine();

                    System.out.print("Hay nhap so Vi Pham ma Sinh Vien thuc hien: ");
                    ViPham = Integer.parseInt(scan.nextLine());
                    TongViPham += ViPham;
                    ketQua[vitri].nhapDiem(sv.MaSo, diem, ViPham);              
                    System.out.println("Nhap ki tu bat ky de THOAT!");
                    scan.nextLine();
                    clearScreen();
                }
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
            clearScreen();
            do {

                
                System.out.println("Chuyen Sang Phong Thi khac?");
                System.out.println("0. No ! Khong Thi nua");
                System.out.println("1. Yes! Tiep Tuc Thi");
                System.out.println("2. Xem Bang diem cua Phong hien tai");
                System.out.print("Lua chon: ");
                switch (Integer.parseInt(scan.nextLine())) {
                    case 0:
                        flag = false;
                        Loop = false;
                        break;
                    case 1:
                        flag = false;
                        break;
                    case 2:
                        clearScreen();
                        ketQua[vitri].xuatDS(TongViPham);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!!!");
                        System.out.println();
                        break;
                }
            } while (flag);
            ketQua[vitri].xuatFile();
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
            System.out.println("5. In Danh Sach");
            System.out.println("6. Thoat");
            n = Integer.parseInt(scan.nextLine());
            clearScreen();
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
                            System.out.println("0. Xem Phong Thi");
                            System.out.println("1. Cap nhat Thong Tin co san");
                            System.out.println("2. Them Sinh Vien");
                            System.out.println("3. Xoa Sinh Vien");
                            System.out.println("4. Them Giam Thi");
                            System.out.println("5. xoa Giam thi");
                            System.out.println("6. Thoat");
                            switch (Integer.parseInt(scan.nextLine())){
                                case 0:
                                    clearScreen();
                                    dsPhongThi.layPhongThi(index).xuatThongTin();
                                    scan.nextLine();
                                    break;
                                case 1:
                                    clearScreen();
                                    dsPhongThi.layPhongThi(index).capNhat();
                                    break;
                                case 2:
                                    clearScreen();
                                    dsPhongThi.layPhongThi(index).getSinhVien().themPT(scan);
                                    scan.nextLine();
                                    break;
                                case 3:
                                    clearScreen();
                                    System.out.print("Nhap vi tri muon xoa:");
                                    dsPhongThi.layPhongThi(index).getSinhVien().xoaPT(Integer.parseInt(scan.nextLine()));
                                    scan.nextLine();
                                    break;
                                case 4:
                                    clearScreen();
                                    dsPhongThi.layPhongThi(index).getGiamThi().themPT(scan);
                                    scan.nextLine();
                                    break;
                                case 5:
                                    clearScreen();
                                    System.out.print("Nhap vi tri muon xoa:");
                                    dsPhongThi.layPhongThi(index).getGiamThi().xoaPT(Integer.parseInt(scan.nextLine()));
                                    break;
                                case 6:
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le!!!");
                                    System.out.println("Nhap 1 de lua chon lai");
                                    if (Integer.parseInt(scan.nextLine()) != 1)
                                        loop = false;
                                    break;
                            }
                            clearScreen();
                        }
                        break;
                    }
                    break;
                case 5:
                    for (int i = 0; i < dsPhongThi.getN(); i++){
                        System.out.println();
                        System.out.println();
                        System.out.println("===========================================================================");
                        System.out.println();
                        System.out.println();

                        dsPhongThi.layPhongThi(i).xuatThongTin();
                    }
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
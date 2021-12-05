import java.util.Scanner;
public class GiamThi extends ConNguoi{
    private String HocVi;
    GiamThi(){}
    GiamThi(String Ten, int MaSo, String  Hocvi, String NgaySinh){
        super(Ten, MaSo, NgaySinh);
        this.HocVi = Hocvi;
    }
    public String getHocVi() {
        return HocVi;
    }
    @Override
    public void capNhat() {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Chon muc can chinh sua:");
            System.out.println("1. Ten\n2. Maso\n3. HocVi\n4. NgaySinh\n5. Thoat");
            System.out.print("Chon: ");
            n = scan.nextInt();
            switch (n){
                case 1:
                    System.out.print("Nhap Ten moi: ");
                    Ten = scan.nextLine();
                    break;
                case 2:
                    do{
                        System.out.print("Nhap Maso moi: ");
                        MaSo = Integer.parseInt(scan.nextLine());
                    }   while(MaSo < 0);
                    break;
                case 3:
                    System.out.print("Nhap HocVi moi: ");
                    HocVi = scan.nextLine();
                    break;
                case 4:
                    System.out.print("Nhap Ngay sinh moi: ");
                    NgaySinh = new ThoiGian(scan.nextLine());
                    break;
            }
        }while (n!= 5);   
    }
}


import java.util.Scanner; 
public class CauHoi implements ChinhSua{
    private String NoiDung;
    private String PhuongAnA;
    private String PhuongAnB;
    private String PhuongAnC;
    private String PhuongAnD;
    private String DapAn;
    public CauHoi() {
    }

    public CauHoi( String NoiDung, String PhuongAnA, String PhuongAnB, String PhuongAnC, String PhuongAnD, String DapAn) {
        this.NoiDung = NoiDung;
        this.PhuongAnA = PhuongAnA;
        this.PhuongAnB = PhuongAnB;
        this.PhuongAnC = PhuongAnC;
        this.PhuongAnD = PhuongAnD;
        this.DapAn = DapAn;
    }

   

    public String getNoiDung() {
        return NoiDung;
    }

    public String getPhuongAnA() {
        return PhuongAnA;
    }

    public String getPhuongAnB() {
        return PhuongAnB;
    }

    public String getPhuongAnC() {
        return PhuongAnC;
    }

    public String getPhuongAnD() {
        return PhuongAnD;
    }

    public String getDapAn() {
        return DapAn;
    }


    @Override
    public void chinhSua() {
    Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Chon muc can chinh sua:");
            System.out.println("1. NoiDung\n2. PhuongAnA\n3. PhuongAnB\n4. PhuongAnC\n5. PhuongAnD\n6. DapAn\n7. Thoat");
            System.out.print("Chon: ");
            n = scan.nextInt();
            switch (n){
                case 1 -> {
                    System.out.print("Nhap noi dung cau hoi: ");
                    NoiDung = scan.nextLine();
                }
                case 2 -> {
                    System.out.print("Nhap phuong an A: ");
                    PhuongAnA = scan.nextLine();
                }
                case 3 -> {
                    System.out.print("Nhap phuong an B: ");
                    PhuongAnB = scan.nextLine();
                }
                case 4 -> {
                    System.out.print("Nhap phuong an C: ");
                    PhuongAnC = scan.nextLine();
                }
                case 5 -> {
                    System.out.print("Nhap phuong an D: ");
                    PhuongAnD = scan.nextLine();
                }
                case 6 -> {
                    System.out.print("Nhap dap an : ");
                    DapAn = scan.nextLine();
                }
                default -> System.out.print("Lua chon khong hop le!");
            }
        }while (n!= 7);
    }
    @Override
    public void nhap() {   
        chinhSua(); 
    }
    @Override
    public void xuat() {
            System.out.println("Noi dung cau hoi: " + NoiDung);
            System.out.println("Phuong an A: " + PhuongAnA);
            System.out.println("Phuong an B: " + PhuongAnB);
            System.out.println("Phuong an C: " + PhuongAnC);
            System.out.println("Phuong an D: " + PhuongAnD);
            System.out.println("Dap an la: " + DapAn);
        }
}




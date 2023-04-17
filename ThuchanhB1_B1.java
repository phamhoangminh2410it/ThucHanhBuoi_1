import java.util.Scanner;
import java.util.Arrays;
public class ThuchanhB1_B1 {
    static Scanner sc = new Scanner(System.in);

    static void inputInfo(SinhVien nhap) {
        System.out.println("Nhap ho ten Sinh vien: ");
        nhap.setHoTen(sc.nextLine());
        System.out.println("Nhap dia chi Sinh vien");
        nhap.setDiaChi(sc.nextLine());
        System.out.println("Nhap ma Sinh vien: ");
        nhap.setMssv(sc.nextInt());
        ;
        sc.nextLine();
        do {
            System.out.println("Yeu cau nhap SDT 9 so: ");
            nhap.setSoDienThoai(sc.nextLine());
        } while (nhap.getSoDienThoai().length() != 9);
    }

    static void menu() {
        System.out.println("|---------------------------------------------|");
        System.out.println("|             VUI LONG CHON                   |");
        System.out.println("|=============================================|");
        System.out.println("|1. NHAP THONG TIN SINH VIEN                  |");
        System.out.println("|2. XUAT THONG TIN SINH VIEN                  |");
        System.out.println("|3. EXIT                                      |");
        System.out.println("|=============================================|");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien sv[] = null;
        int a, n = 0;
        boolean c = true;
        do {
            menu();
            System.out.print("Nhap yeu cau: ");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.print("Nhap So Luong Sinh Vien: ");
                    n = sc.nextInt();
                    sv = new SinhVien[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh Vien Thu " + (i + 1)+": ");
                        sv[i] = new SinhVien();
                        inputInfo(sv[i]);
                    }
                    break;
                case 2:
                    SinhVien temp = sv[0];
                    for (int i = 0; i < sv.length - 1; i++) {
                        for (int j = i + 1; j < sv.length; j++) {
                            if (sv[i].getMssv() > sv[j].getMssv()) {
                                temp = sv[j];
                                sv[j] = sv[i];
                                sv[i] = temp;
                            }
                        }
                    }
                    System.out.printf("%-5s %15s %15s %20s \n", "MSSV", "Ho va Ten", "Dia Chi", "So Dien Thoai");
                    for (int i = 0; i < n; i++) {
                        sv[i].showInfo();
                    }
                    break;
                default:
                    System.out.println("Ket Thuc");
                    c = false;
                    break;
            }
        }while (c);
    }
}
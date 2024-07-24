import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HocVien {
    String maSo;
    String ten;
    String lop;
    double diem;

    HocVien(String maSo, String ten, String lop, double diem) {
        this.maSo = maSo;
        this.ten = ten;
        this.lop = lop;
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "HocVien [maSo=" + maSo + ", ten=" + ten + ", lop=" + lop + ", diem=" + diem + "]";
    }
}

class GiangVien {
    String maSo;
    String ten;

    GiangVien(String maSo, String ten) {
        this.maSo = maSo;
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "GiangVien [maSo=" + maSo + ", ten=" + ten + "]";
    }
}

public class Exemple {
    static ArrayList<HocVien> danhSachHocVien = new ArrayList<>();
    static ArrayList<GiangVien> danhSachGiangVien = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Thêm học viên");
            System.out.println("2. Sửa học viên");
            System.out.println("3. Xóa học viên");
            System.out.println("4. Sắp xếp học viên theo điểm");
            System.out.println("5. Thêm giảng viên");
            System.out.println("6. Sửa giảng viên");
            System.out.println("7. Xóa giảng viên");
            System.out.println("8. Sắp xếp giảng viên theo tên");
            System.out.println("9. Hiển thị danh sách học viên");
            System.out.println("10. Hiển thị danh sách giảng viên");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1:
                    themHocVien();
                    break;
                case 2:
                    suaHocVien();
                    break;
                case 3:
                    xoaHocVien();
                    break;
                case 4:
                    sapXepHocVienTheoDiem();
                    break;
                case 5:
                    themGiangVien();
                    break;
                case 6:
                    suaGiangVien();
                    break;
                case 7:
                    xoaGiangVien();
                    break;
                case 8:
                    sapXepGiangVienTheoTen();
                    break;
                case 9:
                    hienThiDanhSachHocVien();
                    break;
                case 10:
                    hienThiDanhSachGiangVien();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    public static void themHocVien() {
        System.out.print("Nhập mã số: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        String lop = scanner.nextLine();
        System.out.print("Nhập điểm: ");
        double diem = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        danhSachHocVien.add(new HocVien(maSo, ten, lop, diem));
    }

    public static void suaHocVien() {
        System.out.print("Nhập mã số học viên cần sửa: ");
        String maSo = scanner.nextLine();
        for (HocVien hv : danhSachHocVien) {
            if (hv.maSo.equals(maSo)) {
                System.out.print("Nhập tên mới: ");
                hv.ten = scanner.nextLine();
                System.out.print("Nhập lớp mới: ");
                hv.lop = scanner.nextLine();
                System.out.print("Nhập điểm mới: ");
                hv.diem = scanner.nextDouble();
                scanner.nextLine();
                return;
            }
        }
        System.out.println("Không tìm thấy học viên với mã số " + maSo);
    }

    public static void xoaHocVien() {
        System.out.print("Nhập mã số học viên cần xóa: ");
        String maSo = scanner.nextLine();
        danhSachHocVien.removeIf(hv -> hv.maSo.equals(maSo));
    }

    public static void sapXepHocVienTheoDiem() {
        Collections.sort(danhSachHocVien, Comparator.comparingDouble(hv -> hv.diem));
    }

    public static void themGiangVien() {
        System.out.print("Nhập mã số: ");
        String maSo = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        danhSachGiangVien.add(new GiangVien(maSo, ten));
    }

    public static void suaGiangVien() {
        System.out.print("Nhập mã số giảng viên cần sửa: ");
        String maSo = scanner.nextLine();
        for (GiangVien gv : danhSachGiangVien) {
            if (gv.maSo.equals(maSo)) {
                System.out.print("Nhập tên mới: ");
                gv.ten = scanner.nextLine();
                return;
            }
        }
        System.out.println("Không tìm thấy giảng viên với mã số " + maSo);
    }

    public static void xoaGiangVien() {
        System.out.print("Nhập mã số giảng viên cần xóa: ");
        String maSo = scanner.nextLine();
        danhSachGiangVien.removeIf(gv -> gv.maSo.equals(maSo));
    }

    public static void sapXepGiangVienTheoTen() {
        Collections.sort(danhSachGiangVien, Comparator.comparing(gv -> gv.ten));
    }

    public static void hienThiDanhSachHocVien() {
        for (HocVien hv : danhSachHocVien) {
            System.out.println(hv);
        }
    }

    public static void hienThiDanhSachGiangVien() {
        for (GiangVien gv : danhSachGiangVien) {
            System.out.println(gv);
        }
    }
}


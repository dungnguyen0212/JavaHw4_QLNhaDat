package quanlydatdat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyGiaoDich {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<GiaoDich> list = new ArrayList<>();

    public static void themGiaoDich(int choice3) {
        GiaoDich giaoDich;
        if (choice3 == 1)
            giaoDich = taoGiaoDichDat();
        else
            giaoDich = taoGiaoDichNha();

        list.add(giaoDich);
    }

    private static GiaoDichDat taoGiaoDichDat() {
        System.out.println("Nhap ma giao dich: ");
        int maGiaoDich = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay giao dich: ");
        String ngayGiaoDich = sc.nextLine();
        System.out.println("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap loai dat(A/B/C): ");
        String loai = sc.nextLine();
        System.out.println("Nhap dien tich: ");
        double dienTich = Double.parseDouble(sc.nextLine());

        GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, loai, dienTich);
        return giaoDichDat;

    }

    private static GiaoDichNha taoGiaoDichNha() {
        System.out.println("Nhap ma giao dich: ");
        int maGiaoDich = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay giao dich: ");
        String ngayGiaoDich = sc.nextLine();
        System.out.println("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap loai nha(cao cap/binh dan): ");
        String loai = sc.nextLine();
        System.out.println("Nhap dien tich: ");
        double dienTich = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap dia chi: ");
        String diaChi = sc.nextLine();


        GiaoDichNha giaoDichNha = new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, loai, dienTich, diaChi);
        return giaoDichNha;
    }

    public static void tongSoluong(int choice1) {
        int count1 = 0;
        int count2 = 0;
        for (GiaoDich g : list) {
            if (g instanceof GiaoDichDat) {
                count1++;
            } else if (g instanceof GiaoDichNha) {
                count2++;
            }
        }
        if (choice1 == 1)
            System.out.println("So giao dich Dat: " + count1);
        else
            System.out.println("So giao dich Nha: " + count2);

    }

    public static void xoaGiaoDichTheoNgay() {
        System.out.println("Nhap ngay: ");
        String ngayGiaoDich = sc.nextLine();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNgayGiaoDich().equals(ngayGiaoDich))
                index = i;
        }
        if (index == -1)
            System.out.println("Khong co giao dich nay");
        else
            list.remove(index);

    }

    public static void sapXep() {
        Collections.sort(list, new Comparator<GiaoDich>() {
            @Override
            public int compare(GiaoDich o1, GiaoDich o2) {
                if (o1.getMaGiaoDich() > o2.getMaGiaoDich()) return 1;
                else return -1;
            }
        });
    }

    public static void timGiaoDich() {
        System.out.println("Nhap ma giao dich");
        int maGiaoDich = Integer.parseInt(sc.nextLine());
        int index = binarySearch(maGiaoDich);
        if (index == -1) {
            System.out.println("Khong co ket qua");
        } else {
            System.out.println(list.get(index));
        }
    }
    private static int binarySearch(int maGiaoDich) {
        int dau = 0;
        int cuoi = list.size() - 1;
        while (dau <= cuoi) {
            int mid = (dau + cuoi) / 2;
            if (maGiaoDich > list.get(mid).getMaGiaoDich())
                dau = mid + 1;
            else if (maGiaoDich == list.get(mid).getMaGiaoDich())
                return mid;
            else
                cuoi = mid - 1;
        }
        return -1;
    }

    public static void showGiaoDich() {
        for (GiaoDich g : list)
            System.out.println(g);
    }
}

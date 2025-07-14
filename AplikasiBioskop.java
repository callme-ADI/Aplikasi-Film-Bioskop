import java.util.Scanner;

public class AplikasiBioskop {
    static Scanner input = new Scanner(System.in);
    static String[] judulFilm = new String[10];
    static int jumlahFilm = 0;

    public static void main(String[] args) {
        if (login()) {
            int pilihan;
            do {
                tampilkanMenu();
                System.out.print("Pilih: ");
                pilihan = input.nextInt();
                input.nextLine(); // membersihkan buffer
                switch (pilihan) {
                    case 1:
                        tampilkanFilm();
                        break;
                    case 2:
                        inputFilm();
                        break;
                    case 3:
                        cariFilm();
                        break;
                    case 4:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 4);
        }
    }

    static boolean login() {
        System.out.println("=== LOGIN ===");
        while (true) {
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String pass = input.nextLine();

            if (user.equals("admin") && pass.equals("12345")) {
                System.out.println("Login berhasil!\n");
                return true;
            } else {
                System.out.println("Username atau password salah. Coba lagi.\n");
            }
        }
    }

    static void tampilkanMenu() {
        System.out.println("=== MENU UTAMA ===");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Keluar");
    }

    static void inputFilm() {
        if (jumlahFilm >= 10) {
            System.out.println("Kapasitas penuh! Tidak bisa menambah film lagi.");
            return;
        }

        System.out.print("Masukkan jumlah film yang ingin ditambahkan: ");
        int jumlah = input.nextInt();
        input.nextLine(); // membersihkan buffer

        for (int i = 0; i < jumlah; i++) {
            if (jumlahFilm >= 10) {
                System.out.println("Kapasitas maksimal tercapai.");
                break;
            }

            System.out.println("Film ke-" + (jumlahFilm + 1));
            System.out.print("Judul: ");
            judulFilm[jumlahFilm] = input.nextLine();
            jumlahFilm++;
        }
    }

    static void tampilkanFilm() {
        if (jumlahFilm == 0) {
            System.out.println("Belum ada data film.");
        } else {
            System.out.println("=== DAFTAR FILM ===");
            for (int i = 0; i < jumlahFilm; i++) {
                System.out.println((i + 1) + ". " + judulFilm[i]);
            }
        }
    }

    static void cariFilm() {
        System.out.print("Masukkan judul film yang dicari: ");
        String cari = input.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < jumlahFilm; i++) {
            if (judulFilm[i].equalsIgnoreCase(cari)) {
                System.out.println("Film ditemukan: " + judulFilm[i]);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Film tidak ditemukan.");
        }
    }
}

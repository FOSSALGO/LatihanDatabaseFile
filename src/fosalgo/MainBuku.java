package fosalgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainBuku {

    public static void main(String[] args) {
        ArrayList<Buku> tabelBukuDariFile = readTabelBukuFromFile("file_tabel_buku.txt");
        ArrayList<Buku> tabelBuku = new ArrayList<>();
        if (tabelBukuDariFile != null) {
            tabelBuku = tabelBukuDariFile;
        }

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--------------------------");
            System.out.println("Pilih Menu");
            System.out.println("[V] tampilkan data buku");
            System.out.println("[T] tambah data");
            System.out.println("[S] save data buku to file");
            System.out.println("[X] exit");
            System.out.println("--------------------------");
            System.out.print("Menu yang anda pilih: ");
            String menu = sc.nextLine();

            if (menu.equalsIgnoreCase("T")) {
                System.out.println("Anda memilih menu Tambah Data");
                System.out.print("Input ID Buku   : ");
                String strId = sc.nextLine();
                int id = Integer.parseInt(strId);

                System.out.print("Input Judul Buku: ");
                String judul = sc.nextLine();

                System.out.print("Input Penerbit  : ");
                String penerbit = sc.nextLine();

                System.out.print("Input Harga Buku: ");
                String strHarga = sc.nextLine();
                double harga = Double.parseDouble(strHarga);

                System.out.print("Input Stock     : ");
                String strStock = sc.nextLine();
                int stock = Integer.parseInt(strStock);

                Buku buku = new Buku(id, judul, penerbit, harga, stock);//membuat object buku
                tabelBuku.add(buku);//menambahkan buku ke dalam ArrayList tabelBuku

            } else if (menu.equalsIgnoreCase("V")) {
                System.out.println("=====================================");
                System.out.println("|             Tabel Buku             |");
                System.out.println("=====================================");
                for (Buku b : tabelBuku) {
                    System.out.println(b);
                }

            } else if (menu.equalsIgnoreCase("S")) {
                System.out.println("SAVE TO FILE");
                saveTabelBukuToFile(tabelBuku, "file_tabel_buku.txt");                
            }else if (menu.equalsIgnoreCase("X")) {
                System.out.println("Proses Input DIAKHIRI");
                System.out.println("SAVE TO FILE");
                saveTabelBukuToFile(tabelBuku, "file_tabel_buku.txt");
                running = false;
            }else{
                System.out.println("PILIHAN ANDA TIDAK ADA DI MENU");                
                System.out.println("APAKAH ANDA BUTUH AKUA?");
            }
        }
       //------------------
    }

    public static boolean saveTabelBukuToFile(ArrayList<Buku> tabelBuku, String url) {
        boolean result = false;
        try {
            if (tabelBuku != null && !tabelBuku.isEmpty() && url != null) {
                FileWriter fw = new FileWriter(url);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Buku b : tabelBuku) {
                    bw.append(b.toString());
                    bw.append("\n");
                }
                bw.close();
                fw.close();
                result = true;
            }
        } catch (IOException e) {
            System.err.println("PROSES PENYIMPANAN DATA KE FILE GAGAL");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Buku> readTabelBukuFromFile(String url) {
        ArrayList<Buku> data = null;
        try {
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            data = new ArrayList<>();
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] elemnts = baris.split(";");
                String strId = elemnts[0];
                int id = Integer.parseInt(strId);

                String judul = elemnts[1];

                String penerbit = elemnts[2];

                String strHarga = elemnts[3];
                double harga = 12;//Double.parseDouble(strHarga.trim());

                String strStock = elemnts[3];
                int stock = 12;//Integer.parseInt(strStock);

                String strTerjual = elemnts[4];
                int terjual = 14;//Integer.parseInt(strTerjual);

                Buku buku = new Buku(id, judul, penerbit, harga, stock, terjual);//membuat object buku
                data.add(buku);//menambahkan buku ke dalam ArrayList tabelBuku
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("PROSES PEMBACAAN DATA DATA FILE GAGAL");
            e.printStackTrace();
        }
        return data;
    }
}

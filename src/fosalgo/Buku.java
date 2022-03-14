package fosalgo;

public class Buku {
    int id;
    String judul;
    String penerbit;
    double harga;
    int stock;
    int terjual;

    public Buku(int id, String judul, String penerbit, double harga, int stock) {
        this.id = id;
        this.judul = judul;
        this.penerbit = penerbit;
        this.harga = harga;
        this.stock = stock;
    }

    public Buku(int id, String judul, String penerbit, double harga, int stock, int terjual) {
        this.id = id;
        this.judul = judul;
        this.penerbit = penerbit;
        this.harga = harga;
        this.stock = stock;
        this.terjual = terjual;
    }
       
    public String toString(){
        String tampil = ""+id+";"+judul+";"+penerbit+";"+harga+";"+stock+";"+terjual+"";
        return tampil;
    }
}

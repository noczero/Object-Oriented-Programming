package testkasir;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zero-Inside
 */
public class StokBarang {
    private String nama;
    private int jumlah;
    private double harga;
    private Transaksi[] daftarTransaksi = new Transaksi[100];
    private int jumlahTransaksi = 0;
    
    public StokBarang(String nama , double harga){
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 1000;
    }
    
    public StokBarang(String nama , int jumlah , double harga){
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public int getJumlah(){
        return this.jumlah;
    }
    
    public void jualBarang(int n , String pelanggan){
        if (this.jumlah >= n) {
            daftarTransaksi[jumlahTransaksi] = new Transaksi(pelanggan, this, n);
            this.jumlah = this.jumlah - n;
            jumlahTransaksi++;
        } else {
            System.out.println("Maaf Pembelian Melebihi Stok Barang");
        }
    }
    
    public double getHarga(){
        return this.harga;
    }
    
    public Transaksi getTransaksi(int i){
        return daftarTransaksi[i];
    }
    
    public int getJumlahTransaksi(){
        return this.jumlahTransaksi;
    }
    
}

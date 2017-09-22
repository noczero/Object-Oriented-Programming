/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testkasir;

/**
 *
 * @author Zero-Inside
 */
public class Kasir {
    private String nama;
    private StokBarang[] daftarStokBarang;
    private int jumlahStokBarang;
    private Transaksi[] daftarTransaksi;
    private int jumlahTransaksi;
    
    public Kasir(String nama , int maxJumlahBarang , int maxJumlahTransaksi){
        this.nama = nama;
        this.daftarStokBarang = new StokBarang[maxJumlahBarang];
        this.daftarTransaksi = new Transaksi[maxJumlahTransaksi];
              
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void tambahBarang(StokBarang sb){
        if (this.jumlahStokBarang < this.daftarStokBarang.length){
            daftarStokBarang[jumlahStokBarang] = sb;
            jumlahStokBarang++;
        } else {
            System.out.println("Error, out of range");
        }
    }
    
    public StokBarang getStokBarang(int i){
        return daftarStokBarang[i];
    }
    
    public int getJumlahBarang(int i){
        return daftarStokBarang[i].getJumlah();
    }
    
    public void tambahTransaksi(StokBarang sb, String Pelanggan , int jumlah){
       if (jumlahTransaksi < daftarTransaksi.length) {
        daftarTransaksi[this.jumlahTransaksi] = new Transaksi(Pelanggan, sb , jumlah);
        sb.jualBarang(jumlah, Pelanggan);
        this.jumlahTransaksi++;
       } else {
           System.out.println("Error, out of range");
       }
    }
    
    public Transaksi getTransaksi(int i){
        return daftarTransaksi[i];
    }
    
    public int getJumlahTransaksi(){
        return this.jumlahTransaksi;
    }
    
    public double getTotalTransaksi(){
        double total = 0;
        
        for (Transaksi pecah : daftarTransaksi) {
            total += pecah.getTotalHarga();
        }
        
        return total;
    }
    
    public int getJumlahBarang(){
        return this.jumlahStokBarang;
    }
    
    
}

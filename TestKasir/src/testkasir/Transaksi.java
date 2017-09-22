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
public class Transaksi {
    private String pelanggan;
    private String namaBarang;
    private int jumlahBarang;
    private double harga;

       public Transaksi(String pelanggan , StokBarang sb, int jumlah){
           this.namaBarang = sb.getNama();
           this.jumlahBarang = jumlah;
           this.harga = sb.getHarga();
       }
       
       public String getPelanggan(){
           return this.pelanggan;
       }
       
       public String getNamaBarang(){
           return this.namaBarang;
       }
       
       public int getJumlahBarang(){
           return this.jumlahBarang;
       }
       
      public double getHarga(){
          return this.harga;
      } 
       
      
       public double getTotalHarga(){
           return this.harga * this.jumlahBarang;
       }
              
}

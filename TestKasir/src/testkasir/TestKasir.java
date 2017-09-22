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
public class TestKasir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Kasir kasir1 = new Kasir("Fauzan" , 10 , 20);
        Kasir kasir2 = new Kasir("Deni" , 15 , 18);
        
        StokBarang barang1 = new StokBarang("Oreo", 1500 , 7200);
        StokBarang barang2 = new StokBarang("Indomie Goreng" , 3000 , 2500);
        StokBarang barang3 = new StokBarang("Teh Pucuk" , 3500);
        StokBarang barang4 = new StokBarang("Rinso ANti Noda" , 750 , 14400);
        StokBarang barang5 = new StokBarang("Pepsodent" , 300 , 10000);
        StokBarang barang6 = new StokBarang("Fanta ", 11000);
    
        
        kasir1.tambahBarang(barang1);
                kasir1.tambahBarang(barang2);
        kasir1.tambahBarang(barang3);
        kasir1.tambahBarang(barang6);
        
        kasir2.tambahBarang(barang1);
                kasir2.tambahBarang(barang3);
        kasir2.tambahBarang(barang4);
        kasir2.tambahBarang(barang5);
        
        kasir1.tambahTransaksi(kasir1.getStokBarang(2), "A", 40);
        kasir1.tambahTransaksi(kasir1.getStokBarang(1), "Bintang", 100);
        kasir1.tambahTransaksi(kasir1.getStokBarang(2), "Rizza", 17);
        kasir1.tambahTransaksi(kasir1.getStokBarang(3), "Rahmat", 20);
        kasir2.tambahTransaksi(kasir2.getStokBarang(3), "Putro", 70);
        kasir2.tambahTransaksi(kasir2.getStokBarang(1), "Bintang", 10);
        kasir2.tambahTransaksi(kasir2.getStokBarang(0), "Ucup", 15);


        int totalPenjualan = 0;
        double totalPendapatan = 0;
        
        System.out.println("Laporan Penjualan " + kasir1.getNama());
        for (int i = 0 ; i < kasir1.getJumlahBarang(); i++){
            totalPenjualan  = 0;
            System.out.println("Nama Barang     : " + kasir1.getStokBarang(i).getNama() );
            System.out.println("Stok Barang yang tersedia : " + kasir1.getStokBarang(i).getJumlah());
        
            for (int j = 0; j < kasir1.getJumlahTransaksi(); j++){
                if (kasir1.getTransaksi(j).getNamaBarang().equals(kasir1.getStokBarang(i).getNama())){
                    totalPenjualan += kasir1.getTransaksi(j).getJumlahBarang();
                }
            }
            System.out.println("Jumlah yang terjual : " + totalPenjualan);
        }
    }
    
}

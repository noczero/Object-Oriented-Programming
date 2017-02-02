/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul1;
import java.util.*;
/**
 *
 * @author zeroone
 */
public class Modul1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan Jam Masuk (hh mm): ");
        int jamMasuk = Integer.parseInt(input.nextLine());
        int menitMasuk = Integer.parseInt(input.nextLine());
        
        System.out.println("Masukkan Jam Keluar (hh mm) : ");
        int jamKeluar = Integer.parseInt(input.nextLine());
        int menitKeluar = Integer.parseInt(input.nextLine());
        
        int harga = hitungBiaya(jamMasuk , menitMasuk , jamKeluar , menitKeluar);
        System.out.println("harga = " + harga);
        
    }
    
   public static int hitungBiaya(int jamMasuk , int menitMasuk , int jamKeluar, int menitKeluar){
       int total = 0;
       
       int totalMenit_Masuk = toMinutes(jamMasuk , menitMasuk);
       int totalMenit_Keluar = toMinutes(jamKeluar , menitKeluar);
       
       int selisih = totalMenit_Keluar - totalMenit_Masuk;
       
       int totalJam = selisih / 60;
       int sisaMenit = selisih % 60;
       System.out.println("========= Lama Parkir ==========");
       System.out.println("Total Jam : " + totalJam);
       System.out.println("Total Menit : " + sisaMenit);
       
       int Harga = 2000;
       if (sisaMenit > 30) {
           Harga += 1000;
       } else {
           total = Harga * totalJam;
       }
       
       return total;
   }
   
   public static int toMinutes(int jam , int menit) {
       int totalDetik;
       
       totalDetik = (jam * 60) + menit;
       
       return totalDetik;
   }
}

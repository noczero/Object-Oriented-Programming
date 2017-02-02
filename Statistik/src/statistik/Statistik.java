/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistik;
import java.util.*;
/**
 *
 * @author zeroone
 */
public class Statistik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
   
        System.out.println("Masukkan jumlah nilai yang ingin dihitung : ");
        int length = Integer.parseInt(input.nextLine());
        int[] nilai = new int[length];
        
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Masukkan nilai - " +  (i+1));
            nilai[i] = Integer.parseInt(input.nextLine());
        }
        
        tampil(nilai);
        hitungRata(nilai);
        minMax(nilai);
    }
    
    public static void tampil(int[] array){
        
        for (int i : array) {
            System.out.println("Nilai  : " + i);
        }
    }
    
    public static void hitungRata(int[] array){
        int jumlah = 0;
        
        for (int i = 0 ; i < array.length ; i++){
            jumlah += array[i];
        }
        
        double average = jumlah / array.length;
        
        System.out.println("Rata - Rata : " + average);
    }
    
    public static void minMax(int[] array) {
        int min = Integer.MAX_VALUE,  max = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < array.length; i++) {
                
            if (array[i] > max) {
                max = array[i];
            }
            
            if (array[i] < min){
                min = array[i];
            }
            
        }
        
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }

}

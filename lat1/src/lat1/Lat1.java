/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lat1;
import java.util.*;
/**
 *
 * @author zeroone
 */
public class Lat1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        profile test = new profile();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Type your name : ");
        String nama = input.nextLine();
        System.out.println("Input your age : ");
        int umur = Integer.parseInt(input.nextLine());
       
        System.out.println("Input your address : ");
        String address = input.nextLine();
        System.out.println("Input your salary : ");
        int salary = Integer.parseInt(input.nextLine());
        
        test.setNama(nama);
        test.setUmur(umur);
        test.setTotal(salary);
        test.setAlamat(address);
        
        System.out.println("Your name is \t : " + test.getNama());
        System.out.println("Your age is \t : " + test.getUmur());
        System.out.println("salary = " + test.getTotal());
        System.out.println("address = " +test.getAlamat());
        
        
        //Calculator
        calculator calculator = new calculator();
        System.out.println("New Calculator");
//        double bil1 = Double.parseDouble(input.nextLine());
        double bil1 = input.nextDouble();
//        System.out.println("Masukkan Operator");
////        char opr = input.nextLine().charAt(0);
        char opr = input.next().charAt(0);
//        System.out.println("Masukkan Bilangan kedua");
//        double bil2 = Double.parseDouble(input.nextLine());
        double bil2 = input.nextDouble();
        calculator.hitung(bil1, opr, bil2);
        
        System.out.println("Jumlah \t :" + calculator.jumlah());
        
    }
    
}

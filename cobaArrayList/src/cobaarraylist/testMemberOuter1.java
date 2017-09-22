/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobaarraylist;

/**
 *
 * @author Zero-Inside
 */

import java.util.*;

public class testMemberOuter1 {

    /**
     * @param args the command line arguments
     */
    
    public static class  Test {
        String nama;
        int nilai;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        InnerClass testInerr = new InnerClass();
        
        testInerr.display();
        
        ArrayList<String> obj = new ArrayList<String>();
        ArrayList<Integer> obj2 = new ArrayList<Integer>();
        
        Test ea = new Test();
        ea.nama = "Bege";
        ea.nilai = 10;
        
        obj.add("pertama");
        obj.add("kedua");
        obj.add("tiga");
        obj.add(ea.nama + ea.nilai);
        
        obj2.add(1);
        obj2.add(2);
        obj2.add(3);
        
        System.out.println(obj);
        System.out.println(obj2);
        
        
        for (String pecah:obj){
            System.out.println(pecah);
        }
        
        for (Integer pecah:obj2){
            System.out.println(pecah);
        }
        
        for (String a : obj) {
            System.out.println(a);   
        }
        
        Iterator printObj = obj2.iterator();
        
        while (printObj.hasNext()){
            System.out.println(printObj.next());
        }
    }
    
}

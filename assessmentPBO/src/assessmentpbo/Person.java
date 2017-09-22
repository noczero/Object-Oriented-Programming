/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessmentpbo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Zero-Inside
 */
public class Person  {
    ArrayList<Animal> binatang = new ArrayList();
    
    private String nama;
    public Person( String nama) {
        this.nama = nama;
    }
    
    public void addBinatang(Animal animal) {
        binatang.add(animal);
    }
    
    public String getName(){
        return this.nama;
    }
    
    @Override
    public String toString(){
        return this.nama;
    }
    
    public String displayAnimal() {
        String animalList = null;
        for (Animal x : binatang) {
            animalList = x.species + x.moveable();
        }
        return animalList;
    }
    
    public void displayAnimal1(){
        //        binatang.forEach(System.out::println);
        ArrayList<Animal> listBird = new ArrayList();
        ArrayList<Animal> listFish = new ArrayList();
        ArrayList<Animal> listMamalia = new ArrayList();
        
        for (Animal x : binatang) {
            if (x instanceof Bird) {
                listBird.add(x);
            } else if ( x instanceof Fish) {
                listFish.add(x);
             } else {
                listMamalia.add(x);
            }
        }
        System.out.println("List Burung");
        listBird.forEach(System.out::println);
        System.out.println("");
        System.out.println("List Fish");
        listFish.forEach(System.out::println);
        System.out.println("");
        System.out.println("List Mamalia");
        listMamalia.forEach(System.out::println);
    }
    
//    @Override
//    public int compareTo(Animal o) {
//        return toString().compareTo(o.toString());
//    }
    
    
}

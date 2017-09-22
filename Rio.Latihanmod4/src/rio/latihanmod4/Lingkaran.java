/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rio.latihanmod4;

/**
 *
 * @author Zero-Inside
 */
public class Lingkaran {
    private int jarijari;
    private int jurajura;

    public Lingkaran(int jarijari, int jurajura) {
        this.jarijari = jarijari;
        this.jurajura = jurajura;
    }

    

    public int getJurajura() {
        return jurajura;
    }

    public void setJurajura(int jurajura) {
        this.jurajura = jurajura;
    }
    
    public int getJarijari() {
        return jarijari;
    }

    public void setJarijari(int jarijari) {
        this.jarijari = jarijari;
    }
    
    public int getLuas(){
        int x = this.jarijari * this.jarijari * 22 /7;
        return x;
    }
    
    public int getLuas(int jarijari){
        int x = jarijari * jarijari * 22 / 7;
        return x;
    }
    
    public void tampilkan(){
        System.out.println(jarijari);
    }
}

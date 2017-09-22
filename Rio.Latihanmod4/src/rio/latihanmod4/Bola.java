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
public class Bola extends Lingkaran {

    public Bola(int jarijari, int jurajura) {
        super(jarijari, jurajura);
    }
 
    
    @Override
    public int getLuas(){
        int x = super.getLuas() * 4;
        return x;
    }
    
    public int getVolume(){
        int x = super.getLuas() * super.getJarijari() * 4 / 3;
        return x;
    }
    public void tampil(){
        System.out.println(super.getJarijari());
    }
}

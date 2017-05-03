/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lat1;

/**
 *
 * @author zeroone
 */
public class profile {
    double total = 0;
    String nama;
    int umur;
    
    String alamat;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setNama(String x) {
        nama = x ;
    } 
    public String getNama(){
        return nama;
    }
    
    public void setUmur(int x) {
        umur = x;
    }
    
    public int getUmur() {
        return umur;
    }
}

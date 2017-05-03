package lat1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeroone
 */
public class calculator {
    
    double jumlah;
    
//    public void setBil(double bil1){
//        this.bil1 = bil1;
//    }
//    
//    public void setBil2(double bil2){
//        this.bil2 = bil2;
//    }
    
    
    public void hitung(double x , char opr , double y){

        switch (opr) {
            case '+':
                tambah(x,y);
                break;
            case '-':
                kurang(x,y);
                break;
            case '/' :
                bagi(x,y);
                break;
            case '*' :
                kali(x,y);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void tambah(double x, double y) {
        jumlah = x + y;
    }

    private void kurang(double x, double y) {
        jumlah = x - y;
        System.out.println(jumlah);
    }
    
    private void bagi(double x, double y){
        jumlah = x / y;
    }
    
    private void kali(double x, double y){
        jumlah = x * y;
    }
    
    public double jumlah(){
        return jumlah;
    }
}

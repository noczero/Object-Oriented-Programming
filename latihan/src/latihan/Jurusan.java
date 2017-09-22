/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;

/**
 *
 * @author Zero-Inside
 */
public class Jurusan {
    private String kode;
    private String nama;
    private Mahasiswa daftarMhs[] = new Mahasiswa[10];
    private int jumlahMhs;
    
    
    Jurusan(String kode , String nama) {
        this.kode = kode;
        this.nama = nama;
    }
    public String getKode(){
        return this.kode;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public int getJumlahMhs(){
        return this.jumlahMhs;
    }
    
    public Mahasiswa[] getDaftarMhs(){
        return this.daftarMhs;
    }
    
    public void addMahasiswa(Mahasiswa m){
        if (jumlahMhs< this.daftarMhs.length){
            daftarMhs[jumlahMhs] = m;
            jumlahMhs++;
        }
    }
    
   
    
}

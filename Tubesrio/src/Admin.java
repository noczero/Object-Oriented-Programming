/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zero-Inside
 */
public class Admin {
    private String nama;
    private String id;
    private Ruangan[] daftar_ruangan;
    private Peminjaman[] daftar_peminjaman;
    private int jmlh_peminjaman;
    
    public Admin (String nama,String id){
        this.nama = nama;
        this.id = id;
        this.daftar_ruangan = new Ruangan[10];
        this.daftar_peminjaman = new Peminjaman[20];   
    }
    
    public void isiruangan (){
        Ruangan ruangan;
        for (int i=1 ; i <= 10 ; i++){
            ruangan = new Ruangan(i,true,200000);
            this.daftar_ruangan[i] = ruangan;
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void add_peminjaman (Peminjaman peminjaman){
        this.jmlh_peminjaman ++;
        if (this.jmlh_peminjaman <= 20){
            this.daftar_peminjaman[this.jmlh_peminjaman] = peminjaman;
        }
    }
}

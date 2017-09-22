/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Zero-Inside
 */
public class Maskapai extends User {
    private String idMaskapai;
    private String nama;
    private int jumlahPesawat;

    public Maskapai(String idMaskapai, String username , String password , String nama, int jumlahPesawat) {
        this.idMaskapai = idMaskapai;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jumlahPesawat = jumlahPesawat;
    }

    public String getIdMaskapai() {
        return idMaskapai;
    }

    public void setIdMaskapai(String idMaskapai) {
        this.idMaskapai = idMaskapai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahPesawat() {
        return jumlahPesawat;
    }

    public void setJumlahPesawat(int jumlahPesawat) {
        this.jumlahPesawat = jumlahPesawat;
    }
    
    
}

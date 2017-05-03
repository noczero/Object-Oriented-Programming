/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zero-Inside
 */
public class Customer extends User {
    private String nama;
    private String noktp;
    private String alamat;
    private int umur;
    private String jenisKelamin;
    private String noTelepon;
    private long saldo;

    public Customer(String noktp, String username, String password, String nama,  String alamat, int umur, String jenisKelamin, String noTelepon) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.noktp = noktp;
        this.alamat = alamat;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
    }

    public String getNama() {
        return nama;
    }

    public String getNoktp() {
        return noktp;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getUmur() {
        return umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
    
    
}

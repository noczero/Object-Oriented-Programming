/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Zero-Inside
 */
public class Penerbangan {
    private int idPenerbangan;
    private int idJadwal;
    private String idPesawat;
    private String idBandara;
    private String tujuan;
    private String asal;
    private long harga;
    
    //add to jadwal penerbangan
    private String namaMaskapai;
    private Date jadwal;
    private String waktuBerangkat;
    private String waktuTiba;

    public Penerbangan(int idPenerbangan, int idJadwal, String idPesawat, String idBandara, String tujuan, String asal, long harga) {
        this.idPenerbangan = idPenerbangan;
        this.idJadwal = idJadwal;
        this.idPesawat = idPesawat;
        this.idBandara = idBandara;
        this.tujuan = tujuan;
        this.asal = asal;
        this.harga = harga;
    }
    
    // insert to DB leave idPenebrangan cause Auto Increment
    public Penerbangan(int idJadwal, String idPesawat, String idBandara, String tujuan, String asal, long harga) {
        this.idPenerbangan = idPenerbangan;
        this.idJadwal = idJadwal;
        this.idPesawat = idPesawat;
        this.idBandara = idBandara;
        this.tujuan = tujuan;
        this.asal = asal;
        this.harga = harga;
    }
    
    public Penerbangan(){
        // let it blank.
    }

    public int getIdPenerbangan() {
        return idPenerbangan;
    }

    public void setIdPenerbangan(int idPenerbangan) {
        this.idPenerbangan = idPenerbangan;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getIdPesawat() {
        return idPesawat;
    }

    public void setIdPesawat(String idPesawat) {
        this.idPesawat = idPesawat;
    }

    public String getIdBandara() {
        return idBandara;
    }

    public void setIdBandara(String idBandara) {
        this.idBandara = idBandara;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public String getNamaMaskapai() {
        return namaMaskapai;
    }

    public void setNamaMaskapai(String namaMaskapai) {
        this.namaMaskapai = namaMaskapai;
    }

    public Date getJadwal() {
        return jadwal;
    }

    public void setJadwal(Date jadwal) {
        this.jadwal = jadwal;
    }

    public String getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public void setWaktuBerangkat(String waktuBerangkat) {
        this.waktuBerangkat = waktuBerangkat;
    }

    public String getWaktuTiba() {
        return waktuTiba;
    }

    public void setWaktuTiba(String waktuTiba) {
        this.waktuTiba = waktuTiba;
    }
    
    
}

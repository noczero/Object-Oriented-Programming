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
public class Tiket {
    private String kodeBooking;
    private String namaCustomer;
    private String rutePenerbangan;
    private Date jadwalPenerbangan;
    private String waktuBerangkat;
    private String waktuTiba;
    private String kodePesawat;
    private String jenisPesawat;
    private String seat;
    private String asal;
    private String tujuan;
    private String status;
    private String idPesan;

    public String getStatus() {
        return status;
    }

    public String getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(String idPesan) {
        this.idPesan = idPesan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Tiket(String kodeBooking, String namaCustomer, String tujuan, String asal, Date jadwalPenerbangan, String waktuBerangkat, String waktuTiba, String kodePesawat, String jenisPesawat, String seat, String idPesan) {
        this.kodeBooking = kodeBooking;
        this.namaCustomer = namaCustomer;
        this.tujuan =tujuan ;
        this.asal = asal;
        this.jadwalPenerbangan = jadwalPenerbangan;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.kodePesawat = kodePesawat;
        this.jenisPesawat = jenisPesawat;
        this.seat = seat;
        this.idPesan = idPesan;
        this.rutePenerbangan = asal + " - " + tujuan;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getRutePenerbangan() {
        return rutePenerbangan;
    }

    public void setRutePenerbangan(String rutePenerbangan) {
        this.rutePenerbangan = rutePenerbangan;
    }

    public Date getJadwalPenerbangan() {
        return jadwalPenerbangan;
    }

    public void setJadwalPenerbangan(Date jadwalPenerbangan) {
        this.jadwalPenerbangan = jadwalPenerbangan;
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

    public String getKodePesawat() {
        return kodePesawat;
    }

    public void setKodePesawat(String kodePesawat) {
        this.kodePesawat = kodePesawat;
    }

    public String getJenisPesawat() {
        return jenisPesawat;
    }

    public void setJenisPesawat(String jenisPesawat) {
        this.jenisPesawat = jenisPesawat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    
}

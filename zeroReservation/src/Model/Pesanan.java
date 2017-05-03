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
public class Pesanan {
    private int idPesan;
    private String noKtp;
    private int idBayar;
    private int noSeat;
    private long totalHarga;
    private String tanggalPesan;
    private String status;
    private String kodeBooking;

    public Pesanan(int idPesan, String noKtp, int idBayar, int noSeat, long totalHarga, String tanggalPesan, String status, String kodeBooking) {
        this.idPesan = idPesan;
        this.noKtp = noKtp;
        this.idBayar = idBayar;
        this.noSeat = noSeat;
        this.totalHarga = totalHarga;
        this.tanggalPesan = tanggalPesan;
        this.status = status;
        this.kodeBooking = kodeBooking;
    }

    public int getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(int idPesan) {
        this.idPesan = idPesan;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public int getIdBayar() {
        return idBayar;
    }

    public void setIdBayar(int idBayar) {
        this.idBayar = idBayar;
    }

    public int getNoSeat() {
        return noSeat;
    }

    public void setNoSeat(int noSeat) {
        this.noSeat = noSeat;
    }

    public long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggalPesan() {
        return tanggalPesan;
    }

    public void setTanggalPesan(String tanggalPesan) {
        this.tanggalPesan = tanggalPesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }
    
    
    
}

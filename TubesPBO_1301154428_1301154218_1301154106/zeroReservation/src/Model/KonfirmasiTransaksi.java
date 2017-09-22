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
public class KonfirmasiTransaksi  {
    
    private int idPesan;
    private String noKTP;
    private String namaCustomer;
    private String noSeat;
    private String status;
    private String kodeBooking;

    public KonfirmasiTransaksi(int idPesan, String noKTP, String namaCustomer, String noSeat, String status, String kodeBooking) {
        this.idPesan = idPesan;
        this.noKTP = noKTP;
        this.namaCustomer = namaCustomer;
        this.noSeat = noSeat;
        this.status = status;
        this.kodeBooking = kodeBooking;
    }

    public int getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(int idPesan) {
        this.idPesan = idPesan;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNoSeat() {
        return noSeat;
    }

    public void setNoSeat(String noSeat) {
        this.noSeat = noSeat;
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

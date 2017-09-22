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
public class Pesawat {
    
    private String idPesawat;
    private String idMaskapai;
    private String keterangan;
    private String rute;
    private int jumlahSeat;
    private String tipe;

    public Pesawat(String idPesawat, String idMaskapai, String keterangan, String rute, int jumlahSeat, String tipe) {
        this.idPesawat = idPesawat;
        this.idMaskapai = idMaskapai;
        this.keterangan = keterangan;
        this.rute = rute;
        this.jumlahSeat = jumlahSeat;
        this.tipe = tipe;
    }

    public Pesawat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdPesawat() {
        return idPesawat;
    }

    public void setIdPesawat(String idPesawat) {
        this.idPesawat = idPesawat;
    }

    public String getIdMaskapai() {
        return idMaskapai;
    }

    public void setIdMaskapai(String idMaskapai) {
        this.idMaskapai = idMaskapai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public int getJumlahSeat() {
        return jumlahSeat;
    }

    public void setJumlahSeat(int jumlahSeat) {
        this.jumlahSeat = jumlahSeat;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    
    
    
}

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
public class Jadwal {
    private int idJadwal;
    private String waktuBerangkat;
    private String waktuTiba;
    private String tglPenerbangan;

    public Jadwal(int idJadwal, String waktuBerangkat, String waktuTiba, String tglPenerbangan) {
        this.idJadwal = idJadwal;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.tglPenerbangan = tglPenerbangan;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
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

    public String getTglPenerbangan() {
        return tglPenerbangan;
    }

    public void setTglPenerbangan(String tglPenerbangan) {
        this.tglPenerbangan = tglPenerbangan;
    }
    
    
}

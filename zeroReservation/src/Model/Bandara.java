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
public class Bandara {
    private String idBandara;
    private String nama;
    private String latitude;
    private String longitude;
    private String kota;
    private String negara;

    public Bandara(String idBandara, String nama, String latitude, String longitude, String kota, String negara) {
        this.idBandara = idBandara;
        this.nama = nama;
        this.latitude = latitude;
        this.longitude = longitude;
        this.kota = kota;
        this.negara = negara;
    }

    public String getIdBandara() {
        return idBandara;
    }

    public void setIdBandara(String idBandara) {
        this.idBandara = idBandara;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
    
    
    
}

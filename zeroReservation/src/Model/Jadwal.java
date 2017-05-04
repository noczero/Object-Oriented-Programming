/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero-Inside
 */
public class Jadwal {

    private int idJadwal;
    private String waktuBerangkat;
    private String waktuTiba;
    private Date tglPenerbangan;

    public Jadwal(int idJadwal, String waktuBerangkat, String waktuTiba, Date tglPenerbangan) {
        this.idJadwal = idJadwal;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.tglPenerbangan = tglPenerbangan;
    }
    
     public Jadwal(String waktuBerangkat, String waktuTiba, Date tglPenerbangan) {
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

    public Date getTglPenerbangan() {
        return tglPenerbangan;
    }

    public void setTglPenerbangan(Date tglPenerbangan) {
        this.tglPenerbangan = tglPenerbangan;
    }

    // date format to save to SQL
//    public Date toDate() {
//        String dateString = this.tglPenerbangan;
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        
//        try {
//            return (Date) formatter.parse(dateString);
//        } catch (ParseException ex) {
//            Logger.getLogger(Jadwal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

}

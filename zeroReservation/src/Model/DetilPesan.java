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
public class DetilPesan {
    private int idDetilPesan;
    private int idPesan;
    private int idPenerbangan;

    public DetilPesan(int idDetilPesan, int idPesan, int idPenerbangan) {
        this.idDetilPesan = idDetilPesan;
        this.idPesan = idPesan;
        this.idPenerbangan = idPenerbangan;
    }

    public int getIdDetilPesan() {
        return idDetilPesan;
    }

    public void setIdDetilPesan(int idDetilPesan) {
        this.idDetilPesan = idDetilPesan;
    }

    public int getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(int idPesan) {
        this.idPesan = idPesan;
    }

    public int getIdPenerbangan() {
        return idPenerbangan;
    }

    public void setIdPenerbangan(int idPenerbangan) {
        this.idPenerbangan = idPenerbangan;
    }
    
    
    
}

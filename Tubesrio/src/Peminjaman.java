/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zero-Inside
 */
public class Peminjaman {
    private Customer peminjam;
    private Admin administrator;
    private Ruangan room;
    private Member member;

    public Peminjaman(Customer peminjam, Admin administrator, Ruangan room) {
        this.peminjam = peminjam;
        this.administrator = administrator;
        this.room = room;
    }
    public Peminjaman(Member member, Admin administrator, Ruangan room) {
        this.member = member;
        this.administrator = administrator;
        this.room = room;
    }

    public Customer getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Customer peminjam) {
        this.peminjam = peminjam;
    }

    public Admin getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Admin administrator) {
        this.administrator = administrator;
    }

    public Ruangan getRoom() {
        return room;
    }

    public void setRoom(Ruangan room) {
        this.room = room;
    }
    
    
}

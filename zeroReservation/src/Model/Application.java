/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;

/**
 *
 * @author Zero-Inside
 */
public class Application {

    private Database connection;
    ArrayList<Customer> listCustomer = new ArrayList();
    ArrayList<Admin> listAdmin = new ArrayList();
    ArrayList<Maskapai> listMaskapai = new ArrayList();

    public Application() {
        connection = new Database();
        connection.connectDB();
    }

    // Login Scheme
    public Admin cekLoginAdmin(String username, String password) {
        Admin admin = connection.cekLoginAdmin(username, password);

        if (admin != null) {
            return admin;
        } else {
            return null;
        }
    }

    public Customer cekLoginCustomer(String username, String password) {
        Customer customer = connection.cekLoginCustomer(username, password);

        if (customer != null) {
            return customer;
        } else {
            return null;
        }
    }

    public Maskapai cekLoginMaskapai(String username, String password) {
        Maskapai maskapai = connection.cekLoginMaskapai(username, password);

        if (maskapai != null) {
            return maskapai;
        } else {
            return null;
        }
    }

    // Customer CRUD
    public void addCustomer(Customer customer) {
        connection.insertCustomer(customer);
    }

    public ArrayList<Customer> getCustomer() {
        return connection.getAllCustomer();
    }

    public void updateCustumer(Customer customer) {
        connection.updateCustomer(customer);
    }

    public void deleteCustomer(String id) {
        connection.deleteCustomer(id);
    }

    // Maskapai CRUD
    public void addMaskapai(Maskapai maskapai) {
        connection.insertMaskapai(maskapai);
    }

    public ArrayList<Maskapai> getMaskapai() {
        return connection.getAllMaskapai();
    }

    public void updateMaskapai(Maskapai maskapai) {
        connection.updateMaskapai(maskapai);
    }

    public void deleteMaskapai(String id) {
        connection.deleteMaskapai(id);
    }

    //Konfirmasi Transaksi CRUD
    public ArrayList<KonfirmasiTransaksi> getKonfirmasiTransaksi() {
        return connection.getKonfirmasiTransaksi();
    }

    public void updateKonfirmasiTransaksi(KonfirmasiTransaksi transaksi) {
        Pesanan pesanan = new Pesanan(transaksi.getIdPesan(), transaksi.getNoSeat(), transaksi.getStatus(), transaksi.getKodeBooking());
        connection.updatePesanan(pesanan);
    }

    public void deleteKonfirmasiTransaksi(Integer id) {
        connection.deletePesanan(id);
    }

    //Penerbangan CRUD
    public ArrayList<Penerbangan> getPenerbangan() {
        return connection.getAllPenerbangan();
    }

    public ArrayList<Penerbangan> selectionPenerbangan(String idMaskapai){
        return connection.selectionPenerbangan(idMaskapai);
    }
    public void insertPenerbangan(Penerbangan penerbangan) {
        connection.insertPenerbangan(penerbangan);
    }

    public void updatePenerbangan(Penerbangan penerbangan) {
        connection.updatePenerbangan(penerbangan);
    }

    public void deletePenerbangan(Integer id) {
        connection.deletePenerbangan(id);
    }
    

    //Bandara CRUD
    public ArrayList<Bandara> getBandara() {
        return connection.getAllBandara();
    }

    public void insertBandara(Bandara bandara) {
        connection.insertBandara(bandara);
    }

    public void updateBandara(Bandara bandara) {
        connection.updateBandara(bandara);
    }

    public void deleteBandara(String id) {
        connection.deleteBandara(id);
    }

    //Pesawat CRUD
    public ArrayList<Pesawat> getPesawat(String idMaskapai) {
        return connection.getAllPesawat(idMaskapai);
    }

    public void insertPesawat(Pesawat pesawat) {
        connection.insertPesawat(pesawat);
    }

    public void updatePesawat(Pesawat pesawat) {
        connection.updatePesawat(pesawat);
    }

    public void deletePesawat(String id) {
        connection.deletePesawat(id);
    }

    // Jadwal CRUD
    public ArrayList<Jadwal> getJadwal() {
        return connection.getAllJadwal();
    }

    public void insertJadwal(Jadwal jadwal) {
        connection.insertJadwal(jadwal);
    }

    public void updateJadwal(Jadwal jadwal) {
        connection.updateJadwal(jadwal);
    }

    public void deleteJadwal(Integer id) {
        connection.deleteJadwal(id);
    }

    public ArrayList<Tiket> getTiket(String NoKTP) {
        return connection.getAllTiket(NoKTP);
    }

    //Saldo
    public void updateSaldo(String noKTP , Long Saldo) {
        connection.updateSaldo(noKTP ,Saldo);
    }

    public Long getSaldo(String noKTP) {
        return connection.getSaldo(noKTP);
    }
    
    //Jadwal Penerbangan Customer
    public ArrayList<Penerbangan> getAllJdwlPenerbangan(){
        return connection.getAllJadwalPenerbangan();
    }
    
    //Pesan Penerbangan
    public void pesanPenerbangan(Integer id) {
        connection.pesanPenerbangan(id);
    }
    
    public void insertPesanan(Pesanan pesanan) {
        connection.insertPesanan(pesanan);
    }
    
}

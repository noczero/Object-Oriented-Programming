/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Admin;
import Model.Bandara;
import Model.Customer;
import Model.DetilPesan;
import Model.Jadwal;
import Model.KonfirmasiTransaksi;
import Model.Maskapai;
import Model.Penerbangan;
import Model.Pesanan;
import Model.Pesawat;
import Model.Tiket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Zero-Inside
 */
public class Database {

    private String server = "jdbc:mysql://localhost/zeroreservationdb";
    private String dbuser = "root";
    private String dbpassword = "";
    protected Statement statement;
    protected Connection connection;

    public void connectDB() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpassword);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // CUSTOMER CRUD 
    // insert, getAll , delete , update
    public void insertCustomer(Customer customer) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO `customer` VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, customer.getNoktp());
            preparedStatement.setString(2, customer.getUsername());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setString(4, customer.getNama());
            preparedStatement.setString(5, customer.getAlamat());
            preparedStatement.setInt(6, customer.getUmur());
            preparedStatement.setString(7, customer.getJenisKelamin());
            preparedStatement.setString(8, customer.getNoTelepon());
            preparedStatement.setLong(9, customer.getSaldo());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> listCustomer = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM customer";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getLong(9));
                listCustomer.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listCustomer;
    }

    //Update
    public void updateCustomer(Customer customer) {
        PreparedStatement preparedStatement = null;
        String updateString = "UPDATE `customer` SET `username`= ?,`password`= ?,`nama`= ?,`alamat`= ? ,`umur`= ?,`jenis_kelamin`= ?,`no_telepon`=?,`saldo`=? WHERE `no_ktp`= ?";

        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(updateString);

            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getNama());
            preparedStatement.setString(4, customer.getAlamat());
            preparedStatement.setInt(5, customer.getUmur());
            preparedStatement.setString(6, customer.getJenisKelamin());
            preparedStatement.setString(7, customer.getNoTelepon());
            preparedStatement.setLong(8, customer.getSaldo());
            preparedStatement.setString(9, customer.getNoktp());

            //Execute update
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //Delete
    public void deleteCustomer(String id) {
        // id : noKTP
        PreparedStatement ps = null;
        String deleteString = "DELETE FROM `customer` WHERE `no_ktp` = ? ";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // -- end of customer -- 

    //MASKAPAI CRUD
    // insert , getAll
    public void insertMaskapai(Maskapai maskapai) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO maskapai VALUES (?,?,?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, maskapai.getIdMaskapai());
            preparedStatement.setString(2, maskapai.getUsername());
            preparedStatement.setString(3, maskapai.getPassword());
            preparedStatement.setString(4, maskapai.getNama());
            preparedStatement.setInt(5, maskapai.getJumlahPesawat());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Maskapai> getAllMaskapai() {
        ArrayList<Maskapai> listMaskapai = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM maskapai";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Maskapai maskapai = new Maskapai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listMaskapai.add(maskapai);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listMaskapai;
    }

    public void updateMaskapai(Maskapai maskapai) {
        PreparedStatement preparedStatement = null;
        String updateString = "UPDATE `maskapai` SET `id_maskapai`= ?,`username`= ?,`password`= ? ,`nama`= ?,`jmlh_pesawat`= ? WHERE `id_maskapai`= ?";

        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(updateString);

            preparedStatement.setString(1, maskapai.getIdMaskapai());
            preparedStatement.setString(2, maskapai.getUsername());
            preparedStatement.setString(3, maskapai.getPassword());
            preparedStatement.setString(4, maskapai.getNama());
            preparedStatement.setInt(5, maskapai.getJumlahPesawat());
            preparedStatement.setString(6, maskapai.getIdMaskapai());

            //Execute update
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //Delete
    public void deleteMaskapai(String id) {
        // id : kodeMaskapai
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `maskapai` WHERE `id_maskapai` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // -- end of maskapai --

    //CRUD Admin
    // insert , getAll
    public void insertAdmin(Admin admin) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO admin VALUES (?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> listAdmin = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM admin";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Admin admin = new Admin(rs.getString(1), rs.getString(2));
                listAdmin.add(admin);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listAdmin;
    }
    // -- end crud admin --

    // CRUD Bandara
    // insert, getAll
    public void insertBandara(Bandara bandara) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO bandara VALUES (?,?,?,?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, bandara.getIdBandara());
            preparedStatement.setString(2, bandara.getNama());
            preparedStatement.setString(3, bandara.getLatitude());
            preparedStatement.setString(4, bandara.getLongitude());
            preparedStatement.setString(5, bandara.getKota());
            preparedStatement.setString(6, bandara.getNegara());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Bandara> getAllBandara() {
        ArrayList<Bandara> listBandara = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM bandara";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Bandara bandara = new Bandara(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listBandara.add(bandara);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listBandara;
    }

    public void updateBandara(Bandara bandara) {
        PreparedStatement ps = null;
        String updateQuery = "UPDATE `bandara` SET `nama`= ? ,`latitude`= ? ,`longitude`= ?,`kota`= ?,`negara`= ? WHERE `id_bandara` = ?";

        try {
            // make connection of prepared Statement using ?
            ps = connection.prepareStatement(updateQuery);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            ps.setString(6, bandara.getIdBandara());
            ps.setString(1, bandara.getNama());
            ps.setString(2, bandara.getLatitude());
            ps.setString(3, bandara.getLongitude());
            ps.setString(4, bandara.getKota());
            ps.setString(5, bandara.getNegara());

            // execute insert SQL Statement
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBandara(String id) {
        // id : idpenerbangan
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `bandara` WHERE `id_bandara` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // -- End CRUD Bandara --
    //CRUD Jadwal
    // insert , getall
    public void insertJadwal(Jadwal jadwal) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO jadwal (`waktu_brkt`, `waktu_tiba`, `tgl_penerbangan`) VALUES (?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // Date
//            String dateString = jadwal.getTglPenerbangan();
//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date myDate = (Date) formatter.parse(dateString);
            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, jadwal.getWaktuBerangkat());
            preparedStatement.setString(2, jadwal.getWaktuTiba());
            preparedStatement.setDate(3, jadwal.getTglPenerbangan()); //notice this must date            

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Jadwal> getAllJadwal() {
        ArrayList<Jadwal> listJadwal = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM jadwal";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Jadwal jadwal = new Jadwal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listJadwal.add(jadwal);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listJadwal;
    }

    public void updateJadwal(Jadwal jadwal) {
        PreparedStatement ps = null;
        String updateQuery = "UPDATE `jadwal` SET `waktu_brkt`= ? ,`waktu_tiba`= ? ,`tgl_penerbangan`= ?  WHERE `id_jadwal` = ? ";

        try {
            // make connection of prepared Statement using ?
            ps = connection.prepareStatement(updateQuery);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            ps.setString(1, jadwal.getWaktuBerangkat());
            ps.setString(2, jadwal.getWaktuTiba());
            ps.setDate(3, jadwal.getTglPenerbangan()); //notice this must date   
            ps.setInt(4, jadwal.getIdJadwal());

            // execute insert SQL Statement
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJadwal(Integer id) {
        // id : idpenerbangan
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `jadwal` WHERE `id_jadwal` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // --  End Crud Jadwal -- 

    //CRUD Detil Pesan
    public void insertDetilPesan(DetilPesan detilpesan) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO jadwal (`id_pesan`, `id_penerbangan`) VALUES (?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setInt(1, detilpesan.getIdPesan());
            preparedStatement.setInt(2, detilpesan.getIdPenerbangan());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //CRUD Pembayaran
    public void insertPembayaran(DetilPesan detilpesan) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO jadwal (`id_pesan`, `id_penerbangan`) VALUES (?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setInt(1, detilpesan.getIdPesan());
            preparedStatement.setInt(2, detilpesan.getIdPenerbangan());

            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //CRUD Pesanan
    public void insertPesanan(Pesanan pesanan) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO pesanan (`no_ktp`, `id_bayar`, `no_seat`, `total_harga`, `status`, `kode_booking`) VALUES (?,?,?,?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, pesanan.getNoKtp());
            preparedStatement.setInt(2, pesanan.getIdBayar());
            preparedStatement.setString(3, pesanan.getNoSeat());
            preparedStatement.setLong(4, pesanan.getTotalHarga());
            preparedStatement.setString(5, pesanan.getStatus());
            preparedStatement.setString(6, pesanan.getKodeBooking());
            // execute insert SQL Statement
            //pr
            // execute insert SQL Statement
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // call when konfirmasi transaksi by Admin
    public void updatePesanan(Pesanan pesan) {
        PreparedStatement ps = null;
        String updateString = "UPDATE `pesanan` SET `no_seat`= ? ,`status`= ?,`kode_booking`= ? WHERE `id_pesan` = ?";

        try {
            // make connection of prepared Statement using ?
            ps = connection.prepareStatement(updateString);

            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            ps.setString(1, pesan.getNoSeat());
            ps.setString(2, pesan.getStatus());
            ps.setString(3, pesan.getKodeBooking());
            ps.setInt(4, pesan.getIdPesan());

            // execute insert SQL Statement
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePesanan(Integer id) {
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `pesanan` WHERE `id_pesan` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //getKonfrimasiTransaksi
    public ArrayList<KonfirmasiTransaksi> getKonfirmasiTransaksi() {
        // need to join customer table and pesanan table
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<KonfirmasiTransaksi> listTransaksi = new ArrayList();

        String selectString = "SELECT `id_pesan` , `no_ktp` , `nama`, `no_seat`, `status`, `kode_booking` FROM `pesanan` JOIN `customer` USING (`no_ktp`)";

        try {
            ps = connection.prepareStatement(selectString);
            // Execute 
            rs = ps.executeQuery();

            while (rs.next()) {
                KonfirmasiTransaksi kt = new KonfirmasiTransaksi(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listTransaksi.add(kt);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listTransaksi;
    }

    //checkLogin Admin
    public Admin cekLoginAdmin(String username, String password) {
        Admin admin = null;
        PreparedStatement preparedstatement = null;
        ResultSet result = null;
        String cekLoginString = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            preparedstatement = connection.prepareStatement(cekLoginString);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);

            //Exeute query
            result = preparedstatement.executeQuery();

            while (result.next()) {
                admin = new Admin(result.getString(1), result.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return admin;
    }

    // cek login customer
    public Customer cekLoginCustomer(String username, String password) {
        Customer customer = null;
        PreparedStatement preparedstatement = null;
        ResultSet result = null;
        String cekLoginString = "SELECT * FROM customer WHERE username = ? AND password = ?";
        try {
            preparedstatement = connection.prepareStatement(cekLoginString);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);

            //Exeute query
            result = preparedstatement.executeQuery();

            while (result.next()) {
                customer = new Customer(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7), result.getString(8), result.getLong(9));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return customer;
    }

    //cek login maksapai
    public Maskapai cekLoginMaskapai(String username, String password) {
        Maskapai maskapai = null;
        PreparedStatement preparedstatement = null;
        ResultSet result = null;
        String cekLoginString = "SELECT * FROM maskapai WHERE username = ? AND password = ?";
        try {
            preparedstatement = connection.prepareStatement(cekLoginString);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);

            //Exeute query
            result = preparedstatement.executeQuery();

            while (result.next()) {
                maskapai = new Maskapai(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return maskapai;
    }

    // CRUD Penerbangan
    public ArrayList<Penerbangan> getAllPenerbangan() {
        PreparedStatement ps = null;
        String selectQuery = "SELECT * FROM `r_penerbangan`";
        ResultSet result = null;
        ArrayList<Penerbangan> listPenerbangan = new ArrayList();

        try {
            ps = connection.prepareStatement(selectQuery);
            result = ps.executeQuery();

            while (result.next()) {
                Penerbangan penerbangan = new Penerbangan(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getLong(7));
                listPenerbangan.add(penerbangan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPenerbangan;
    }

    public void insertPenerbangan(Penerbangan penerbangan) {
        PreparedStatement ps = null;
        String insertQuery = "INSERT INTO `r_penerbangan`(`id_jadwal`, `id_pesawat`, `id_bandara`, `tujuan`, `asal`, `harga`) VALUES (?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(insertQuery);
            ps.setInt(1, penerbangan.getIdJadwal());
            ps.setString(2, penerbangan.getIdPesawat());
            ps.setString(3, penerbangan.getIdBandara());
            ps.setString(4, penerbangan.getTujuan());
            ps.setString(5, penerbangan.getAsal());
            ps.setLong(6, penerbangan.getHarga());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePenerbangan(Penerbangan penerbangan) {
        PreparedStatement ps = null;
        String updateQuery = "UPDATE `r_penerbangan` SET `id_jadwal`=?,`id_pesawat`= ?,`id_bandara`= ?,`tujuan`= ?,`asal`= ?,`harga`= ? WHERE `id_penerbangan` = ?";

        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setInt(1, penerbangan.getIdJadwal());
            ps.setString(2, penerbangan.getIdPesawat());
            ps.setString(3, penerbangan.getIdBandara());
            ps.setString(4, penerbangan.getTujuan());
            ps.setString(5, penerbangan.getAsal());
            ps.setLong(6, penerbangan.getHarga());
            ps.setInt(7, penerbangan.getIdPenerbangan());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePenerbangan(Integer id) {
        // id : idpenerbangan
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `r_penerbangan` WHERE `id_penerbangan` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Penerbangan> selectionPenerbangan(String idMaskapai) {
        //get list penerbangan where id_pesawat = id Maskapai
        PreparedStatement ps = null;
        String selectQuery = "SELECT * FROM `r_penerbangan` JOIN `pesawat` USING (`id_pesawat`) WHERE `id_maskapai` = ?";
        ResultSet result = null;
        ArrayList<Penerbangan> listPenerbangan = new ArrayList();

        try {
            ps = connection.prepareStatement(selectQuery);
            ps.setString(1, idMaskapai);
            result = ps.executeQuery();

            while (result.next()) {
                Penerbangan penerbangan = new Penerbangan(
                        result.getInt("id_penerbangan"),
                        result.getInt("id_jadwal"),
                        result.getString("id_pesawat"),
                        result.getString("id_bandara"),
                        result.getString("tujuan"),
                        result.getString("asal"),
                        result.getLong("harga")
                );
                listPenerbangan.add(penerbangan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPenerbangan;
    }

    // -- end of CRUD penerbangan --
    // CRUD Pesawat
    public ArrayList<Pesawat> getAllPesawat(String idMaskapai) {
        PreparedStatement ps = null;
        String selectQuery = "SELECT * FROM `pesawat` WHERE `id_maskapai` = ?";
        ResultSet result = null;
        ArrayList<Pesawat> listPesawat = new ArrayList();

        try {
            ps = connection.prepareStatement(selectQuery);
            ps.setString(1, idMaskapai);
            result = ps.executeQuery();

            while (result.next()) {
                Pesawat pesawat = new Pesawat(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6));
                listPesawat.add(pesawat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPesawat;
    }

    public void insertPesawat(Pesawat pesawat) {
        PreparedStatement ps = null;
        String insertQuery = "INSERT INTO `pesawat` VALUES (?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(insertQuery);
            ps.setString(1, pesawat.getIdPesawat());
            ps.setString(2, pesawat.getIdMaskapai());
            ps.setString(3, pesawat.getKeterangan());
            ps.setString(4, pesawat.getRute());
            ps.setInt(5, pesawat.getJumlahSeat());
            ps.setString(6, pesawat.getTipe());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePesawat(Pesawat pesawat) {
        PreparedStatement ps = null;
        String updateQuery = "UPDATE `pesawat` SET `id_pesawat`= ?,`id_maskapai`= ?,`keterangan`= ? , `rute`= ?,`jumlah_seat`=?,`tipe`=? WHERE `id_pesawat` = ?";

        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setString(1, pesawat.getIdPesawat());
            ps.setString(2, pesawat.getIdMaskapai());
            ps.setString(3, pesawat.getKeterangan());
            ps.setString(4, pesawat.getRute());
            ps.setInt(5, pesawat.getJumlahSeat());
            ps.setString(6, pesawat.getTipe());
            ps.setString(7, pesawat.getIdPesawat());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePesawat(String id) {
        // id : idpenerbangan
        PreparedStatement ps = null;

        String deleteString = "DELETE FROM `pesawat` WHERE `id_pesawat` = ?";
        try {
            ps = connection.prepareStatement(deleteString);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // -- end of CRUD Pesawat--

    // get info ticket
    public ArrayList<Tiket> getAllTiket(String noKTP) {
        PreparedStatement ps = null;
        String selectQuery = "SELECT * FROM customer JOIN pesanan USING (no_ktp) JOIN detilpesan USING (id_pesan) JOIN r_penerbangan USING (id_penerbangan) JOIN jadwal USING (id_jadwal) JOIN pesawat USING (id_pesawat) WHERE `no_ktp` = ?";
        ResultSet result = null;
        ArrayList<Tiket> listTiket = new ArrayList();

        try {
            ps = connection.prepareStatement(selectQuery);
            ps.setString(1, noKTP);
            result = ps.executeQuery();
            while (result.next()) {
                Tiket tiket = new Tiket(
                        result.getString("kode_booking"),
                        result.getString("nama"),
                        result.getString("tujuan"),
                        result.getString("asal"),
                        result.getDate("tgl_penerbangan"),
                        result.getString("waktu_brkt"),
                        result.getString("waktu_tiba"),
                        result.getString("id_pesawat"),
                        result.getString("tipe"),
                        result.getString("no_seat"),
                        result.getString("id_pesan")
                );
                tiket.setStatus(result.getString("status"));
                listTiket.add(tiket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTiket;
    }

    public void updateSaldo(String noKTP, Long saldo) {
        PreparedStatement ps = null;
        String updateQuery = "UPDATE `customer` SET `saldo`=? WHERE no_ktp = ? ";

        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setLong(1, saldo);
            ps.setString(2, noKTP);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Long getSaldo(String noKTP) {
        PreparedStatement ps = null;
        String updateQuery = "SELECT `saldo` FROM customer WHERE no_ktp = ? ";
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(updateQuery);
            ps.setString(1, noKTP);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //get All in customer Jadwal Penerbangan
    
    public ArrayList<Penerbangan> getAllJadwalPenerbangan(){
        ArrayList<Penerbangan> listPenerbangan = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM r_penerbangan JOIN jadwal USING (id_jadwal) JOIN pesawat USING (id_pesawat) JOIN maskapai USING (id_maskapai)";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Penerbangan jdwlPenerbangan = new Penerbangan();
                jdwlPenerbangan.setAsal(rs.getString("asal"));
                jdwlPenerbangan.setHarga(rs.getLong("harga"));
                jdwlPenerbangan.setJadwal(rs.getDate("tgl_penerbangan"));
                jdwlPenerbangan.setTujuan(rs.getString("tujuan"));
                jdwlPenerbangan.setWaktuBerangkat(rs.getString("waktu_brkt"));
                jdwlPenerbangan.setWaktuTiba(rs.getString("waktu_tiba"));
                jdwlPenerbangan.setNamaMaskapai(rs.getString("nama"));
                jdwlPenerbangan.setIdPesawat(rs.getString("id_pesawat"));
                jdwlPenerbangan.setIdPenerbangan(rs.getInt("id_penerbangan"));
                        
                listPenerbangan.add(jdwlPenerbangan);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listPenerbangan;
    }
    
    
    public void pesanPenerbangan(Integer id) {
        PreparedStatement preparedStatement = null;
        String updateString = "UPDATE detilpesan SET `id_penerbangan`= ? WHERE `id_penerbangan`= 0";

        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setInt(1, id);

            //Execute update
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}

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
import Model.Maskapai;
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
    public void insertCustomer(Customer customer) {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(7 , customer.getJenisKelamin());
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
                Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
                listCustomer.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    //MASKAPAI CRUD
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
    
    //CRUD Admin
    //MASKAPAI CRUD
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
    
    // CRUD Bandara
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
                Bandara bandara = new Bandara(rs.getString(1), rs.getString(2) , rs.getString(3), rs.getString(4) , rs.getString(5), rs.getString(6));
                listBandara.add(bandara);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listBandara;
    }

    //CRUD Jadwal
     public void insertJadwal(Jadwal jadwal) throws ParseException {
        //Make Insert Query
        PreparedStatement preparedStatement = null; //use preparedstatement instead of brief query avoid sql injection
        String insertString = "INSERT INTO jadwal (`waktu_brkt`, `waktu_tiba`, `tgl_penerbangan`) VALUES (?,?,?)";
        try {
            // make connection of prepared Statement using ?
            preparedStatement = connection.prepareStatement(insertString);
            
            // Date
            String dateString = jadwal.getTglPenerbangan();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = (Date) formatter.parse(dateString);
            
            // set the values of prepared from the  index of ? , ? , ?..... ( first ? is 1)
            preparedStatement.setString(1, jadwal.getWaktuBerangkat());
            preparedStatement.setString(2, jadwal.getWaktuTiba());
            preparedStatement.setDate(3, myDate); //notice this must date            
            
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
                Jadwal jadwal = new Jadwal(rs.getInt(1), rs.getString(2) , rs.getString(3), rs.getString(4));
                listJadwal.add(jadwal);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listJadwal;
    }
    
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
     public void insertPesanan(DetilPesan detilpesan) {
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
    
    
    
}

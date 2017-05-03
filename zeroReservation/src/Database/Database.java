/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = "INSERT INTO customer VALUES (" 
                       + "'" + customer.getNoktp() + "',"
                       + "'" + customer.getUsername() + "',"
                       + "'" + customer.getPassword() + "',"
                       + "'" + customer.getNama() + "',"
                       + "'" + customer.getAlamat() + "',"
                       +  customer.getUmur() + ","
                       + "'" + customer.getJenisKelamin() + "',"
                       + "'" + customer.getNoTelepon() + "',"
                       + customer.getSaldo() + ")";                           
        try {
            statement.execute(query); //Execute the query
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
                Customer d = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
                listCustomer.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    
    
}

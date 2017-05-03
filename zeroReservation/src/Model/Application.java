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
        public Admin cekLoginAdmin(String username , String password){
            Admin admin = connection.cekLoginAdmin(username, password);
            
            if (admin != null)
                return admin;
            else
                return null;
        }
        
        public Customer cekLoginCustomer(String username , String password){
            Customer customer = connection.cekLoginCustomer(username,password);
            
            if(customer != null)
                return customer;
            else 
                return null;
        }
        
        public Maskapai cekLoginMaskapai(String username , String password){
            Maskapai maskapai = connection.cekLoginMaskapai(username, password);
            
            if(maskapai != null)
                return maskapai;
            else
                return null;
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
        
        
        
}

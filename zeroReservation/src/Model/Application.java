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
        
        public Application() {
            connection = new Database();
             connection.connectDB();
        }
        
        // Customer CRUD
        public void addCustomer(Customer cust) {
          // listCustomer.add(cust);
           connection.insertCustomer(cust);
        }
        
        public ArrayList<Customer> getCustomer() {
            return connection.getAllCustomer();
        }
        
        
}

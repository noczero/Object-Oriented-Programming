/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ardev.resto.dao;

import id.ardev.resto.database.DatabaseMySQL;
import id.ardev.resto.model.Category;
import id.ardev.resto.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AryaDharmaadi
 */
public class ProductDAOMySQL implements ProductDAO{

    @Override
    public boolean insert(Product p) {
        String sql = "INSERT INTO product values (null, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql);
            
            statement.setString(1, p.getName());
            statement.setFloat(2, p.getPrice());
            statement.setInt(3, p.getStock());
            statement.setInt(4, Integer.parseInt(p.getCategory().getId()));
            statement.setBoolean(5, p.isIsFavorite());
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Product p) {
        return true;
    }

    @Override
    public boolean delete(Product p) {
        return true;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<Product>();
        String sql = "Select * from product inner join category on category.id=product.category";
        try {
            if (DatabaseMySQL.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Product p = new Product(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getInt(4),
                            new Category(rs.getString(7),rs.getString(8)),
                            rs.getBoolean(6)
                    );
                    products.add(p);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Product getByID(String id) {
        return null;
    }

    @Override
    public List<Product> getByName(String name) {
        return null;
    }

    
}

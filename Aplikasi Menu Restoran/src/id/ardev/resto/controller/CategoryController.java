/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ardev.resto.controller;

import id.ardev.resto.dao.CategoryDAO;
import id.ardev.resto.dao.CategoryDAOMySQL;
import id.ardev.resto.model.Category;
import java.util.List;

/**
 *
 * @author AryaDharmaadi
 */
public class CategoryController {
    private CategoryDAO dao = new CategoryDAOMySQL();
    
    public List<Category> getAllData() {
        return dao.getAllCategory();
    }
}

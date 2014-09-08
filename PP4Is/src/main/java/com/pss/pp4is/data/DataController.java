/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data;

import com.pss.pp4is.data.containers.ProductContainer;
import com.pss.pp4is.data.containers.ProductLanguageContainer;
import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductLanguage;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.system.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nedzad
 */
public class DataController {
    
    public static ProductContainer getProducts() {
        try {
            ProductContainer products = new ProductContainer();
            
            String sql = "SELECT p.product_id, p.name, p.path, pt.product_type_id, pt.name, pl.product_language_id, pl.name, pp.product_printer_id, pp.name, p.prod_note " +
                    "FROM product p " +
                    "JOIN product_type pt ON p.product_type_id = pt.product_type_id " +
                    "JOIN product_language pl ON p.product_language_id = pl.product_language_id " +
                    "JOIN product_printer pp ON p.product_printer_id = pp.product_printer_id";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            
            while(resultSet.next()) {     
                Product product = new Product(resultSet.getInt("p.product_id"),
                        resultSet.getString("p.name"),
                        resultSet.getString("p.path"),
                        resultSet.getString("pt.name"),
                        resultSet.getString("pl.name"),
                        resultSet.getString("pp.name"),
                        resultSet.getString("p.prod_note"));
                products.addBean(product);
            }
            databaseConnection.disconnect();
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ProductMasterContainer getProductMaster(Product product) {
        try {
            ProductMasterContainer products = new ProductMasterContainer();
            String sql = "SELECT m.master_id, m.name, m.is_braille, m.is_falt, m.is_active, m.path " +
                         "FROM master m " +
                         "WHERE m.product_id = "+product.getProductId()+" ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {     
                boolean leaflet = false;
                boolean is_braille = resultSet.getBoolean("m.is_braille");
                boolean is_falt =  resultSet.getBoolean("m.is_falt");
                boolean is_active =  resultSet.getBoolean("m.is_active");
                
                if(!is_braille && !is_falt) {
                    leaflet = true;
                }
         
                
                ProductMaster productMaster = new ProductMaster(resultSet.getInt("m.master_id"), 
                                                                resultSet.getString("m.name"), 
                                                                leaflet==true?"X":"",
                                                                is_braille?"X":"", 
                                                                is_falt?"X":"", 
                                                                is_active?"X":"", 
                                                                resultSet.getString("m.path"));
                products.addBean(productMaster);
            }
            databaseConnection.disconnect();
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ProductLanguageContainer getProductLanguage() {
        try {
            ProductLanguageContainer productLanguageContainer = new ProductLanguageContainer();
            String sql = "SELECT pl.product_language_id, pl.name " +
                         "FROM product_language pl ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {     
                productLanguageContainer.addBean(new ProductLanguage(resultSet.getInt("pl.product_language_id"), resultSet.getString("pl.name")));
            }
            databaseConnection.disconnect();
            return productLanguageContainer;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static User getUser(String username, String password) {
        try {
            User user = new User();
            String sql = " SELECT u.userId, "+
                         "        u.firstName, " +
                         "        u.lastName, " +
                         "        u.username, " +
                         "        u.password " +
                         " FROM   user u " +
                         " WHERE  u.username = '"+username+"' "+
                         " AND    u.password = '"+password+"' "+
                         " AND    u.isActive = 1";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {     
                user.setUserId(resultSet.getInt("u.userId"));
                user.setFirstName(resultSet.getString("u.firstName"));
                user.setLastName(resultSet.getString("u.lastName"));
                user.setUsername(resultSet.getString("u.username"));
                user.setPassword(resultSet.getString("u.password"));
                return user;
            }
            databaseConnection.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

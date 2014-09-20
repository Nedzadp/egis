/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data;

import com.pss.pp4is.data.containers.InspectionContainer;
import com.pss.pp4is.data.containers.InspectionDetailContainer;
import com.pss.pp4is.data.containers.InspectionProfileContainer;
import com.pss.pp4is.data.containers.ProductContainer;
import com.pss.pp4is.data.containers.ProductLanguageContainer;
import com.pss.pp4is.data.containers.ProductMasterContainer;
import com.pss.pp4is.data.containers.ProductPrinterContainer;
import com.pss.pp4is.data.containers.ProductTypeContainer;
import com.pss.pp4is.data.containers.UserActivityContainer;
import com.pss.pp4is.data.containers.UserContainer;
import com.pss.pp4is.data.containers.UserProductContainer;
import com.pss.pp4is.data.models.CustomTranslation;
import com.pss.pp4is.data.models.Inspection;
import com.pss.pp4is.data.models.InspectionDetail;
import com.pss.pp4is.data.models.InspectionProfile;
import com.pss.pp4is.data.models.Product;
import com.pss.pp4is.data.models.ProductLanguage;
import com.pss.pp4is.data.models.ProductMaster;
import com.pss.pp4is.data.models.ProductPrinter;
import com.pss.pp4is.data.models.ProductType;
import com.pss.pp4is.data.models.TranslationComponent;
import com.pss.pp4is.data.models.User;
import com.pss.pp4is.data.models.UserActivity;
import com.pss.pp4is.data.models.UserProduct;
import com.pss.pp4is.system.DatabaseConnection;
import com.pss.pp4is.system.LanguageEnum;
import com.pss.pp4is.system.Translation;
import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    public static ProductTypeContainer getProductType() {
        try {
            ProductTypeContainer productTypeContainer = new ProductTypeContainer();
            String sql = "SELECT pt.product_type_id, pt.name " +
                         "FROM product_type pt ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {     
                productTypeContainer.addBean(new ProductType(resultSet.getInt("pt.product_type_id"), resultSet.getString("pt.name")));
            }
            databaseConnection.disconnect();
            return productTypeContainer;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ProductPrinterContainer getProductPrinter() {
        try {
            ProductPrinterContainer productPrinterContainer = new ProductPrinterContainer();
            String sql = "SELECT pp.product_printer_id, pp.name " +
                         "FROM product_printer pp ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {     
                productPrinterContainer.addBean(new ProductPrinter(resultSet.getInt("pp.product_printer_id"), resultSet.getString("pp.name")));
            }
            databaseConnection.disconnect();
            return productPrinterContainer;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static UserContainer getUsers() {
        try {
            UserContainer userContainer = new UserContainer();
            String sql = "SELECT * FROM  user ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {  
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setLanguage(resultSet.getString("language"));
                user.setIsActive(resultSet.getBoolean("isActive")?"X":"");
                user.setSuperUser(resultSet.getBoolean("isSuperUser"));
                userContainer.addBean(user);
            }
            databaseConnection.disconnect();
            return userContainer;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static InspectionProfileContainer getInspectionProfiles() {
        try {
            InspectionProfileContainer inspectionProfileContainer = new InspectionProfileContainer();
            String sql = "SELECT * FROM  inspection_profile ";
            
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            if(resultSet == null) {
                databaseConnection.disconnect();
                return null;
            }
            while(resultSet.next()) {  
                InspectionProfile inspectionProfile = new InspectionProfile();
                inspectionProfile.setInspectionProfileId(resultSet.getInt("inspection_profile_id"));
                inspectionProfile.setName(resultSet.getString("name"));
                inspectionProfile.setGrayToWhiteFrom(resultSet.getInt("grayToWhiteFrom"));
                inspectionProfile.setErrorCuttingFrom(resultSet.getInt("errorCuttingFrom"));
                inspectionProfile.setSubSquareSize(resultSet.getInt("subSquareSize"));
                inspectionProfile.setMaxRotation(resultSet.getDouble("maxRotation"));
                inspectionProfile.setRotationPrecision(resultSet.getInt("rotationPrecision"));
                inspectionProfile.setErrorGroupsMaxGap(resultSet.getInt("errorGroupsMaxGap"));
                inspectionProfile.setErrorGroupMinSize(resultSet.getInt("errorGroupMinSize"));
                inspectionProfile.setErrorErosionCount(resultSet.getInt("errorErosionCount"));
                inspectionProfile.setErrorDilationCount(resultSet.getInt("errorDilationCount"));
                inspectionProfile.setProfileNote(resultSet.getString("profile_note"));
                inspectionProfile.setSampleName(resultSet.getString("sampleName"));
                inspectionProfile.setSamplePath(resultSet.getString("samplePath"));
                inspectionProfile.setZtolerance(resultSet.getDouble("ztolerance"));
                inspectionProfile.setHorisontalOverlapCoeffLeft(resultSet.getDouble("horisontalOverlapCoeffLeft"));
                inspectionProfile.setHorisontalInsideCoeffLeft(resultSet.getDouble("horisontalInsideCoeffLeft"));
                inspectionProfile.setHorisontalDistanceCoeffLeft(resultSet.getDouble("horisontalDistanceCoeffLeft"));
                inspectionProfile.setVerticalOverlapCoeffLeft(resultSet.getDouble("verticalOverlapCoeffLeft"));
                inspectionProfile.setVerticalInsideCoeffLeft(resultSet.getDouble("verticalInsideCoeffLeft"));
                inspectionProfile.setVerticalDistanceCoeffLeft(resultSet.getDouble("verticalDistanceCoeffLeft"));
                inspectionProfile.setHorisontalOverlapCoeffRight(resultSet.getDouble("horisontalOverlapCoeffRight"));
                inspectionProfile.setOrisontalInsideCoeffRight(resultSet.getDouble("orisontalInsideCoeffRight"));
                inspectionProfile.setOrisontalDistanceCoeffRight(resultSet.getDouble("orisontalDistanceCoeffRight"));
                inspectionProfile.setVerticalOverlapCoeffRight(resultSet.getDouble("verticalOverlapCoeffRight"));
                inspectionProfile.setVerticalInsideCoeffRight(resultSet.getDouble("verticalInsideCoeffRight"));
                inspectionProfile.setVerticalDistanceCoeffRight(resultSet.getDouble("verticalDistanceCoeffRight"));
                inspectionProfileContainer.addBean(inspectionProfile);
            }
            databaseConnection.disconnect();
            return inspectionProfileContainer;
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static User getUser(String username, String password) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            User user = new User();
            String sql = " SELECT u.userId, "+
                         "        u.firstName, " +
                         "        u.lastName, " +
                         "        u.username, " +
                         "        u.password, " +
                         "        u.isSuperUser, " +
                         "        u.language "+
                         " FROM   user u " +
                         " WHERE  u.username = '"+username+"' "+
                         " AND    u.password = '"+password+"' "+
                         " AND    u.isActive = 1";
           
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
                user.setLanguage(resultSet.getString("u.language"));
                user.setSuperUser(resultSet.getBoolean("u.isSuperUser"));
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        } 
        return null;
    }

    public static void insertUserActivity(User user) {
        String sql = "INSERT INTO user_activity(logged_in, user_id) VALUES(NOW(), ?)";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            databaseConnection.disconnect();
        }    
    }

    public static void updateUserActivity(User user) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT id FROM user_activity WHERE user_id = "+user.getUserId()+" ORDER BY id DESC LIMIT 1";
        try {
            databaseConnection.connect();
             ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            if(resultSet == null) {
                databaseConnection.disconnect();
            } else {
                Integer activity_id = null;
                while(resultSet.next()) {
                    activity_id = resultSet.getInt("id");
                }
                String updateSql = "UPDATE user_activity SET logged_out = NOW() WHERE id = ?";
                PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(updateSql);
                preparedStatement.clearParameters();
                preparedStatement.setInt(1, activity_id);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
    }
    
    public static Integer getTimerMinutes() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT timer FROM user_clock LIMIT 1";
        Integer timer = null;
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                timer = resultSet.getInt("timer");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return timer;
    }

    public static void updateTimerUserActivity(User user) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT id FROM user_activity WHERE user_id = "+user.getUserId()+" ORDER BY id DESC LIMIT 1";
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            if(resultSet == null) {
                databaseConnection.disconnect();
            } else {
                Integer activity_id = null;
                while(resultSet.next()) {
                    activity_id = resultSet.getInt("id");
                }
                String updateSql = "UPDATE user_activity SET reset_clock_counter = reset_clock_counter+1 WHERE id = ?";
                PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(updateSql);
                preparedStatement.clearParameters();
                preparedStatement.setInt(1, activity_id);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
    }
    
    public static UserActivityContainer getUserActivities() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT ua.id, ua.logged_in, ua.logged_out, ua.reset_clock_counter, u.username "
                         + "FROM user_activity ua "
                         + "JOIN user u ON ua.user_id = u.userId "
                         + "ORDER BY u.username";
        
        UserActivityContainer userActivityContainer = new UserActivityContainer();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                UserActivity userActivity = new UserActivity();
                userActivity.setId(resultSet.getInt("ua.id"));
                userActivity.setLoggedIn(resultSet.getTimestamp("ua.logged_in"));
                userActivity.setLoggedOut(resultSet.getTimestamp("ua.logged_out"));
                userActivity.setClockReset(resultSet.getInt("ua.reset_clock_counter"));
                userActivity.setUsername(resultSet.getString("u.username"));
                userActivityContainer.addBean(userActivity);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return userActivityContainer;
    }

    public static UserActivityContainer getFilteredActivities(String username, Date fromDate, Date toDate) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT ua.id, ua.logged_in, ua.logged_out, ua.reset_clock_counter, u.username "
                         + "FROM user_activity ua "
                         + "JOIN user u ON ua.user_id = u.userId "
                         + "WHERE u.username LIKE '"+username+"' ";
        if(fromDate != null) {
            selectSql += "AND ua.logged_in >= '"+new java.sql.Date(fromDate.getTime())+"' ";
        }
        if(toDate != null) {
            selectSql += "AND ua.logged_out <= '"+new java.sql.Date(toDate.getTime())+"' ";
        }
            selectSql += "ORDER BY u.username";
        
        UserActivityContainer userActivityContainer = new UserActivityContainer();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                UserActivity userActivity = new UserActivity();
                userActivity.setId(resultSet.getInt("ua.id"));
                userActivity.setLoggedIn(resultSet.getTimestamp("ua.logged_in"));
                userActivity.setLoggedOut(resultSet.getTimestamp("ua.logged_out"));
                userActivity.setClockReset(resultSet.getInt("ua.reset_clock_counter"));
                userActivity.setUsername(resultSet.getString("u.username"));
                userActivityContainer.addBean(userActivity);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return userActivityContainer;
    }
    
    public static InspectionContainer getProductInspections(int productId) {
        InspectionContainer inspectionContainer = new InspectionContainer();
        String selectSql = "SELECT i.inspection_id, i.insp_date, i.path, i.inspector, i.cikk_num, i.meo_num, i.naplo_num, i.taska_num, i.closed "
                        + "FROM inspection i "
                        + "JOIN product p ON i.product_id = p.product_id "
                        + "WHERE i.product_id = "+productId+" ";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                Inspection inspection = new Inspection();
                inspection.setInspectionId(resultSet.getInt("i.inspection_id"));
                inspection.setInspectionDate(resultSet.getString("i.insp_date"));
                inspection.setPath(resultSet.getString("i.path"));
                inspection.setInspector(resultSet.getString("i.inspector"));
                inspection.setCikkNum(resultSet.getString("i.cikk_num"));
                inspection.setMeoNum(resultSet.getString("i.meo_num"));
                inspection.setNaploNum(resultSet.getString("i.naplo_num"));
                inspection.setTaskaNum(resultSet.getString("i.taska_num"));
                boolean closed = resultSet.getBoolean("i.closed");
                inspection.setClosed(closed?"X":"");
                inspectionContainer.addBean(inspection);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return inspectionContainer;
    }
    
    public static InspectionDetailContainer getInspectionDetails(int inspectionId, int masterId) {
        InspectionDetailContainer inspectionDetailContainer = new InspectionDetailContainer();
        String selectSql = "SELECT id.inspection_details_id, id.master_id, m.name, id.vizsgalt_name, id.vizsgalt_feltoltve_path, id.eredmeny_path, id.jelolt_path, "
                         + "id.maszk_path, id.mester_path, id.mester_feldolgozott_path, id.vizsgalt_path, id.vizsgalt_feldolgozott_path, id.jelolt_szamozott_path, "
                         + "id.elfogadva, id.engedellyel_elfogadva, id.elutasitva, id.inspection_profile_notes, id.onTheBunchList, id.urgent, id.vizsgalt_feltoltve_path_pdf "
                         + "FROM inspection_details id "
                         + "JOIN master m ON id.master_id = m.master_id "
                         + "WHERE id.inspection_id = "+inspectionId+" "
                         + "AND id.master_id = "+masterId+" ";
                
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                InspectionDetail inspectionDetail = new InspectionDetail();
                inspectionDetail.setInspection_details_id(resultSet.getInt("id.inspection_details_id"));
                inspectionDetail.setElfogadva(resultSet.getBoolean("id.elfogadva")?"X":"");
                inspectionDetail.setMaster_id(resultSet.getInt("id.master_id"));
                inspectionDetail.setMasterName(resultSet.getString("m.name"));
                inspectionDetail.setVizsgalt_name(resultSet.getString("id.vizsgalt_name"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feltoltve_path"));
                inspectionDetail.setEredmeny_path(resultSet.getString("id.eredmeny_path"));
                inspectionDetail.setJelolt_path(resultSet.getString("id.jelolt_path"));
                inspectionDetail.setMaszk_path(resultSet.getString("id.maszk_path"));
                inspectionDetail.setMester_path(resultSet.getString("id.mester_path"));
                inspectionDetail.setMester_feldolgozott_path(resultSet.getString("id.mester_feldolgozott_path"));
                inspectionDetail.setVizsgalt_path(resultSet.getString("id.vizsgalt_path"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feldolgozott_path"));
                inspectionDetail.setJelolt_szamozott_path(resultSet.getString("id.jelolt_szamozott_path"));
                inspectionDetail.setEngedellyel_elfogadva(resultSet.getBoolean("id.engedellyel_elfogadva")?"X":"");
                inspectionDetail.setElutasitva(resultSet.getBoolean("id.elutasitva")?"X":"");
                inspectionDetail.setInspection_profile_notes(resultSet.getString("id.inspection_profile_notes"));
                inspectionDetail.setOnTheBunchList(resultSet.getBoolean("id.onTheBunchList")?"X":"");
                inspectionDetail.setUrgent(resultSet.getBoolean("id.urgent")?"X":"");
                inspectionDetail.setVizsgalt_feltoltve_path_pdf(resultSet.getString("id.vizsgalt_feltoltve_path_pdf"));
                inspectionDetailContainer.addBean(inspectionDetail);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return inspectionDetailContainer;
    }

    public static InspectionDetailContainer getInspectionDetailsByProduct(int productId) {
        InspectionDetailContainer inspectionDetailContainer = new InspectionDetailContainer();
        
        String selectSql = "SELECT id.inspection_details_id, id.master_id, m.name, id.vizsgalt_name, id.vizsgalt_feltoltve_path, id.eredmeny_path, id.jelolt_path, "
                         + "id.maszk_path, id.mester_path, id.mester_feldolgozott_path, id.vizsgalt_path, id.vizsgalt_feldolgozott_path, id.jelolt_szamozott_path, "
                         + "id.elfogadva, id.engedellyel_elfogadva, id.elutasitva, id.inspection_profile_notes, id.onTheBunchList, id.urgent, id.vizsgalt_feltoltve_path_pdf "
                         + "FROM inspection_details id "
                         + "JOIN master m ON id.master_id = m.master_id "
                         + "JOIN inspection i ON id.inspection_id = i.inspection_id "
                         + "JOIN product p ON i.product_id = p.product_id "
                         + "WHERE i.product_id = "+productId+" ";
                
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                InspectionDetail inspectionDetail = new InspectionDetail();
                inspectionDetail.setInspection_details_id(resultSet.getInt("id.inspection_details_id"));
                inspectionDetail.setElfogadva(resultSet.getBoolean("id.elfogadva")?"X":"");
                inspectionDetail.setMaster_id(resultSet.getInt("id.master_id"));
                inspectionDetail.setMasterName(resultSet.getString("m.name"));
                inspectionDetail.setVizsgalt_name(resultSet.getString("id.vizsgalt_name"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feltoltve_path"));
                inspectionDetail.setEredmeny_path(resultSet.getString("id.eredmeny_path"));
                inspectionDetail.setJelolt_path(resultSet.getString("id.jelolt_path"));
                inspectionDetail.setMaszk_path(resultSet.getString("id.maszk_path"));
                inspectionDetail.setMester_path(resultSet.getString("id.mester_path"));
                inspectionDetail.setMester_feldolgozott_path(resultSet.getString("id.mester_feldolgozott_path"));
                inspectionDetail.setVizsgalt_path(resultSet.getString("id.vizsgalt_path"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feldolgozott_path"));
                inspectionDetail.setJelolt_szamozott_path(resultSet.getString("id.jelolt_szamozott_path"));
                inspectionDetail.setEngedellyel_elfogadva(resultSet.getBoolean("id.engedellyel_elfogadva")?"X":"");
                inspectionDetail.setElutasitva(resultSet.getBoolean("id.elutasitva")?"X":"");
                inspectionDetail.setInspection_profile_notes(resultSet.getString("id.inspection_profile_notes"));
                inspectionDetail.setOnTheBunchList(resultSet.getBoolean("id.onTheBunchList")?"X":"");
                inspectionDetail.setUrgent(resultSet.getBoolean("id.urgent")?"X":"");
                inspectionDetail.setVizsgalt_feltoltve_path_pdf(resultSet.getString("id.vizsgalt_feltoltve_path_pdf"));
                inspectionDetailContainer.addBean(inspectionDetail);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return inspectionDetailContainer;
    }

    public static InspectionDetailContainer getInspectionDetailsByMaster(int masterId, int inspectionId) {
        InspectionDetailContainer inspectionDetailContainer = new InspectionDetailContainer();
        
        String selectSql = "SELECT id.inspection_details_id, id.master_id, m.name, id.vizsgalt_name, id.vizsgalt_feltoltve_path, id.eredmeny_path, id.jelolt_path, "
                         + "id.maszk_path, id.mester_path, id.mester_feldolgozott_path, id.vizsgalt_path, id.vizsgalt_feldolgozott_path, id.jelolt_szamozott_path, "
                         + "id.elfogadva, id.engedellyel_elfogadva, id.elutasitva, id.inspection_profile_notes, id.onTheBunchList, id.urgent, id.vizsgalt_feltoltve_path_pdf "
                         + "FROM inspection_details id "
                         + "JOIN master m ON id.master_id = m.master_id "
                         + "JOIN inspection i ON id.inspection_id = i.inspection_id "
                         + "JOIN product p ON i.product_id = p.product_id "
                         + "WHERE id.master_id = "+masterId+" "
                         + "AND id.inspection_id = "+inspectionId+" ";
                
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                InspectionDetail inspectionDetail = new InspectionDetail();
                inspectionDetail.setInspection_details_id(resultSet.getInt("id.inspection_details_id"));
                inspectionDetail.setElfogadva(resultSet.getBoolean("id.elfogadva")?"X":"");
                inspectionDetail.setMaster_id(resultSet.getInt("id.master_id"));
                inspectionDetail.setMasterName(resultSet.getString("m.name"));
                inspectionDetail.setVizsgalt_name(resultSet.getString("id.vizsgalt_name"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feltoltve_path"));
                inspectionDetail.setEredmeny_path(resultSet.getString("id.eredmeny_path"));
                inspectionDetail.setJelolt_path(resultSet.getString("id.jelolt_path"));
                inspectionDetail.setMaszk_path(resultSet.getString("id.maszk_path"));
                inspectionDetail.setMester_path(resultSet.getString("id.mester_path"));
                inspectionDetail.setMester_feldolgozott_path(resultSet.getString("id.mester_feldolgozott_path"));
                inspectionDetail.setVizsgalt_path(resultSet.getString("id.vizsgalt_path"));
                inspectionDetail.setVizsgalt_feldolgozott_path(resultSet.getString("id.vizsgalt_feldolgozott_path"));
                inspectionDetail.setJelolt_szamozott_path(resultSet.getString("id.jelolt_szamozott_path"));
                inspectionDetail.setEngedellyel_elfogadva(resultSet.getBoolean("id.engedellyel_elfogadva")?"X":"");
                inspectionDetail.setElutasitva(resultSet.getBoolean("id.elutasitva")?"X":"");
                inspectionDetail.setInspection_profile_notes(resultSet.getString("id.inspection_profile_notes"));
                inspectionDetail.setOnTheBunchList(resultSet.getBoolean("id.onTheBunchList")?"X":"");
                inspectionDetail.setUrgent(resultSet.getBoolean("id.urgent")?"X":"");
                inspectionDetail.setVizsgalt_feltoltve_path_pdf(resultSet.getString("id.vizsgalt_feltoltve_path_pdf"));
                inspectionDetailContainer.addBean(inspectionDetail);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return inspectionDetailContainer;
    }

    public static InspectionContainer getProductInspectionsByMaster(int masterId) {
        InspectionContainer inspectionContainer = new InspectionContainer();
        String selectSql = "SELECT i.inspection_id, i.insp_date, i.path, i.inspector, i.cikk_num, i.meo_num, i.naplo_num, i.taska_num, i.closed "
                        + "FROM inspection i "
                        + "JOIN product p ON i.product_id = p.product_id "
                        + "JOIN master m ON i.product_id = m.product_id "
                        + "WHERE m.master_id = "+masterId+" ";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                Inspection inspection = new Inspection();
                inspection.setInspectionId(resultSet.getInt("i.inspection_id"));
                inspection.setInspectionDate(resultSet.getString("i.insp_date"));
                inspection.setPath(resultSet.getString("i.path"));
                inspection.setInspector(resultSet.getString("i.inspector"));
                inspection.setCikkNum(resultSet.getString("i.cikk_num"));
                inspection.setMeoNum(resultSet.getString("i.meo_num"));
                inspection.setNaploNum(resultSet.getString("i.naplo_num"));
                inspection.setTaskaNum(resultSet.getString("i.taska_num"));
                boolean closed = resultSet.getBoolean("i.closed");
                inspection.setClosed(closed?"X":"");
                inspectionContainer.addBean(inspection);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return inspectionContainer;
    }
    
    public static List<Translation> getTranslations(String language) {
        List<Translation> translations = new ArrayList<Translation>();
        
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT keyword, english, magyar FROM translation;";
        
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
               Translation translation = new Translation();
               translation.setKeyword(resultSet.getString("keyword"));
               
                if(LanguageEnum.getENGLISH().getLang().equals(language) && resultSet.getString("english")!=null) {
                   translation.setTranslation(resultSet.getString("english"));
                } else if(LanguageEnum.getHUNGARIAN().getLang().equals(language) && resultSet.getString("magyar")!=null) {
                   translation.setTranslation(resultSet.getString("magyar"));
                } else {
                    translation.setTranslation(resultSet.getString("keyword"));
                }
                translations.add(translation);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        
        return translations;
    }

    public static void insertKeywordForTranslation(String keyword) {
        String sql = "INSERT INTO translation(keyword) VALUES(?)";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, keyword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            databaseConnection.disconnect();
        }   
    }
    
    
     public static Container getTranslations() {
        List<TranslationComponent> translations = new ArrayList<TranslationComponent>();
        Container container = new BeanItemContainer(TranslationComponent.class);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT id,keyword, english, magyar FROM translation;";
        
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
               TranslationComponent translation = new TranslationComponent();
               translation.setKeyword(resultSet.getString("keyword"));
               translation.setEnglishTranslation(new CustomTranslation(resultSet.getInt("id"), resultSet.getString("english"), LanguageEnum.ENGLISH));
               translation.setHungarianTranslation(new CustomTranslation(resultSet.getInt("id"), resultSet.getString("magyar"), LanguageEnum.HUNGARIAN));
               
               container.addItem(translation);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        
        return container;
    }

    public static void updateTranslation(Integer translationId, LanguageEnum languageEnum, String value) {
        String sql = "UPDATE translation SET ";
        if(languageEnum.equals(LanguageEnum.ENGLISH)) {
            sql += " english = ? ";
        } else {
            sql += " magyar = ? ";
        }
        sql += " WHERE id = ? ";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connect();
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, translationId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            databaseConnection.disconnect();
        }
    }
    
    
    public static UserProductContainer getFilteredUserProductActivities(String username, Date fromDate, Date toDate) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String selectSql = "SELECT u.username, p.name, p.create_date, pp.mod_date "
                         + "FROM user u "
                         + "LEFT JOIN product p ON (u.userId = p.create_by_id ) "
                         + "LEFT JOIN product pp ON (u.userId = pp.mod_by_id) ";

        if(username != null) {
            selectSql += "WHERE u.username LIKE '"+username+"' ";
        }
        if(fromDate != null) {
            selectSql += "AND (p.create_date >= '"+new java.sql.Date(fromDate.getTime())+"' ";
            selectSql += "OR pp.mod_date >= '"+new java.sql.Date(fromDate.getTime())+"') ";
        }
        if(toDate != null) {
            selectSql += "AND (p.create_date <= '"+new java.sql.Date(toDate.getTime())+"' ";
            selectSql += "OR pp.mod_date <= '"+new java.sql.Date(toDate.getTime())+"') ";
        }
            selectSql += "GROUP BY u.username, p.name, p.create_date, pp.mod_date ";
            
            selectSql += "ORDER BY u.username";
            
        
        UserProductContainer userProductContainer = new UserProductContainer();
        try {
            databaseConnection.connect();
            ResultSet resultSet = databaseConnection.executeQuery(selectSql);
            while(resultSet.next()) {
                UserProduct userProduct = new UserProduct();
                userProduct.setUsername(resultSet.getString("u.username"));
                userProduct.setProductName(resultSet.getString("p.name"));
                userProduct.setCreatedAt(resultSet.getTimestamp("p.create_date"));
                userProduct.setModifiedAt(resultSet.getTimestamp("pp.mod_date"));
                userProductContainer.addBean(userProduct);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            databaseConnection.disconnect();
        }
        return userProductContainer;
    }
}
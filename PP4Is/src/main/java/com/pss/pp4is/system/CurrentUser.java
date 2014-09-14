/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.data.DataController;
import com.pss.pp4is.data.models.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Nedzad
 */
public class CurrentUser {
    
    public static void set() {
        
    }
    
    public static User isAuthenticated(String username, String password) {
   
        String hashedPassword = getHashedPassword(password);
        
        return DataController.getUser(username, hashedPassword);
    }
    
    private static String getHashedPassword(String password) {
        
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            return sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import java.sql.Timestamp;

/**
 *
 * @author Nedzad
 */
public class UserInspection {
    private String username;
    private String productName;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private String created;
    private String modified;

    public String getCreated() {
        return created;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }


    public String getModified() {
        return modified;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

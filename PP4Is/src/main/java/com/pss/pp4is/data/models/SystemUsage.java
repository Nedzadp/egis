/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

/**
 *
 * @author Nedzad
 */
public class SystemUsage {
    private String username;
    private Integer hoursInSystem;
    private Integer newProducts;
    private Integer newInspections;
    private Integer uploadedImages;
    private Integer inspectedImages;

    public SystemUsage() {
        this.hoursInSystem = 0;
        this.newInspections = 0;
        this.newProducts = 0;
        this.uploadedImages = 0;
        this.inspectedImages = 0;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHoursInSystem() {
        return hoursInSystem;
    }

    public void setHoursInSystem(Integer hoursInSystem) {
        this.hoursInSystem = hoursInSystem;
    }

    public Integer getNewProducts() {
        return newProducts;
    }

    public void setNewProducts(Integer newProducts) {
        this.newProducts = newProducts;
    }

    public Integer getNewInspections() {
        return newInspections;
    }

    public void setNewInspections(Integer newInspections) {
        this.newInspections = newInspections;
    }

    public Integer getUploadedImages() {
        return uploadedImages;
    }

    public void setUploadedImages(Integer uploadedImages) {
        this.uploadedImages = uploadedImages;
    }

    public Integer getInspectedImages() {
        return inspectedImages;
    }

    public void setInspectedImages(Integer inspectedImages) {
        this.inspectedImages = inspectedImages;
    }
    
    
}

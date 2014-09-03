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
public class Master {
    private final int masterId;
    private final String name;
    private final String path;
    private final Product product;
    private final String pathPdf;
    private final boolean isBraille;
    private final boolean isFault;
    private final boolean isActive;

    public Master(int masterId, String name, String path, Product product, String pathPdf, boolean isBraille, boolean isFault, boolean isActive) {
        this.masterId = masterId;
        this.name = name;
        this.path = path;
        this.product = product;
        this.pathPdf = pathPdf;
        this.isBraille = isBraille;
        this.isFault = isFault;
        this.isActive = isActive;
    }

    public int getMasterId() {
        return masterId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Product getProduct() {
        return product;
    }

    public String getPathPdf() {
        return pathPdf;
    }

    public boolean isIsBraille() {
        return isBraille;
    }

    public boolean isIsFault() {
        return isFault;
    }

    public boolean isIsActive() {
        return isActive;
    }
}

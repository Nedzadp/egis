/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.models;

import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class Product implements Serializable{
    private final int productId;
    private final String name;
    private final String path;
    private final String productTypeName;
    private final String productLanguageName;
    private final String productPrinterName;
    private final String productNote;

    public Product(int productId, String name, String path, String productTypeName, String productLanguageName, String productPrinterName, String productNote) {
        this.productId = productId;
        this.name = name;
        this.path = path;
        this.productTypeName = productTypeName;
        this.productLanguageName = productLanguageName;
        this.productPrinterName = productPrinterName;
        this.productNote = productNote;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public String getProductLanguageName() {
        return productLanguageName;
    }

    public String getProductPrinterName() {
        return productPrinterName;
    }

    public String getProductNote() {
        return productNote;
    }

}

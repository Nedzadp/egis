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
public class ProductPrinter {
    private final int productPrinterId;
    private final String name;

    public ProductPrinter(int productPrinterId, String name) {
        this.productPrinterId = productPrinterId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getProductPrinterId() {
        return productPrinterId;
    }
}

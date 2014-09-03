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
public class ProductLanguage {
    private final int productLanguageId;
    private final String name;

    public ProductLanguage(int productLanguageId, String name) {
        this.productLanguageId = productLanguageId;
        this.name = name;
    }

    public int getProductLanguageId() {
        return productLanguageId;
    }

    public String getName() {
        return name;
    }
}

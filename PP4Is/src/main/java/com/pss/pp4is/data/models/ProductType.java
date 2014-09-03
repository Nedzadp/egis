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
public class ProductType {
    private final int productTypeId;
    private final String name;

    public ProductType(int productTypeId, String name) {
        this.productTypeId = productTypeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getProductTypeId() {
        return productTypeId;
    }
}

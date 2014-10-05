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
public class ProductMaster implements Serializable{
    
    private final int masterId;
    private final String name;
    private final String type;
    private final String pdf;
    private final String leaflet;
    private final String braille;
    private final String falt;
    private final String active;
    private final String path;

    public ProductMaster(int masterId, String name, String leaflet, String braille, String falt, String active, String path, String type, String pdf) {
        this.masterId = masterId;
        this.name = name;
        this.leaflet = leaflet;
        this.braille = braille;
        this.falt = falt;
        this.active = active;
        this.path = path;
        this.type = type;
        this.pdf = pdf;
    }

    public String getPdf() {
        return pdf;
    }

    
    public int getMasterId() {
        return masterId;
    }

    public String getName() {
        return name;
    }

    public String getLeaflet() {
        return leaflet;
    }

    public String getBraille() {
        return braille;
    }

    public String getFalt() {
        return falt;
    }

    public String getActive() {
        return active;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }
}

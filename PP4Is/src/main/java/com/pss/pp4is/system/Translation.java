/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

/**
 *
 * @author Nedzad
 */
public class Translation {
    private  String keyword;
    private  String translation;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
    public String getKeyword() {
        return keyword;
    }

    public String getTranslation() {
        return translation;
    }
}

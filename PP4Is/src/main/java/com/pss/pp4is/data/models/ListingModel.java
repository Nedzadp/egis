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
public class ListingModel {
    private ListingMiddleContent listingMiddleContent;
    private String value;
    private RightSideListing listingMiddleContent2;
   
    public ListingMiddleContent getListingMiddleContent() {
        return listingMiddleContent;
    }

    public void setListingMiddleContent(ListingMiddleContent listingMiddleContent) {
        this.listingMiddleContent = listingMiddleContent;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RightSideListing getListingMiddleContent2() {
        return listingMiddleContent2;
    }

    public void setListingMiddleContent2(RightSideListing listingMiddleContent2) {
        this.listingMiddleContent2 = listingMiddleContent2;
    }
}

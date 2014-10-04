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
public class NewProductListing {
    private Integer productId;
    private String productName;
    private Integer inspections;
    private Integer masterImages;
    private Integer inspectedImages;
    private String inspectedImagesColor;
    private Integer analyses;
    private String analysesColor;
    private Integer certificates;
    private String certificatesColor;

    public NewProductListing() {
        this.inspections = 0;
        this.masterImages = 0;
        this.inspectedImages = 0;
        this.analyses = 0;
        this.certificates = 0;
    }

    public String getInspectedImagesColor() {
        return inspectedImagesColor;
    }

    public void setInspectedImagesColor(String inspectedImagesColor) {
        this.inspectedImagesColor = inspectedImagesColor;
    }

    public String getAnalysesColor() {
        return analysesColor;
    }

    public void setAnalysesColor(String analysesColor) {
        this.analysesColor = analysesColor;
    }

    public String getCertificatesColor() {
        return certificatesColor;
    }

    public void setCertificatesColor(String certificatesColor) {
        this.certificatesColor = certificatesColor;
    }
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getInspections() {
        return inspections;
    }

    public void setInspections(Integer inspections) {
        this.inspections = inspections;
    }

    public Integer getMasterImages() {
        return masterImages;
    }

    public void setMasterImages(Integer masterImages) {
        this.masterImages = masterImages;
    }

    public Integer getInspectedImages() {
        return inspectedImages;
    }

    public void setInspectedImages(Integer inspectedImages) {
        this.inspectedImages = inspectedImages;
    }

    public Integer getAnalyses() {
        return analyses;
    }

    public void setAnalyses(Integer analyses) {
        this.analyses = analyses;
    }

    public Integer getCertificates() {
        return certificates;
    }

    public void setCertificates(Integer certificates) {
        this.certificates = certificates;
    }
}

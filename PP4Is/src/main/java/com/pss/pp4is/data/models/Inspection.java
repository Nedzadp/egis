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
public class Inspection {
    private final int inspectionId;
    private final Product product;
    private final String inspectionDate;
    private final String path;
    private final String inspector;
    private final String cikkNum;
    private final String meoNum;
    private final String naploNum;
    private final String taskaNum;
    private final boolean closed;

    public Inspection(int inspectionId, Product product, String inspectionDate, String path, String inspector, String cikkNum, String meoNum, String naploNum, String taskaNum, boolean closed) {
        this.inspectionId = inspectionId;
        this.product = product;
        this.inspectionDate = inspectionDate;
        this.path = path;
        this.inspector = inspector;
        this.cikkNum = cikkNum;
        this.meoNum = meoNum;
        this.naploNum = naploNum;
        this.taskaNum = taskaNum;
        this.closed = closed;
    }

    public int getInspectionId() {
        return inspectionId;
    }

    public Product getProduct() {
        return product;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public String getPath() {
        return path;
    }

    public String getInspector() {
        return inspector;
    }

    public String getCikkNum() {
        return cikkNum;
    }

    public String getMeoNum() {
        return meoNum;
    }

    public String getNaploNum() {
        return naploNum;
    }

    public String getTaskaNum() {
        return taskaNum;
    }

    public boolean isClosed() {
        return closed;
    }
}

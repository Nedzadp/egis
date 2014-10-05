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
    private  Integer inspectionId;
    private  String inspectionDate;
    private  String path;
    private  String inspector;
    private  String cikkNum;
    private  String meoNum;
    private  String naploNum;
    private  String taskaNum;
    private  String closed;

    public Integer getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getCikkNum() {
        return cikkNum;
    }

    public void setCikkNum(String cikkNum) {
        this.cikkNum = cikkNum;
    }

    public String getMeoNum() {
        return meoNum;
    }

    public void setMeoNum(String meoNum) {
        this.meoNum = meoNum;
    }

    public String getNaploNum() {
        return naploNum;
    }

    public void setNaploNum(String naploNum) {
        this.naploNum = naploNum;
    }

    public String getTaskaNum() {
        return taskaNum;
    }

    public void setTaskaNum(String taskaNum) {
        this.taskaNum = taskaNum;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

  

}

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
public class InspectionProfile {
    private int inspectionProfileId;
    private String name;
    private Integer grayToWhiteFrom;
    private Integer errorCuttingFrom;
    private Integer subSquareSize;
    private Double maxRotation;
    private Integer rotationPrecision;
    private Integer errorGroupsMaxGap;
    private Integer errorGroupMinSize;
    private Integer errorErosionCount; 
    private Integer errorDilationCount;
    private String profileNote;
    private String sampleName;
    private String samplePath;
    private Double ztolerance;
    private Double horisontalOverlapCoeffLeft;
    private Double horisontalInsideCoeffLeft;
    private Double horisontalDistanceCoeffLeft;
    private Double verticalOverlapCoeffLeft;
    private Double verticalInsideCoeffLeft;
    private Double verticalDistanceCoeffLeft;
    private Double horisontalOverlapCoeffRight;
    private Double orisontalInsideCoeffRight;
    private Double orisontalDistanceCoeffRight;
    private Double verticalOverlapCoeffRight;
    private Double verticalInsideCoeffRight;
    private Double verticalDistanceCoeffRight;

    public int getInspectionProfileId() {
        return inspectionProfileId;
    }

    public void setInspectionProfileId(int inspectionProfileId) {
        this.inspectionProfileId = inspectionProfileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrayToWhiteFrom() {
        return grayToWhiteFrom;
    }

    public void setGrayToWhiteFrom(Integer grayToWhiteFrom) {
        this.grayToWhiteFrom = grayToWhiteFrom;
    }

    public Integer getErrorCuttingFrom() {
        return errorCuttingFrom;
    }

    public void setErrorCuttingFrom(Integer errorCuttingFrom) {
        this.errorCuttingFrom = errorCuttingFrom;
    }

    public Integer getSubSquareSize() {
        return subSquareSize;
    }

    public void setSubSquareSize(Integer subSquareSize) {
        this.subSquareSize = subSquareSize;
    }

    public Double getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(Double maxRotation) {
        this.maxRotation = maxRotation;
    }

    public Integer getRotationPrecision() {
        return rotationPrecision;
    }

    public void setRotationPrecision(Integer rotationPrecision) {
        this.rotationPrecision = rotationPrecision;
    }

    public Integer getErrorGroupsMaxGap() {
        return errorGroupsMaxGap;
    }

    public void setErrorGroupsMaxGap(Integer errorGroupsMaxGap) {
        this.errorGroupsMaxGap = errorGroupsMaxGap;
    }

    public Integer getErrorGroupMinSize() {
        return errorGroupMinSize;
    }

    public void setErrorGroupMinSize(Integer errorGroupMinSize) {
        this.errorGroupMinSize = errorGroupMinSize;
    }

    public Integer getErrorErosionCount() {
        return errorErosionCount;
    }

    public void setErrorErosionCount(Integer errorErosionCount) {
        this.errorErosionCount = errorErosionCount;
    }

    public Integer getErrorDilationCount() {
        return errorDilationCount;
    }

    public void setErrorDilationCount(Integer errorDilationCount) {
        this.errorDilationCount = errorDilationCount;
    }

    public String getProfileNote() {
        return profileNote;
    }

    public void setProfileNote(String profileNote) {
        this.profileNote = profileNote;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSamplePath() {
        return samplePath;
    }

    public void setSamplePath(String samplePath) {
        this.samplePath = samplePath;
    }

    public Double getZtolerance() {
        return ztolerance;
    }

    public void setZtolerance(Double ztolerance) {
        this.ztolerance = ztolerance;
    }

    public Double getHorisontalOverlapCoeffLeft() {
        return horisontalOverlapCoeffLeft;
    }

    public void setHorisontalOverlapCoeffLeft(Double horisontalOverlapCoeffLeft) {
        this.horisontalOverlapCoeffLeft = horisontalOverlapCoeffLeft;
    }

    public Double getHorisontalInsideCoeffLeft() {
        return horisontalInsideCoeffLeft;
    }

    public void setHorisontalInsideCoeffLeft(Double horisontalInsideCoeffLeft) {
        this.horisontalInsideCoeffLeft = horisontalInsideCoeffLeft;
    }

    public Double getHorisontalDistanceCoeffLeft() {
        return horisontalDistanceCoeffLeft;
    }

    public void setHorisontalDistanceCoeffLeft(Double horisontalDistanceCoeffLeft) {
        this.horisontalDistanceCoeffLeft = horisontalDistanceCoeffLeft;
    }

    public Double getVerticalOverlapCoeffLeft() {
        return verticalOverlapCoeffLeft;
    }

    public void setVerticalOverlapCoeffLeft(Double verticalOverlapCoeffLeft) {
        this.verticalOverlapCoeffLeft = verticalOverlapCoeffLeft;
    }

    public Double getVerticalInsideCoeffLeft() {
        return verticalInsideCoeffLeft;
    }

    public void setVerticalInsideCoeffLeft(Double verticalInsideCoeffLeft) {
        this.verticalInsideCoeffLeft = verticalInsideCoeffLeft;
    }

    public Double getVerticalDistanceCoeffLeft() {
        return verticalDistanceCoeffLeft;
    }

    public void setVerticalDistanceCoeffLeft(Double verticalDistanceCoeffLeft) {
        this.verticalDistanceCoeffLeft = verticalDistanceCoeffLeft;
    }

    public Double getHorisontalOverlapCoeffRight() {
        return horisontalOverlapCoeffRight;
    }

    public void setHorisontalOverlapCoeffRight(Double horisontalOverlapCoeffRight) {
        this.horisontalOverlapCoeffRight = horisontalOverlapCoeffRight;
    }

    public Double getOrisontalInsideCoeffRight() {
        return orisontalInsideCoeffRight;
    }

    public void setOrisontalInsideCoeffRight(Double orisontalInsideCoeffRight) {
        this.orisontalInsideCoeffRight = orisontalInsideCoeffRight;
    }

    public Double getOrisontalDistanceCoeffRight() {
        return orisontalDistanceCoeffRight;
    }

    public void setOrisontalDistanceCoeffRight(Double orisontalDistanceCoeffRight) {
        this.orisontalDistanceCoeffRight = orisontalDistanceCoeffRight;
    }

    public Double getVerticalOverlapCoeffRight() {
        return verticalOverlapCoeffRight;
    }

    public void setVerticalOverlapCoeffRight(Double verticalOverlapCoeffRight) {
        this.verticalOverlapCoeffRight = verticalOverlapCoeffRight;
    }

    public Double getVerticalInsideCoeffRight() {
        return verticalInsideCoeffRight;
    }

    public void setVerticalInsideCoeffRight(Double verticalInsideCoeffRight) {
        this.verticalInsideCoeffRight = verticalInsideCoeffRight;
    }

    public Double getVerticalDistanceCoeffRight() {
        return verticalDistanceCoeffRight;
    }

    public void setVerticalDistanceCoeffRight(Double verticalDistanceCoeffRight) {
        this.verticalDistanceCoeffRight = verticalDistanceCoeffRight;
    }

    
    
}

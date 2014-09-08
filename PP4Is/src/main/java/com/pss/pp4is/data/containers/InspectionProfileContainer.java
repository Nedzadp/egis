/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.InspectionProfile;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class InspectionProfileContainer extends BeanItemContainer<InspectionProfile> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "inspectionProfileId", "name", "grayToWhiteFrom", "errorCuttingFrom", "subSquareSize", "maxRotation", "rotationPrecision", "errorGroupsMaxGap",
        "errorGroupMinSize", "errorErosionCount", "errorDilationCount", "profileNote", "sampleName", "samplePath", "ztolerance", "horisontalOverlapCoeffLeft",
        "horisontalInsideCoeffLeft", "horisontalDistanceCoeffLeft", "verticalOverlapCoeffLeft", "verticalInsideCoeffLeft", "verticalDistanceCoeffLeft",
        "horisontalOverlapCoeffRight", "orisontalInsideCoeffRight", "orisontalDistanceCoeffRight", "verticalOverlapCoeffRight", "verticalInsideCoeffRight",
        "verticalDistanceCoeffRight"
    };

    public static final String[] COL_HEADERS_ENGLISH = new String[] {
        "Inspection profile id", "Name", "Gray to white from", "Error cutting from", "SubSquare size", "maxRotation", "rotationPrecision", "errorGroupsMaxGap",
        "errorGroupMinSize", "errorErosionCount", "errorDilationCount", "profileNote", "sampleName", "samplePath", "ztolerance", "horisontalOverlapCoeffLeft",
        "horisontalInsideCoeffLeft", "horisontalDistanceCoeffLeft", "verticalOverlapCoeffLeft", "verticalInsideCoeffLeft", "verticalDistanceCoeffLeft",
        "horisontalOverlapCoeffRight", "orisontalInsideCoeffRight", "orisontalDistanceCoeffRight", "verticalOverlapCoeffRight", "verticalInsideCoeffRight",
        "verticalDistanceCoeffRight"
    };
    
    public InspectionProfileContainer() throws IllegalArgumentException {
        super(InspectionProfile.class);
    }
    
}

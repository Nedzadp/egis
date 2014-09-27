/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.InspectionProfile;
import com.pss.pp4is.system.LayoutController;
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

    public  String[] COL_HEADERS_ENGLISH;
    
    public InspectionProfileContainer() throws IllegalArgumentException {
        super(InspectionProfile.class);
    }

    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
         COL_HEADERS_ENGLISH = new String[] {
            layoutController.getI18n().translate("Inspection profile id"), 
            layoutController.getI18n().translate("Name"), 
            layoutController.getI18n().translate("Gray to white from"), 
            layoutController.getI18n().translate("Error cutting from"), 
            layoutController.getI18n().translate("SubSquare size"), 
            layoutController.getI18n().translate("max Rotation"), 
            layoutController.getI18n().translate("rotation Precision"), 
            layoutController.getI18n().translate("error Groups Max Gap"),
            layoutController.getI18n().translate("error Group Min Size"), 
            layoutController.getI18n().translate("error Erosion Count"), 
            layoutController.getI18n().translate("error Dilation Count"), 
            layoutController.getI18n().translate("profile Note"), 
            layoutController.getI18n().translate("sample Name"), 
            layoutController.getI18n().translate("sample Path"), 
            layoutController.getI18n().translate("ztolerance"), 
            layoutController.getI18n().translate("horisontal Overlap Coeff Left"),
            layoutController.getI18n().translate("horisontal Inside Coeff Left"), 
            layoutController.getI18n().translate("horisontal Distance Coeff Left"), 
            layoutController.getI18n().translate("vertical Overlap Coeff Left"), 
            layoutController.getI18n().translate("vertical Inside Coeff Left"), 
            layoutController.getI18n().translate("vertical Distance Coeff Left"),
            layoutController.getI18n().translate("horisontal Overlap Coeff Right"), 
            layoutController.getI18n().translate("orisontal Inside Coeff Right"), 
            layoutController.getI18n().translate("orisontal Distance Coeff Right"), 
            layoutController.getI18n().translate("vertical Overlap Coeff Right"), 
            layoutController.getI18n().translate("vertical InsideCoeff Right"),
            layoutController.getI18n().translate("vertical Distance Coeff Right")
        };
         
         return COL_HEADERS_ENGLISH;
    }
    
    
    
}

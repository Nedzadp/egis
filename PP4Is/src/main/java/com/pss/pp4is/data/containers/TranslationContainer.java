/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ProductPrinter;
import com.pss.pp4is.data.models.TranslationComponent;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class TranslationContainer extends BeanItemContainer<TranslationComponent> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "keyword", "englishTranslation", "hungarianTranslation"};

    public String[] COL_HEADERS_ENGLISH;
    
    public TranslationContainer() throws IllegalArgumentException {
        super(TranslationComponent.class);
    }

    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
        COL_HEADERS_ENGLISH = new String[] { layoutController.getI18n().translate("Keyword") ,layoutController.getI18n().translate("English"),layoutController.getI18n().translate("Hungarian")};
        return COL_HEADERS_ENGLISH;
    }
}


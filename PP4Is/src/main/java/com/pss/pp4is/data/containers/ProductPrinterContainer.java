/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.data.containers;

import com.pss.pp4is.data.models.ProductPrinter;
import com.pss.pp4is.system.LayoutController;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Nedzad
 */
public class ProductPrinterContainer extends BeanItemContainer<ProductPrinter> implements Serializable{

    public static final Object[] NATURAL_COL_ORDER = new String[] {
        "productPrinterId", "name"};

    public String[] COL_HEADERS_ENGLISH;
    
    public ProductPrinterContainer() throws IllegalArgumentException {
        super(ProductPrinter.class);
    }

    public String[] getCOL_HEADERS_ENGLISH(LayoutController layoutController) {
        COL_HEADERS_ENGLISH = new String[] { layoutController.getI18n().translate("Product printer id") ,layoutController.getI18n().translate("Name")};
        return COL_HEADERS_ENGLISH;
    }
}

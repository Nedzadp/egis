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
public class CounterHelper {
     private final Integer inspectedImages;
        private final Integer analyses;
        private final Integer certificates;
        private final Integer missingCertificates;
        
        public CounterHelper(Integer inspectedImages, Integer analyses, Integer certificates,Integer missingCertificates) {
            this.inspectedImages = inspectedImages;
            this.analyses = analyses;
            this.certificates = certificates;
            this.missingCertificates = missingCertificates;
        }

        public Integer getAnalyses() {
            return analyses;
        }

        public Integer getCertificates() {
            return certificates;
        }

        public Integer getInspectedImages() {
            return inspectedImages;
        }

    public Integer getMissingCertificates() {
        return missingCertificates;
    }
        
}

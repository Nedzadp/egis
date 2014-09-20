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
public class TranslationComponent {
    private String keyword;
    private CustomTranslation englishTranslation;
    private CustomTranslation hungarianTranslation;

    public void setEnglishTranslation(CustomTranslation englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public void setHungarianTranslation(CustomTranslation hungarianTranslation) {
        this.hungarianTranslation = hungarianTranslation;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public CustomTranslation getEnglishTranslation() {
        return englishTranslation;
    }

    public CustomTranslation getHungarianTranslation() {
        return hungarianTranslation;
    }
}

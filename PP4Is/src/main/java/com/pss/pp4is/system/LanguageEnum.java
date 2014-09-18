/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import com.pss.pp4is.data.models.User;

/**
 *
 * @author Nedzad
 */
public enum LanguageEnum {
    ENGLISH("eng","English"),
    HUNGARIAN("hun","Hungarian");

    private final String lang;
    private final String fullLangName;

    private LanguageEnum(String lang, String fullLangName) {
        this.lang = lang;
        this.fullLangName = fullLangName;
    }

    public String getLang() {
        return lang;
    }

    public String getFullLangName() {
        return fullLangName;
    }

    public static LanguageEnum getENGLISH() {
        return ENGLISH;
    }

    public static LanguageEnum getHUNGARIAN() {
        return HUNGARIAN;
    }
    public static LanguageEnum getUserLanguage(User user) {
        LanguageEnum userLanguage = getENGLISH();
        for(LanguageEnum languageEnum : values()) {
            if(user.getLanguage().equals(languageEnum.getLang())) {
                userLanguage = languageEnum;
                break;
            }
        }
        return userLanguage;
    }
}

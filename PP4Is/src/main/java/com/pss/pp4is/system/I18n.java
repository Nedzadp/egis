
package com.pss.pp4is.system;

import com.pss.pp4is.data.DataController;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Central translation facilities
 * 
 * @author Nedzad
 * 
 */
public class I18n implements Serializable{

    private LanguageEnum languageEnum;
    private Map<String, String> translationMap;//key is keyword and value is translation
    
    
    public I18n(LanguageEnum languageEnum) {
        this.languageEnum = languageEnum;
        loadTranslationMap();
    }

    public void setLanguageEnum(LanguageEnum languageEnum) {
        this.languageEnum = languageEnum;
        loadTranslationMap();
    }

    public LanguageEnum getLanguageEnum() {
        return languageEnum;
    }
    
    public String translate(String keyword){
        for(Map.Entry<String, String> mapEntry : translationMap.entrySet()) {
            System.out.println("KEY: "+mapEntry.getKey()+" VALUE "+mapEntry.getValue());
        }
        if(!translationMap.containsKey(keyword)) {
            DataController.insertKeywordForTranslation(keyword);
            translationMap.put(keyword, keyword);
        } 
        return translationMap.get(keyword);
    }
    
    private void loadTranslationMap() {
        if(translationMap == null) {
            translationMap = new TreeMap<String, String>();
        }
        translationMap.clear();
        
        for(Translation translation : DataController.getTranslations(this.languageEnum.getLang())) {
            translationMap.put(translation.getKeyword(), translation.getTranslation());
        }
    }
}

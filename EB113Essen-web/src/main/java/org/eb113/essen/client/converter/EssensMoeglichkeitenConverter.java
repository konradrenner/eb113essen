/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.client.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.eb113.essen.dto.EssensMoeglichkeit;
import org.eb113.essen.dto.EssensMoeglichkeitFactory;

/**
 *
 * @author koni
 */
@FacesConverter("essensMoeglichkeitenConverter")
public class EssensMoeglichkeitenConverter implements Converter {

    @Override
    public EssensMoeglichkeit getAsObject(FacesContext fc, UIComponent uic, String string) {
        List<EssensMoeglichkeit> allPoss = EssensMoeglichkeitFactory.getAllPossibilities();
        
        System.out.println("Uebergeben:"+string);
        
        for(EssensMoeglichkeit item : allPoss){
            System.out.println("CurrentItem:"+item);
            if(item.toString().equals(string)){
                return item;
            }
        }
        
        throw new IllegalStateException("Selected Option not found!");
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

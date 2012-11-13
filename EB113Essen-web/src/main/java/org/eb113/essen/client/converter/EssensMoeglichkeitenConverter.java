/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.client.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.eb113.essen.dto.EssensMoeglichkeit;
import org.eb113.essen.dto.EssensMoeglichkeiten;

/**
 *
 * @author koni
 */
@FacesConverter("essensMoeglichkeitenConverter")
public class EssensMoeglichkeitenConverter implements Converter {

    @Override
    public EssensMoeglichkeit getAsObject(FacesContext fc, UIComponent uic, String string) {
        EssensMoeglichkeiten[] arr = EssensMoeglichkeiten.values();
        
        System.out.println("Uebergeben:"+string);
        
        for(EssensMoeglichkeiten item : arr){
            System.out.println("CurrentItem:"+item);
            if(item.toString().equals(string)){
                return item.getEssensMoeglichkeit();
            }
        }
        
        throw new IllegalStateException("Selected Option not found!");
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

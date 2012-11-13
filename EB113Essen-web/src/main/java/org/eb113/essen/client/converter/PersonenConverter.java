/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.client.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.eb113.essen.dto.Person;
import org.eb113.essen.dto.Personen;

/**
 *
 * @author koni
 */
@FacesConverter("personenConverter")
public class PersonenConverter implements Converter {

    @Override
    public Person getAsObject(FacesContext fc, UIComponent uic, String string) {
        Personen[] arr = Personen.values();
        
        for(Personen item : arr){
            if(item.toString().equals(string)){
                return item.getPerson();
            }
        }
        
        throw new IllegalStateException("Selected Option not found!");
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

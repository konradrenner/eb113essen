/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.client.converter;

import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.eb113.essen.dto.EssensMoeglichkeit;
import org.eb113.essen.dto.Person;
import org.eb113.essen.dto.PersonFactory;

/**
 *
 * @author koni
 */
@FacesConverter("personenConverter")
public class PersonenConverter implements Converter {

    @Override
    public Person getAsObject(FacesContext fc, UIComponent uic, String string) {
    	Map<Person, EssensMoeglichkeit> all =  PersonFactory.getPersonen();
    	Iterator<Person> iter = all.keySet().iterator();
    	while(iter.hasNext()){
    		Person one = iter.next();
    		if(one.toString().equals(string)){
    			return one;
    		}
    	}
    	
    	throw new IllegalStateException("Selected Option not found!");
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

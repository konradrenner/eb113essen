/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.client;

import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.eb113.essen.dto.EssensAuswahl;
import org.eb113.essen.dto.EssensMoeglichkeiten;
import org.eb113.essen.dto.Personen;
import org.eb113.essen.ejb.EssenBean;
/**
 *
 * @author koni
 */
@SessionScoped
@Named("essen")
public class EssenController implements Serializable {
    @Inject
    EssenBean bean;
    
    int currentIndex;
    
    EssensAuswahl editedItem;
    
    public String getEssensAuswahl(){
        return bean.getActualAuswahl();
    }
    
    public String getBesteller(){
        return bean.getBesteller();
    }
    
    public void store(){
        System.out.println("storing:"+editedItem);
        bean.addAuswahl(editedItem.getPerson(), editedItem.getAuswahl());
    }
    
    public Collection<EssensAuswahl> getEssensWahl(){
        return bean.getGewaehlteMoeglichkeiten();
    }
    
    public SelectItem[] getPersonen(){
        Personen[] arr = Personen.values();
        SelectItem[] ret = new SelectItem[arr.length];
        
        int i=0;
        for(Personen item : arr){
            SelectItem s = new SelectItem(item.toString(),item.toString());
            ret[i++] = s;
        }
        
        return ret;
    }
    
    public SelectItem[] getEssensMoeglichkeiten(){
        EssensMoeglichkeiten[] arr = EssensMoeglichkeiten.values();
        SelectItem[] ret = new SelectItem[arr.length];
        
        int i=0;
        for(EssensMoeglichkeiten item : arr){
            SelectItem s = new SelectItem(item.toString(),item.toString());
            ret[i++] = s;
        }
        
        return ret;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public EssensAuswahl getEditedItem() {
        System.out.println("Lade Item:"+editedItem);
        return editedItem;
    }

    public void setEditedItem(EssensAuswahl editedItem) {
        this.editedItem = editedItem;
    }
    
    
}

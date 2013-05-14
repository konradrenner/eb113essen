/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.dto;

import java.io.Serializable;

/**
 * 
 * @author koni
 */
public class EssensAuswahl implements Serializable, Comparable<EssensAuswahl> {
    private Person person;
    private EssensMoeglichkeit auswahl;

    public EssensAuswahl(){
    	//Test Robert
        this(null,null);
    }
    
    public EssensAuswahl(Person person, EssensMoeglichkeit auswahl) {
        this.person = person;
        this.auswahl = auswahl;
    }

    public Person getPerson() {
        return person;
    }

    public EssensMoeglichkeit getAuswahl() {
        return auswahl;
    }

    public void setPerson(Person person) {
        System.out.println("Person wird gesetzt:"+person);
        this.person = person;
    }

    public void setAuswahl(EssensMoeglichkeit auswahl) {
        System.out.println("Essen wird gesetzt:"+auswahl);
        this.auswahl = auswahl;
    }

    @Override
    public int compareTo(EssensAuswahl o) {
        return this.person.compareTo(o.getPerson());
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.person != null ? this.person.hashCode() : 0);
        hash = 19 * hash + (this.auswahl != null ? this.auswahl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EssensAuswahl other = (EssensAuswahl) obj;
        if (this.person != other.person && (this.person == null || !this.person.equals(other.person))) {
            return false;
        }
        if (this.auswahl != other.auswahl && (this.auswahl == null || !this.auswahl.equals(other.auswahl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EssensAuswahl{" + "person=" + person + ", auswahl=" + auswahl + '}';
    }
    
    
}

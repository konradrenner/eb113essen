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
public class Person implements Comparable<Person>, Serializable {
    private final String vorname;
    private final String nachname;
    private final String kuerzel;
    
    public Person(String vname,String nname,String kuerzel){
        this.vorname = vname;
        this.nachname = nname;
        this.kuerzel = kuerzel;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.kuerzel != null ? this.kuerzel.hashCode() : 0);
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
        final Person other = (Person) obj;
        if ((this.kuerzel == null) ? (other.kuerzel != null) : !this.kuerzel.equals(other.kuerzel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return kuerzel+" - "+vorname+" "+nachname;
    }

    @Override
    public int compareTo(Person o) {
        return this.kuerzel.compareTo(o.getKuerzel());
    }
    
    
}

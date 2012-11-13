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
public class EssensMoeglichkeit implements Comparable<EssensMoeglichkeit>, Serializable {
    private final String bezeichnung;
    private final int wuerfelAugen;
    
    public EssensMoeglichkeit(String bez, int augen){
        this.bezeichnung = bez;
        this.wuerfelAugen = augen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.wuerfelAugen;
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
        final EssensMoeglichkeit other = (EssensMoeglichkeit) obj;
        if (this.wuerfelAugen != other.wuerfelAugen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return wuerfelAugen+" - "+bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getWuerfelAugen() {
        return wuerfelAugen;
    }

    @Override
    public int compareTo(EssensMoeglichkeit o) {
        return this.wuerfelAugen - o.getWuerfelAugen();
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.dto;

import java.util.Random;

/**
 *
 * @author koni
 */
public enum EssensMoeglichkeiten {
    
    KEINEWAHL(100,"Unentschlossen"),
    NICHTANWESEND(101,"Nicht Anwesend"),
    OLIVIA(1,"Sportkantine Sturm"),
    LUTZ(2,"Lutz"),
    BILLA(3,"Billa"),
    KEBAP(4,"Kebap"),            
    OCONNOR(5,"O'Connors"),            
    CHINESE(6,"Chinese"),            
    BESTELLUNG(7,"Bestellung"),  
    STUEBERL(8,"Sportwirt"),            
    TCENTER(9,"T-Center"),            
    KELLER(10,"Keller");
        
    
    private final EssensMoeglichkeit m;
    
    private EssensMoeglichkeiten(int augen, String bez){
        m = new EssensMoeglichkeit(bez, augen);
    }

    public EssensMoeglichkeit getEssensMoeglichkeit() {
        return m;
    }

    @Override
    public String toString() {
        return m.toString();
    }
    
    public static EssensMoeglichkeit getRandomMoeglichkeit(){
        Random random = new Random();
        
        int zahl = random.nextInt(10);
        
        for(EssensMoeglichkeiten keit : values()){
            if(keit.getEssensMoeglichkeit().getWuerfelAugen() == zahl){
                return keit.getEssensMoeglichkeit();
            }
        }
        
        return OCONNOR.getEssensMoeglichkeit();
    }
}

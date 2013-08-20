/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eb113.essen.ejb;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.eb113.essen.dto.EssensAuswahl;
import org.eb113.essen.dto.EssensMoeglichkeit;
import org.eb113.essen.dto.EssensMoeglichkeiten;
import org.eb113.essen.dto.Person;
import org.eb113.essen.dto.Personen;

/**
 * HOWTO Set Timezone on openShift:
 * 
 *Plan A: Via the JBoss java options: export JAVA_OPTS="-Duser.timezone=mytimezone"
 *Plan B: Via a env variable _JAVA_OPTIONS that the JVM would pick up: export _JAVA_OPTIONS="-Duser.timezone=mytimezone"
 * 
 * Europe/Vienna
 * 
 * @author koni
 */
@ApplicationScoped
@Singleton
@Named("essenBean")
public class EssenBean {
    Map<Person, EssensMoeglichkeit> auswahl;
    
    private String actualAuswahl;
    private String besteller;
    
    @PostConstruct
    @Schedule(hour="16", minute="00",timezone="Europe/Vienna")
    public void init(){
        this.auswahl = new ConcurrentHashMap<Person, EssensMoeglichkeit>();
        
        this.auswahl.put(Personen.RENNER.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        this.auswahl.put(Personen.ROHRBOECK.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        this.auswahl.put(Personen.SCHLAGER.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        this.auswahl.put(Personen.SEIDL.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        this.auswahl.put(Personen.WOHLMUTH.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        this.auswahl.put(Personen.GAMAUF.getPerson(), EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit());
        
        this.actualAuswahl = "";
        this.besteller = "";
    }
    
    public void addAuswahl(Person person, EssensMoeglichkeit essen){
        this.auswahl.put(person, essen);
    }
    
    public Collection<EssensAuswahl> getGewaehlteMoeglichkeiten(){
        ArrayList<EssensAuswahl> ret = new ArrayList<EssensAuswahl>(this.auswahl.size());
        for(Person person : this.auswahl.keySet()){
            ret.add(new EssensAuswahl(person, this.auswahl.get(person)));
        }
        
        Collections.sort(ret);
        
        return ret;
    }
    
    @Schedule(hour="9",minute="46", timezone="Europe/Vienna")
    public void berechneAuswahl(){
        
        Map<EssensMoeglichkeit, Integer> auswahlen = new HashMap<EssensMoeglichkeit, Integer>();
        int anzNichtAnwesend = 0;
        for(EssensMoeglichkeit wahl : this.auswahl.values()){
            if(wahl.equals(EssensMoeglichkeiten.NICHTANWESEND.getEssensMoeglichkeit())){
                anzNichtAnwesend++;
            }else if(!wahl.equals(EssensMoeglichkeiten.KEINEWAHL.getEssensMoeglichkeit())){
                if(auswahlen.containsKey(wahl)){
                    Integer anz = auswahlen.get(wahl);
                    anz = anz.intValue()+1;
                    auswahlen.put(wahl, anz);
                }else{
                    auswahlen.put(wahl, 1);
                }
            }
        }

        this.actualAuswahl = null;
        
        float anzAnwesende = ((float)Personen.values().length) - ((float)anzNichtAnwesend);
        float drei = 3;
        float zwei = 2;
        
        float fzweidrittelMehrheit = anzAnwesende/drei*zwei;

        int zweidrittelMehrheit = fzweidrittelMehrheit%((int)fzweidrittelMehrheit) > 0.0 ? ((int)fzweidrittelMehrheit)+1 : (int)fzweidrittelMehrheit;

        for(EssensMoeglichkeit keys : auswahlen.keySet()){
            if(auswahlen.get(keys).intValue() >= zweidrittelMehrheit){
                this.actualAuswahl = keys.toString();
                break;
            }
        }

        if(this.actualAuswahl == null){
            EssensMoeglichkeit wahl;
            
            //Lauter unentschlossene
            if(auswahlen.isEmpty()){
                wahl = EssensMoeglichkeiten.getRandomMoeglichkeit();
            }else{
                wahl = getRandomEssensWahl(auswahlen.keySet());
            }
            this.actualAuswahl = wahl.toString();
        }
        
        if(this.actualAuswahl.equals(EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit().toString())){
            boolean nok = true;
            while(nok){
                Person p = Personen.getRandomBesteller();
                
                //SlaR: Besteller kann nur sein, wer Bestellung ausgwaehlt hat
                if(!this.auswahl.get(p).equals(EssensMoeglichkeiten.BESTELLUNG.getEssensMoeglichkeit())){
                    this.besteller = Personen.getRandomBesteller().toString();
                    nok = false;
                }
            }
        }
    }
    
    public String getActualAuswahl(){
        return this.actualAuswahl;
    }
    
    public String getBesteller(){
        return this.besteller;
    }
    
    private EssensMoeglichkeit getRandomEssensWahl(Set<EssensMoeglichkeit> moegls){
        Random random = new Random();
        
        int zahl = random.nextInt(moegls.size()-1);
        
        return moegls.toArray(new EssensMoeglichkeit[moegls.size()])[zahl];
    }
}

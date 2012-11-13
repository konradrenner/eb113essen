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
public enum Personen {
    GAMAUF(new Person("Benjamin", "Gamauf", "GamB")),
    SCHLAGER(new Person("Robert", "Schlager", "SlaR")),
    RENNER(new Person("Konrad", "Renner", "RenK")),
    ROHRBOECK(new Person("Gerhard", "Rohrboeck", "RohG")),
    SEIDL(new Person("Helmut", "Seidl", "SeHe")),
    WOHLMUTH(new Person("Manfred", "Wohlmuth", "WohM"));
    
    
    private final Person person;
    private Personen(Person p){
        this.person = p;
    }

    @Override
    public String toString() {
        return this.person.getKuerzel()+" - "+this.person.getVorname()+" "+this.person.getNachname();
    }

    public Person getPerson() {
        return person;
    }
    
    public static Person getRandomBesteller(){
        Random random = new Random();
        Person person = values()[random.nextInt(5)].getPerson();
        
        if(person.equals(WOHLMUTH.getPerson())){
            return SCHLAGER.getPerson();
        }
        
        return person;
    }
}

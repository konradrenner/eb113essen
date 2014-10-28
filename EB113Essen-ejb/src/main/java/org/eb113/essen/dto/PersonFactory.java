package org.eb113.essen.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PersonFactory {
	
	private static Map<Person, EssensMoeglichkeit> personen = null;
	private static int anzPersonen = 0;

	public static Map<Person, EssensMoeglichkeit> initPersonEssensMoeglichkeitMap(){
		personen = new ConcurrentHashMap<Person, EssensMoeglichkeit>();
		
		List<Integer> availableIDs = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++){
        	availableIDs.add(i);
        }
        Collections.shuffle(availableIDs);
		personen.put(getRenner(availableIDs.get(0)), EssensMoeglichkeitFactory.getDefaultAuswahl());
        personen.put(getRohrboeck(availableIDs.get(1)), EssensMoeglichkeitFactory.getDefaultAuswahl());
        personen.put(getSeidl(availableIDs.get(3)), EssensMoeglichkeitFactory.getDefaultAuswahl());
        personen.put(getWohlmuth(availableIDs.get(4)), EssensMoeglichkeitFactory.getDefaultAuswahl());
        personen.put(getGamauf(availableIDs.get(5)), EssensMoeglichkeitFactory.getDefaultAuswahl());
        
        anzPersonen = personen.size();
        
        return personen;
	}
	
	public static Person getGamauf(Integer id){
		return new Person(id, "Benjamin", "Gamauf", "GamB");
	}
	
	public static Person getRohrboeck(Integer id){
		return new Person(id, "Gerhard", "Rohrboeck", "RohG");
	}
	
	public static Person getSeidl(Integer id){
		return new Person(id, "Helmut", "Seidl", "SeHe");
	}
	
	public static Person getRenner(Integer id){
		return new Person(id, "Konrad", "Renner", "RenK");
	}
	
	public static Person getWohlmuth(Integer id){
		return new Person(id, "Manfred", "Wohlmuth", "WohM");
	}

	/**
	 * @return the anzPersonen
	 */
	public static int getAnzPersonen() {
		return anzPersonen;
	}
	
	public static Person getRandomBesteller(){
		Random random = new Random();
		Person person = (Person) personen.keySet().toArray()[random.nextInt(5)];
  
		return person;
}

	/**
	 * @return the personen
	 */
	public static Map<Person, EssensMoeglichkeit> getPersonen() {
		return personen;
	}
}

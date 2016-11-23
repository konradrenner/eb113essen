package org.eb113.essen.dto;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PersonFactory {
	
	private static Map<Person, EssensMoeglichkeit> personen = null;
	private static int anzPersonen = 0;

	public static Map<Person, EssensMoeglichkeit> initPersonEssensMoeglichkeitMap(){
            personen = new ConcurrentHashMap<Person, EssensMoeglichkeit>();
            personen.put(getRenner(1), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getRohrboeck(2), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getSeidl(3), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getWohlmuth(4), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getGamauf(5), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getZelinger(6), EssensMoeglichkeitFactory.getDefaultAuswahl());
            personen.put(getBarsoum(7), EssensMoeglichkeitFactory.getDefaultAuswahl());
        
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

    public static Person getBarsoum(Integer id) {
        return new Person(id, "Samih", "Barsoum", "BarS");
    }
	
	public static Person getWohlmuth(Integer id){
		return new Person(id, "Manfred", "Wohlmuth", "WohM");
	}
        
        public static Person getZelinger(Integer id){
		return new Person(id, "Philipp", "Zelinger", "ZelP");
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

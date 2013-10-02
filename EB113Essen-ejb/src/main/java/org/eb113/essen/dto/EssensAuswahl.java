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
        return person.getId().compareTo(o.getPerson().getId());
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auswahl == null) ? 0 : auswahl.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EssensAuswahl other = (EssensAuswahl) obj;
		if (auswahl == null) {
			if (other.auswahl != null)
				return false;
		} else if (!auswahl.equals(other.auswahl))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EssensAuswahl [person=" + person + ", auswahl="
				+ auswahl + "]";
	}
    
}

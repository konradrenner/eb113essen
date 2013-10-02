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
	private final Integer id;
    private final String vorname;
    private final String nachname;
    private final String kuerzel;
    
    public Person(Integer id, String vname,String nname,String kuerzel){
    	this.id = id;
        this.vorname = vname;
        this.nachname = nname;
        this.kuerzel = kuerzel;
    }
    
    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
    public int compareTo(Person o) {
        return this.id.compareTo(o.getId());
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getKuerzel()+" - "+getVorname()+" "+getNachname();
	}
}

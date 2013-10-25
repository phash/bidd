package de.mroedig.bidd.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SpielServer extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8860010591726765645L;
	private String bezeichnung;

	@OneToOne
	private Spiel spiel;

	public Spiel getSpiel() {
		return spiel;
	}

	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}

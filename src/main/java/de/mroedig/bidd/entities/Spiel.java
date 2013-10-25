package de.mroedig.bidd.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Spiel extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8867616379820347654L;

	@NotBlank
	private String spielname;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "spiel")
	private final Set<SpielServer> spielserver = new HashSet<SpielServer>(32);

	public String getSpielname() {
		return spielname;
	}

	public void setSpielname(String spielname) {
		this.spielname = spielname;
	}
}

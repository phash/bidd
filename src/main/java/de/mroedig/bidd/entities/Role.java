package de.mroedig.bidd.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

/**
 * Rollen
 * 
 * @author tom
 * 
 */
@Entity
public class Role extends BasisEntity<Long> {

	public Role() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9016552493492517921L;

	private String springSecurityRoleName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rollen")
	private Set<Benutzer> angehoerigeBenutzer = new HashSet<Benutzer>(10);

	public Role(String springSecurityRoleName) {
		this.springSecurityRoleName = springSecurityRoleName;
	}

	public String getSpringSecurityRoleName() {
		return springSecurityRoleName;
	}

	public Set<Benutzer> getAngehoerigeBenutzer() {
		return angehoerigeBenutzer;
	}

	public void setAngehoerigeBenutzer(Set<Benutzer> angehoerigeBenutzer) {
		this.angehoerigeBenutzer = angehoerigeBenutzer;
	}

}
